package online.javalearn.calculator.expression.symbol;

/**
 * An operand in an expression or a result of an expression.
 */
public interface Value {

    /**
     * Returns value that can be used for representation.
     *
     * @return String representation of the value
     */
    String getValue();

    /**
     * Returns value that can be used for computations.
     *
     * @return integral value
     */
    int intValue();

}
