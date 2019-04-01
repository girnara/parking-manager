package girnara.abhay.parking.application.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import girnara.abhay.parking.domain.model.ServiceResponse;
import girnara.abhay.parking.domain.model.commons.AbstractConstants;
import girnara.abhay.parking.domain.model.exceptions.NonRecoverableException;
import girnara.abhay.parking.domain.model.exceptions.RecoverableException;

/**
 * Created by abhay on 30/03/19.
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

  /**
   * Non recoverable exception handler response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ResponseBody
	@ExceptionHandler(NonRecoverableException.class)
	ResponseEntity<ServiceResponse> nonRecoverableExceptionHandler(NonRecoverableException ex) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setExceptionCode(ex.getExceptionCode());
		serviceResponse.setStatusMessage(ex.getMessage());
		serviceResponse.setStatus(AbstractConstants.FAILED_STATUS_CODE);
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.BAD_REQUEST);
	}

  /**
   * Recoverable exception handler response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ResponseBody
	@ExceptionHandler(RecoverableException.class)
	ResponseEntity<ServiceResponse> recoverableExceptionHandler(RecoverableException ex) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setExceptionCode(ex.getExceptionCode());
		serviceResponse.setStatusMessage(ex.getMessage());
		serviceResponse.setStatus(AbstractConstants.FAILED_STATUS_CODE);
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

  /**
   * Json exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ResponseBody
	@ExceptionHandler({HttpMessageConversionException.class})
	ResponseEntity<ServiceResponse> jsonException(HttpMessageConversionException ex) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setExceptionCode(AbstractConstants.ExceptionCode.INVALID_REQUEST_ERROR);
		serviceResponse.setStatusMessage(ex.getMessage());
		serviceResponse.setStatus(AbstractConstants.FAILED_STATUS_CODE);
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.BAD_REQUEST);
	}

  /**
   * Generic exception handler response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ResponseBody
	@ExceptionHandler({Throwable.class})
	ResponseEntity<ServiceResponse> genericExceptionHandler(Throwable ex) {
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setExceptionCode(AbstractConstants.ExceptionCode.DOWN_STREAM_SERVICE_ERROR);
		serviceResponse.setStatusMessage(ex.getMessage());
		serviceResponse.setStatus(AbstractConstants.FAILED_STATUS_CODE);
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

  /**
   * Generate bad request exception response entity.
   *
   * @param exceptionCode the exception code
   * @param ex            the ex
   * @return the response entity
   */
  ResponseEntity<ServiceResponse> generateBadRequestException(AbstractConstants.ExceptionCode exceptionCode, Throwable ex){
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setStatus(AbstractConstants.FAILED_STATUS_CODE);
		serviceResponse.setExceptionCode(exceptionCode);
		serviceResponse.setStatusMessage(ex.getMessage());
		return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.BAD_REQUEST);
	}

}
