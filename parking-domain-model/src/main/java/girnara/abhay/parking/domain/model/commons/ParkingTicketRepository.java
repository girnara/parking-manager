package girnara.abhay.parking.domain.model.commons;

import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;

public interface ParkingTicketRepository {
  public ParkingTicket park(String clientId, Vehicle vehicle, String spotId) throws RecoverableException, NonRecoverableException;
  public Vehicle unPark(String clientId, String parkingTicketId) throws RecoverableException, NonRecoverableException;
}
