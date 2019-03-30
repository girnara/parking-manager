package girnara.abhay.parking.application.repository;

import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.ParkingTicketRepository;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ParkingTicketRepositoryImpl implements ParkingTicketRepository {
  private Map<String, Vehicle> parkingTicketMap = new ConcurrentHashMap<>();
  @Override
  public ParkingTicket park(String clientId, Vehicle vehicle, String spotId) throws RecoverableException, NonRecoverableException {
    ParkingTicket parkingTicket = new ParkingTicket();
    parkingTicket.setId(UUID.randomUUID().toString());
    parkingTicket.setIssueAt(new DateTime(AbstractConstants.DEFAULT_TIME_ZONE));
    parkingTicket.setStatus(AbstractConstants.ParkingTicketStatus.ACTIVE);
    parkingTicket.setTimestamp(new DateTime(AbstractConstants.DEFAULT_TIME_ZONE).getMillis());
    parkingTicket.setParkingSpotId(spotId);
    vehicle.setTicket(parkingTicket);
    parkingTicketMap.put(parkingTicket.getId(), vehicle);
    return parkingTicket;
  }

  @Override
  public Vehicle unPark(String clientId, String ticketId) throws RecoverableException, NonRecoverableException {
    if(!parkingTicketMap.containsKey(ticketId)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_TICKET_INVALID_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_TICKET_INVALID_ERROR);
    }
    Vehicle vehicle = parkingTicketMap.get(ticketId);
    parkingTicketMap.remove(ticketId);
    return vehicle;
  }
}
