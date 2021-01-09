package online.javalearn.calculator.expression.exception;

public class ExpressionParseException extends RuntimeException {

    public ExpressionParseException(String message) {
        super(message);
    }

    public ExpressionParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
