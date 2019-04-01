package girnara.abhay.parking.application.service.helpers;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingHelper {
  /**
   * Gets ticket.
   *
   * @param clientId   the client id
   * @param vehicle    the vehicle
   * @param parkingLot the parking lot
   * @return the ticket
   * @throws NonRecoverableException the non recoverable exception
   * @throws RecoverableException    the recoverable exception
   */
  public ParkingTicket getTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException;

  /**
   * Un park ticket parking ticket.
   *
   * @param clientId   the client id
   * @param vehicle    the vehicle
   * @param parkingLot the parking lot
   * @return the parking ticket
   * @throws NonRecoverableException the non recoverable exception
   * @throws RecoverableException    the recoverable exception
   */
  public ParkingTicket unParkTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException;
}
