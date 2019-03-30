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
    public ParkingTicket park(Vehicle vehicle, String clientId) throws RecoverableException, NonRecoverableException;
    public ParkingTicket unPark(String parkingTicketId, String clientId) throws RecoverableException, NonRecoverableException;
    public ParkingLot createParkingLot(ParkingLot parkingLot, String clientId) throws RecoverableException, NonRecoverableException;
}
