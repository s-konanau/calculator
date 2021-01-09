package online.javalearn.calculator.expression.exception;

/**
 * Thrown to indicate that the requested arithmetic operation is not supported.
 */
public class UnsupportedOperationException extends RuntimeException {

    public UnsupportedOperationException(String message) {
        super(message);
    }

}
