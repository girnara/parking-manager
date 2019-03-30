package girnara.abhay.parking.application.service.controller;


import girnara.abhay.parking.domain.model.ParkingTicket;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.JsonUtility;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.vehicles.Vehicle;
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


import girnara.abhay.parking.application.service.processor.ParkingRequestProcessor;
import girnara.abhay.parking.domain.model.ServiceResponse;


/**
 * Created by abhay on 30/03/19.
 */
@RestController
@RequestMapping("/v1/parking")
@Slf4j
public class ParkingController {
    @Autowired
    private ParkingRequestProcessor parkingRequestProcessor;
    private static Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ServiceResponse<ParkingTicket>> park(@RequestBody Vehicle vehicle, @PathVariable("clientId") String clientId) throws Exception {
        ServiceResponse<ParkingTicket> serviceResponse = new ServiceResponse<>();
        if(vehicle == null || StringUtils.isEmpty(clientId)) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR.getMessage(), AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR);
        }
        log.info(JsonUtility.toString(vehicle));
        ParkingTicket parkingTicket = parkingRequestProcessor.park(vehicle, clientId);
        log.info(JsonUtility.toString(parkingTicket));
        serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
        serviceResponse.setPayload(parkingTicket);
        serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{clientId}/{parkingTicketId}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<ServiceResponse<ParkingTicket>> unPark( @PathVariable("clientId") String clientId, @PathVariable("parkingTicketId") String parkingTicketId) throws Exception {
        ServiceResponse<ParkingTicket> serviceResponse = new ServiceResponse<>();
        if(StringUtils.isEmpty(clientId) || StringUtils.isEmpty(parkingTicketId)) {
            throw new NonRecoverableException(AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR.getMessage(), AbstractConstants.ExceptionCode.NULL_REQUEST_ERROR);
        }
        log.info(JsonUtility.toString(parkingTicketId));
        ParkingTicket parkingTicket = parkingRequestProcessor.unPark(parkingTicketId, clientId);
        log.info(JsonUtility.toString(parkingTicket));
        serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
        serviceResponse.setPayload(parkingTicket);
        serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
