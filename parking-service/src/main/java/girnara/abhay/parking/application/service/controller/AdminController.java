package girnara.abhay.parking.application.service.controller;


import girnara.abhay.parking.application.service.processor.ParkingRequestProcessor;
import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.ServiceResponse;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.JsonUtility;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by abhay on 30/03/19.
 */
@RestController
@RequestMapping("/v1/admin")
@Slf4j
public class AdminController {
    @Autowired
    private ParkingRequestProcessor parkingRequestProcessor;
    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ServiceResponse<ParkingLot>> getReportsAll(@RequestBody ParkingLot parkingLot, @PathVariable("clientId") String clientId) throws Exception {
        ServiceResponse<ParkingLot> serviceResponse = new ServiceResponse<>();
        if(parkingLot == null || StringUtils.isEmpty(clientId)) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR.getMessage(), AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR);
        }
        log.info(JsonUtility.toString(parkingLot));
        ParkingLot parkingServiceResponse = parkingRequestProcessor.createParkingLot(parkingLot, clientId);
        log.info(JsonUtility.toString(parkingServiceResponse));
        serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
        serviceResponse.setPayload(parkingServiceResponse);
        serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ServiceResponse<ParkingLot>> getParkingLot(@PathVariable("clientId") String clientId) throws Exception {
        ServiceResponse<ParkingLot> serviceResponse = new ServiceResponse<>();
        if(StringUtils.isEmpty(clientId)) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR.getMessage(), AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR);
        }
        log.info(JsonUtility.toString(clientId));
        ParkingLot parkingServiceResponse = parkingRequestProcessor.getParkingLot(clientId);
        log.info(JsonUtility.toString(parkingServiceResponse));
        serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
        serviceResponse.setPayload(parkingServiceResponse);
        serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}/vehicles/{vehicleRegistrationNumber}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ServiceResponse<ParkingTicket>> getParkingTicket(@PathVariable("clientId") String clientId, @PathVariable("vehicleRegistrationNumber") String vehicleRegistrationNumber) throws Exception {
        ServiceResponse<ParkingTicket> serviceResponse = new ServiceResponse<>();
        if(StringUtils.isEmpty(clientId) || StringUtils.isEmpty(vehicleRegistrationNumber)) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR.getMessage(), AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR);
        }
        log.info(JsonUtility.toString(clientId));
        ParkingTicket parkingTicket = parkingRequestProcessor.getParkingTicketByRegistrationNumber(clientId, vehicleRegistrationNumber);
        log.info(JsonUtility.toString(parkingTicket));
        serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
        serviceResponse.setPayload(parkingTicket);
        serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
