package girnara.abhay.parking.domain.model.commons;

import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingTicketRepository {
  /**
   * Park parking ticket.
   *
   * @param clientId the client id
   * @param vehicle  the vehicle
   * @param spotId   the spot id
   * @return the parking ticket
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingTicket park(String clientId, Vehicle vehicle, String spotId) throws RecoverableException, NonRecoverableException;

  /**
   * Un park vehicle.
   *
   * @param clientId        the client id
   * @param parkingTicketId the parking ticket id
   * @return the vehicle
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public Vehicle unPark(String clientId, String parkingTicketId) throws RecoverableException, NonRecoverableException;
}
