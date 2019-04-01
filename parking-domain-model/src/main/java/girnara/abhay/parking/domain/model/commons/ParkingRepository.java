package girnara.abhay.parking.domain.model.commons;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;

/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingRepository {
  /**
   * Create parking lot.
   *
   * @param clientId   the client id
   * @param parkingLot the parking lot
   * @return the parking lot
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingLot create(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException;

  /**
   * Delete boolean.
   *
   * @param clientId the client id
   * @return the boolean
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public Boolean delete(String clientId) throws RecoverableException, NonRecoverableException;

  /**
   * Get parking lot.
   *
   * @param clientId the client id
   * @return the parking lot
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingLot get(String clientId) throws RecoverableException, NonRecoverableException;

  /**
   * Update parking lot.
   *
   * @param clientId   the client id
   * @param parkingLot the parking lot
   * @return the parking lot
   * @throws RecoverableException    the recoverable exception
   * @throws NonRecoverableException the non recoverable exception
   */
  public ParkingLot update(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException;
}
