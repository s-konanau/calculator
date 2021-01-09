package online.javalearn.calculator.expression.exception;

/**
 * Thrown to indicate that the application has attempted to convert an operand
 * from a string, but that the string does not have the appropriate format.
 */
public class UnsupportedOperandException extends RuntimeException {

    public UnsupportedOperandException(String message) {
        super(message);
    }

}
