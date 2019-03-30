package girnara.abhay.parking.domain.model.exceptions;

import girnara.abhay.parking.domain.model.commons.AbstractConstants;

/**
 * Created by abhay on 30/03/19.
 */
public class BaseException extends Exception {
    private final String message;
    private final AbstractConstants.ExceptionCode exceptionCode;

    public BaseException(Throwable cause, String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(cause);
        this.message = message;
        this.exceptionCode = exceptionCode;
    }

    public BaseException(String message, AbstractConstants.ExceptionCode exceptionCode) {
        super(message);
        this.message = message;
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    public AbstractConstants.ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

}
