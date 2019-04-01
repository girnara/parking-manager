package girnara.abhay.parking.application.service;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingService {
  /**
   * Create parking lot parking lot.
   *
   * @param parkingLot the parking lot
   * @param clientId   the client id
   * @return the parking lot
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingLot createParkingLot(ParkingLot parkingLot, String clientId) throws RecoverableException, NonRecoverableException;

  /**
   * Gets parking lot.
   *
   * @param clientId the client id
   * @return the parking lot
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingLot getParkingLot(String clientId) throws RecoverableException, NonRecoverableException;

  /**
   * Park parking ticket.
   *
   * @param clientId the client id
   * @param vehicle  the vehicle
   * @return the parking ticket
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingTicket park(String clientId, Vehicle vehicle) throws RecoverableException, NonRecoverableException;

  /**
   * Un park parking ticket.
   *
   * @param parkingTicketId the parking ticket id
   * @param clientId        the client id
   * @return the parking ticket
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingTicket unPark(String parkingTicketId, String clientId) throws RecoverableException, NonRecoverableException;

  /**
   * Find by registration number parking ticket.
   *
   * @param clientId       the client id
   * @param registrationId the registration id
   * @return the parking ticket
   * @throws NonRecoverableException the non recoverable exception
   * @throws RecoverableException    the recoverable exception
   */
  public ParkingTicket findByRegistrationNumber(String clientId, String registrationId) throws NonRecoverableException, RecoverableException;
}
