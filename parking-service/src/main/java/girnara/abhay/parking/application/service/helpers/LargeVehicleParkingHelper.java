package girnara.abhay.parking.application.service.helpers;

import girnara.abhay.parking.domain.model.ParkingFloor;
import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.ParkingRepository;
import girnara.abhay.parking.domain.model.commons.ParkingTicketRepository;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.spots.LargeSpot;
import girnara.abhay.parking.domain.model.spots.MotorbikeSpot;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LargeVehicleParkingHelper implements ParkingHelper {
  @Autowired
  private ParkingTicketRepository parkingTicketRepository;
  @Autowired
  private ParkingRepository parkingRepository;

  @Override
  public ParkingTicket unParkTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException {
    List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
    for(ParkingFloor parkingFloor : parkingFloors ) {
      Map<String, LargeSpot> largeParkingSpots = parkingFloor.getLargeSpots();
      if(largeParkingSpots.containsKey(vehicle.getTicket().getParkingSpotId())) {
        LargeSpot largeSpot = largeParkingSpots.get(vehicle.getTicket().getParkingSpotId());
        largeSpot.setVehicle(null);
        largeSpot.setFree(true);
        parkingRepository.update(clientId, parkingLot);
        return vehicle.getTicket();
      }
    }
    throw new NonRecoverableException(AbstractConstants.ExceptionCode.DOWN_STREAM_SERVICE_ERROR.getMessage(), AbstractConstants.ExceptionCode.DOWN_STREAM_SERVICE_ERROR);

  }

  @Override
  public ParkingTicket getTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException {
    List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
    for(ParkingFloor parkingFloor :parkingFloors ) {
      Map<String, LargeSpot> parkingSpots = parkingFloor.getLargeSpots();
      for (Map.Entry<String, LargeSpot> entry : parkingSpots.entrySet()) {
        if (entry.getValue().IsFree()) {
          ParkingTicket parkingTicket = parkingTicketRepository.park(clientId, vehicle, entry.getKey());
          entry.getValue().setFree(false);
          entry.getValue().setVehicle(vehicle);
          parkingLot.setLargeSpotCount(parkingLot.getLargeSpotCount() + 1);
          parkingRepository.update(clientId, parkingLot);
          return parkingTicket;
        }
      }
    }
    throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_FULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_FULL_ERROR);
  }
}
