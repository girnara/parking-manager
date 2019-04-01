package girnara.abhay.parking.domain.model.exceptions;

import girnara.abhay.parking.domain.model.commons.AbstractConstants;

/**
 * Created by abhay on 30/03/19.
 */
public class NonRecoverableException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2662879568402830555L;

  /**
   * Instantiates a new Non recoverable exception.
   *
   * @param cause         the cause
   * @param message       the message
   * @param exceptionCode the exception code
   */
  public NonRecoverableException(Throwable cause, String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(cause, message, exceptionCode);
    }

  /**
   * Instantiates a new Non recoverable exception.
   *
   * @param message       the message
   * @param exceptionCode the exception code
   */
  public NonRecoverableException(String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }
}
