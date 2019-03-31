package girnara.abhay.parking.domain.model.commons;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
/**
 * Created by abhay on 30/03/19.
 */
public interface ParkingRepository {
  public ParkingLot create(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException;
  public Boolean delete(String clientId) throws RecoverableException, NonRecoverableException;
  public ParkingLot get(String clientId) throws RecoverableException, NonRecoverableException;
  public ParkingLot update(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException;
}
