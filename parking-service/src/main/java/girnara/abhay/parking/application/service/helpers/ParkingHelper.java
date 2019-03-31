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
  public ParkingTicket getTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException;
  public ParkingTicket unParkTicket(String clientId, Vehicle vehicle, ParkingLot parkingLot) throws NonRecoverableException, RecoverableException;
}
