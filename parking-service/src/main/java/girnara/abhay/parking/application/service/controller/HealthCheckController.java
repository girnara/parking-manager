package girnara.abhay.parking.application.service.controller;

import girnara.abhay.parking.domain.model.ParkingLot;
import girnara.abhay.parking.domain.model.ServiceResponse;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.commons.JsonUtility;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
@Slf4j
public class HealthCheckController {

  @RequestMapping(value = "/{secretKey}", method = RequestMethod.GET, produces = "application/json")
  public ResponseEntity<ServiceResponse<String>> getParkingLot(@PathVariable("secretKey") String secretKey) throws Exception {
    ServiceResponse<String> serviceResponse = new ServiceResponse<>();
    if(StringUtils.isEmpty(secretKey) || !secretKey.equals(AbstractConstants.SECRET_KEY)) {
      throw new NonRecoverableException(AbstractConstants.ExceptionCode.UNAUTHORISED_ACCESS_ERROR.getMessage(), AbstractConstants.ExceptionCode.UNAUTHORISED_ACCESS_ERROR);
    }
    log.info(JsonUtility.toString(secretKey));
    serviceResponse.setStatus(AbstractConstants.SUCCESS_STATUS_CODE);
    serviceResponse.setPayload("Application is up and running");
    serviceResponse.setStatusMessage(AbstractConstants.ExceptionCode.NONE.getMessage());
    return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
  }

}
