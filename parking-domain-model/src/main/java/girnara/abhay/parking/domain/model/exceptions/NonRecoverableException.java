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

	public NonRecoverableException(Throwable cause, String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(cause, message, exceptionCode);
    }

    public NonRecoverableException(String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }
}
