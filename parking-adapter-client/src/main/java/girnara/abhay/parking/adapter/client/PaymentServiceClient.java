package girnara.abhay.parking.adapter.client;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingRate;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

@Service
public class PaymentServiceClient {
  private static final long HOUR_MILLI_SECONDS = 60*60;
  public ParkingTicket payableAmount(String clientId, ParkingLot parkingLot, ParkingTicket parkingTicket) throws NonRecoverableException, RecoverableException {
    long timestamp = new DateTime(AbstractConstants.DEFAULT_TIME_ZONE).getMillis();
    long totalTime = (timestamp - parkingTicket.getTimestamp())/1000;
    long numberOfHours = totalTime/HOUR_MILLI_SECONDS;
    numberOfHours = +1;// Additional one hour (for decimal values)
    ParkingRate parkingRate = parkingLot.getParkingRate();
    if(!ObjectUtils.isEmpty(parkingRate) && !CollectionUtils.isEmpty(parkingRate.getDayTypeHourlyRate())) {
      double hourlyRate = parkingRate.getDayTypeHourlyRate().get(AbstractConstants.DayType.DEFAULT);
      parkingTicket.setPayedAmount(numberOfHours * hourlyRate);

    }
    if(! (parkingTicket.getPayedAmount() > 0)) {
      parkingTicket.setPayedAmount(AbstractConstants.DEFAULT_PARKING_FEE);
    }
    parkingTicket.setStatus(AbstractConstants.ParkingTicketStatus.PAID);
    return parkingTicket;
  }
}