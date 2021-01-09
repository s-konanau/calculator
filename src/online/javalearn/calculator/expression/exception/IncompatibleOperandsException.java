package online.javalearn.calculator.expression.exception;

/**
 * Thrown to indicate that operands use a different numeric notation.
 */
public class IncompatibleOperandsException extends RuntimeException {

    public IncompatibleOperandsException(String message) {
        super(message);
    }

}
