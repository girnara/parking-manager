package girnara.abhay.parking.application.service.processor;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingRequestProcessor {
  /**
   * Park parking ticket.
   *
   * @param vehicle  the vehicle
   * @param clientId the client id
   * @return the parking ticket
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingTicket park(Vehicle vehicle, String clientId) throws RecoverableException, NonRecoverableException;

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
   * Gets parking ticket by registration number.
   *
   * @param clientId           the client id
   * @param registrationNumber the registration number
   * @return the parking ticket by registration number
   * @throws NonRecoverableException the non recoverable exception
   * @throws RecoverableException    the recoverable exception
   */
  public ParkingTicket getParkingTicketByRegistrationNumber(String clientId, String registrationNumber) throws NonRecoverableException, RecoverableException;
}
