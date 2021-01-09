package online.javalearn.calculator.expression.exception;

/**
 * Thrown to indicate that the application has attempted to convert a string
 * to {@link online.javalearn.calculator.expression.Expression}, but
 * that the string does not have the appropriate format.
 */
public class ExpressionParseException extends RuntimeException {

    public ExpressionParseException(String message) {
        super(message);
    }

    public ExpressionParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
