package girnara.abhay.parking.application.service.processor.impl;

import girnara.abhay.parking.application.service.ParkingService;
import girnara.abhay.parking.application.service.processor.ParkingRequestProcessor;
import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Created by abhay on 30/03/19.
 */
@Service
@Slf4j
public class ParkingRequestProcessorImpl implements ParkingRequestProcessor {
    @Autowired
    private ParkingService parkingService;
    @Override
    public ParkingTicket park(Vehicle vehicle, String clientId) throws RecoverableException, NonRecoverableException {
        if(StringUtils.isEmpty(vehicle.getRegistrationNumber())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.VEHICLE_REGISTRATION_NUMBER_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.VEHICLE_REGISTRATION_NUMBER_NULL_ERROR);
        }
        if(ObjectUtils.isEmpty(vehicle.getType())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.VEHICLE_TYPE_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.VEHICLE_TYPE_NULL_ERROR);
        }

        return parkingService.park(clientId, vehicle);
    }

    @Override
    public ParkingTicket unPark(String parkingTicketId, String clientId) throws RecoverableException, NonRecoverableException {
        return parkingService.unPark(parkingTicketId, clientId);
    }

    @Override
    public ParkingLot createParkingLot(ParkingLot parkingLot, String clientId) throws RecoverableException, NonRecoverableException {
        if(CollectionUtils.isEmpty(parkingLot.getEntranceGates())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.ENTRANCE_GATE_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.ENTRANCE_GATE_NULL_ERROR);
        }
        if(CollectionUtils.isEmpty(parkingLot.getExitGates())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.EXIT_GATE_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.EXIT_GATE_NULL_ERROR);
        }
        if(CollectionUtils.isEmpty(parkingLot.getParkingFloors())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_FLOORS_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_FLOORS_NULL_ERROR);
        }
        if(ObjectUtils.isEmpty(parkingLot.getAddress())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_ADDRESS_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_ADDRESS_NULL_ERROR);
        }
        if(ObjectUtils.isEmpty(parkingLot.getParkingRate()) || CollectionUtils.isEmpty(parkingLot.getParkingRate().getDayTypeHourlyRate())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_RATE_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_RATE_NULL_ERROR);
        }
        if(StringUtils.isEmpty(parkingLot.getName())) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.PARKING_LOT_NAME_NULL_ERROR.getMessage(), AbstractConstants.ExceptionCode.PARKING_LOT_NAME_NULL_ERROR);
        }
        return parkingService.createParkingLot(parkingLot, clientId);
    }

    @Override
    public ParkingLot getParkingLot(String clientId) throws RecoverableException, NonRecoverableException {
        return parkingService.getParkingLot(clientId);
    }

    @Override
    public ParkingTicket getParkingTicketByRegistrationNumber(String clientId, String registrationNumber) throws NonRecoverableException, RecoverableException {
        return parkingService.findByRegistrationNumber(clientId, registrationNumber);
    }
}
