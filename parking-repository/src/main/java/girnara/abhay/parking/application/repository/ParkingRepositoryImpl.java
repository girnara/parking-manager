package girnara.abhay.parking.application.repository;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.ParkingRepository;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by abhay on 30/03/19.
 */
@Service
public class ParkingRepositoryImpl implements ParkingRepository {
  private Map<String, ParkingLot> parkingLotMap = new ConcurrentHashMap<>();
  @Override
  public ParkingLot create(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException {
    parkingLot.setId(UUID.randomUUID().toString());
    if(parkingLotMap.containsKey(clientId)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_ALREADY_EXISTS_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_ALREADY_EXISTS_ERROR);
    }
    parkingLotMap.put(clientId, parkingLot);
    return parkingLotMap.get(clientId);
  }

  @Override
  public Boolean delete(String clientId) throws RecoverableException, NonRecoverableException {
    if(parkingLotMap.containsKey(clientId)) {
      parkingLotMap.remove(clientId);
      return Boolean.TRUE;
    }
    throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_DOES_NOT_EXISTS_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_DOES_NOT_EXISTS_ERROR);
  }

  @Override
  public ParkingLot get(String clientId) throws RecoverableException, NonRecoverableException {
    if(parkingLotMap.containsKey(clientId)) {
      return parkingLotMap.get(clientId);
    }
    throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_DOES_NOT_EXISTS_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_DOES_NOT_EXISTS_ERROR);
  }

  @Override
  public ParkingLot update(String clientId, ParkingLot parkingLot) throws RecoverableException, NonRecoverableException {
    if(!parkingLotMap.containsKey(clientId)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_ALREADY_EXISTS_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_ALREADY_EXISTS_ERROR);
    }
    parkingLotMap.put(clientId, parkingLot);
    return parkingLotMap.get(clientId);
  }

}
