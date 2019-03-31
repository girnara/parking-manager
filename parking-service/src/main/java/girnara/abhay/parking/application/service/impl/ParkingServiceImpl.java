package girnara.abhay.parking.application.service.impl;

import girnara.abhay.parking.adapter.client.PaymentServiceClient;
import girnara.abhay.parking.application.service.ParkingHelperFactory;
import girnara.abhay.parking.application.service.ParkingService;
import girnara.abhay.parking.application.service.helpers.ParkingHelper;
import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.ParkingRepository;
import girnara.abhay.parking.domain.model.commons.ParkingTicketRepository;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {
  @Autowired
  private ParkingTicketRepository parkingTicketRepository;
  @Autowired
  private ParkingRepository parkingRepository;
  @Autowired
  private ParkingHelperFactory parkingHelperFactory;
  @Autowired
  private PaymentServiceClient paymentServiceClient;
  @Override
  public ParkingLot createParkingLot(ParkingLot parkingLot, String clientId) throws RecoverableException, NonRecoverableException{
    return parkingRepository.create(clientId, parkingLot);
  }

  @Override
  public ParkingLot getParkingLot(String clientId) throws RecoverableException, NonRecoverableException {
    return parkingRepository.get(clientId);
  }

  @Override
  public ParkingTicket park(String clientId, Vehicle vehicle) throws RecoverableException, NonRecoverableException{
    ParkingLot parkingLot = parkingRepository.get(clientId);
    if(parkingLot.getExistingVehicles().containsKey(vehicle.getRegistrationNumber())) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.VEHICLE_IS_ALREADY_IN_PARKING_ERROR.getMessage(), AbstractConstants.ExceptionCode.VEHICLE_IS_ALREADY_IN_PARKING_ERROR);

    }
    if(parkingLot.getMaxLargeCount() == parkingLot.getLargeSpotCount() && parkingLot.getMaxMotorbikeCount() == parkingLot.getMotorbikeSpotCount() ) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_FULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_FULL_ERROR);
    }
    if((vehicle.getType().equals(AbstractConstants.VehicleType.BUS) || vehicle.getType().equals(AbstractConstants.VehicleType.CAR)) && (parkingLot.getMaxLargeCount() == parkingLot.getLargeSpotCount())) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_FULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_FULL_ERROR);
    }
    ParkingHelper parkingHelper = parkingHelperFactory.getHelperByVehicleType(vehicle.getType());
    ParkingTicket parkingTicket = parkingHelper.getTicket(clientId, vehicle, parkingLot);
    parkingLot.getActiveTickets().put(parkingTicket.getId(), parkingTicket);
    parkingLot.getExistingVehicles().put(vehicle.getRegistrationNumber(), parkingTicket.getId());
    return parkingTicket;
  }

  @Override
  public ParkingTicket unPark(String parkingTicketId, String clientId) throws RecoverableException, NonRecoverableException{
    ParkingLot parkingLot = parkingRepository.get(clientId);
    if(!parkingLot.getActiveTickets().containsKey(parkingTicketId)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_TICKET_INVALID_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_TICKET_INVALID_ERROR);
    }
    Vehicle vehicle = parkingTicketRepository.unPark(clientId, parkingTicketId);
    parkingLot.getExistingVehicles().remove(vehicle.getRegistrationNumber());
    ParkingHelper parkingHelper = parkingHelperFactory.getHelperByVehicleType(vehicle.getType());
    ParkingTicket parkingTicket = parkingHelper.unParkTicket(clientId, vehicle, parkingLot);
    parkingLot.getActiveTickets().remove(parkingTicketId);
    return paymentServiceClient.payableAmount(clientId, parkingLot, parkingTicket);
  }

  @Override
  public ParkingTicket findByRegistrationNumber(String clientId, String vehicleRegistrationNumber) throws NonRecoverableException, RecoverableException {
    ParkingLot parkingLot = parkingRepository.get(clientId);
    if(!parkingLot.getExistingVehicles().containsKey(vehicleRegistrationNumber)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.VEHICLE_DOES_NOT_EXISTS_ERROR.getMessage(), AbstractConstants.ExceptionCode.VEHICLE_DOES_NOT_EXISTS_ERROR);
    }
    return parkingLot.getActiveTickets().get(parkingLot.getExistingVehicles().get(vehicleRegistrationNumber));
  }
}
