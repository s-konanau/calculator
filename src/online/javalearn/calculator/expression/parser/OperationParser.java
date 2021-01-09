package online.javalearn.calculator.expression.parser;

import online.javalearn.calculator.expression.exception.UnsupportedOperationException;
import online.javalearn.calculator.expression.symbol.Operation;

/**
 * Parses an {@link Operation}.
 */
final class OperationParser {
    public static final Operation[] operations = Operation.values();

    /**
     * @param sign a symbol denotes an operation
     * @return a representation of an arithmetic operation
     */
    public Operation getOperation(String sign) {

        for (Operation op : operations) {
            if (op.getSign().equals(sign)) {
                return op;
            }
        }

        throw new UnsupportedOperationException("Operation: " + sign);
    }

}
