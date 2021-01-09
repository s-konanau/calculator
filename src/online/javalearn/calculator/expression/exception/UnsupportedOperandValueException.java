package online.javalearn.calculator.expression.exception;

/**
 * Thrown to indicate that the value of a operand is out off allowed interval.
 */
public class UnsupportedOperandValueException extends RuntimeException {

    public UnsupportedOperandValueException(String message) {
        super(message);
    }

}
