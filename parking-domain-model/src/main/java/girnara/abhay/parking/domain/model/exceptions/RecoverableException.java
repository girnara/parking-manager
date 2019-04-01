package girnara.abhay.parking.domain.model.exceptions;

import girnara.abhay.parking.domain.model.commons.AbstractConstants;

/**
 * Created by abhay on 30/03/19.
 */
public class RecoverableException extends BaseException {

  /**
   * Instantiates a new Recoverable exception.
   *
   * @param cause         the cause
   * @param message       the message
   * @param exceptionCode the exception code
   */
  public RecoverableException(Throwable cause, String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(cause, message, exceptionCode);
    }

  /**
   * Instantiates a new Recoverable exception.
   *
   * @param message       the message
   * @param exceptionCode the exception code
   */
  public RecoverableException(String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }
}
