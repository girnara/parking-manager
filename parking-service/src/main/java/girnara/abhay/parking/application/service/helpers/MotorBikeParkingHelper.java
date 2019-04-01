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

/**
 * Created by abhay on 30/03/19.
 */
@Service
public class MotorBikeParkingHelper implements ParkingHelper {
  @Autowired
  private ParkingTicketRepository parkingTicketRepository;
  @Autowired
  private ParkingRepository parkingRepository;

  @Override
  public ParkingTicket unParkTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException {
    List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
    for(ParkingFloor parkingFloor : parkingFloors ) {
      Map<String, MotorbikeSpot> parkingSpots =parkingFloor.getMotorbikeSpots();
      if(parkingSpots.containsKey(vehicle.getTicket().getParkingSpotId())) {
        MotorbikeSpot motorbikeSpot = parkingSpots.get(vehicle.getTicket().getParkingSpotId());
        motorbikeSpot.setVehicle(null);
        motorbikeSpot.setFree(true);
        parkingRepository.update(clientId, parkingLot);
        return vehicle.getTicket();
      }
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

  /**
   * Park helper for motor bike in large spot parking ticket.
   *
   * @param clientId   the client id
   * @param vehicle    the vehicle
   * @param parkingLot the parking lot
   * @return the parking ticket
   * @throws NonRecoverableException the non recoverable exception
   * @throws RecoverableException    the recoverable exception
   */
  public ParkingTicket parkHelperForMotorBikeInLargeSpot(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException {
    List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
    for(ParkingFloor parkingFloor : parkingFloors ) {
      Map<String, LargeSpot> parkingSpots = parkingFloor.getLargeSpots();
      for (Map.Entry<String, LargeSpot> entry : parkingSpots.entrySet()) {
        if (entry.getValue().IsFree()) {
          ParkingTicket parkingTicket = parkingTicketRepository.park(clientId, vehicle, entry.getKey());
          entry.getValue().setFree(false);
          entry.getValue().setVehicle(vehicle);
          parkingLot.setLargeSpotCount(parkingLot.getMotorbikeSpotCount() + 1);
          parkingRepository.update(clientId, parkingLot);
          return parkingTicket;
        }
      }
    }
    throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_FULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_FULL_ERROR);
  }

  @Override
  public ParkingTicket getTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException {
    List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
    for(ParkingFloor parkingFloor :parkingFloors ) {
      Map<String, MotorbikeSpot> parkingSpots =parkingFloor.getMotorbikeSpots();
      for (Map.Entry<String, MotorbikeSpot> entry : parkingSpots.entrySet()) {
        if(entry.getValue().IsFree()) {
          ParkingTicket parkingTicket  = parkingTicketRepository.park(clientId, vehicle, entry.getKey());
          entry.getValue().setFree(false);
          entry.getValue().setVehicle(vehicle);
          parkingLot.setMotorbikeSpotCount(parkingLot.getMotorbikeSpotCount() + 1);
          parkingRepository.update(clientId, parkingLot);
          return parkingTicket;
        }
      }
    }
    return parkHelperForMotorBikeInLargeSpot(clientId, vehicle, parkingLot);
  }
}
