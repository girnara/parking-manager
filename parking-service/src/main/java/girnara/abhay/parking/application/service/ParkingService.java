package girnara.abhay.parking.application.service;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

public interface ParkingService {
  public ParkingLot createParkingLot(ParkingLot parkingLot, String clientId) throws RecoverableException, NonRecoverableException;
  public ParkingLot getParkingLot(String clientId) throws RecoverableException, NonRecoverableException;
  public ParkingTicket park(String clientId, Vehicle vehicle) throws RecoverableException, NonRecoverableException;
  public ParkingTicket unPark(String parkingTicketId, String clientId) throws RecoverableException, NonRecoverableException;
  public ParkingTicket findByRegistrationNumber(String clientId, String registrationId) throws NonRecoverableException, RecoverableException;
}
