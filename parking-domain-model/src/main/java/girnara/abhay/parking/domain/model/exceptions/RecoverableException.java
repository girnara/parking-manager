package girnara.abhay.parking.domain.model.exceptions;

import girnara.abhay.parking.domain.model.commons.AbstractConstants;

/**
 * Created by abhay on 30/03/19.
 */
public class RecoverableException extends BaseException {

    public RecoverableException(Throwable cause, String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(cause, message, exceptionCode);
    }

    public RecoverableException(String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }
}
