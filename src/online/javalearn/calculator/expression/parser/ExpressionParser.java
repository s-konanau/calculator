package online.javalearn.calculator.expression.parser;

import online.javalearn.calculator.expression.Expression;
import online.javalearn.calculator.expression.exception.ExpressionParseException;
import online.javalearn.calculator.expression.exception.IncompatibleOperandsException;
import online.javalearn.calculator.expression.exception.UnsupportedOperationException;
import online.javalearn.calculator.expression.symbol.Operation;
import online.javalearn.calculator.expression.symbol.Value;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Parses an {@link Expression}.
 */
public final class ExpressionParser {
    private static final int FIRST_OPERAND_SYMBOL = 0;
    private static final int OPERATION_SYMBOL = 1;
    private static final int SECOND_OPERAND_SYMBOL = 2;
    private final ValueParser valueParser;
    private final OperationParser operationParser;

    public ExpressionParser() {
        valueParser = new ValueParser();
        operationParser = new OperationParser();
    }

    /**
     * Parses a mathematical expression that consists from two operands
     * that can be written with Roman or Hindu-Arabic numerals and an operation
     * sign.
     * Operands must use the same system and have values from 1 to 10 inclusively.
     * Allowed operations are addition (+), subtraction (-), multiplication (*)
     * and division (/).
     *
     * @param expression a mathematical expression
     * @return an {@link Expression} if a passed expression was be well-formed
     */
    public Expression parse(String expression) {
        String[] symbols = getSymbols(expression);
        Value firstOperand = getOperand(symbols[FIRST_OPERAND_SYMBOL].toUpperCase());
        Value secondOperand = getOperand(symbols[SECOND_OPERAND_SYMBOL].toUpperCase());
        checkOperandsCompatibility(firstOperand, secondOperand);
        Operation operation = getOperation(symbols[OPERATION_SYMBOL]);

        return new Expression(firstOperand, secondOperand, operation);
    }

    private String[] getSymbols(String expression) {
        String[] symbols = expression.trim().split("\\s+");

        if (symbols.length != 3) {
            throw new ExpressionParseException(
                    "Incompatible number of symbols in the expression: "
                            + expression + " . Expression must have 3 symbols.");
        }

        return symbols;
    }

    private Value getOperand(String value) {
        Value operand;

        try {
            operand = valueParser.parseValue(value);
        } catch (RuntimeException ex) {
            throw new ExpressionParseException("Operands can not be parsed.", ex);
        }

        return operand;
    }

    private Operation getOperation(String symbol) {
        Operation operation;

        try {
            operation = operationParser.getOperation(symbol);
        } catch (UnsupportedOperationException ex) {
            String supportedOperationSymbols =
                    Arrays.stream(Operation.values())
                            .map(Operation::getSign)
                            .collect(Collectors.joining(", "));

            throw new ExpressionParseException(
                    "Unsupported operation. The allowed symbols: " + supportedOperationSymbols, ex);
        }

        return operation;
    }

    private void checkOperandsCompatibility(Value a, Value b) {

        if (a.getClass() != b.getClass()) {
            Exception ex = new IncompatibleOperandsException("Incompatible operands: "
                    + a + " and " + b);

            throw new ExpressionParseException(
                    "Operands must be written in the same system of numerical notation", ex);
        }

    }

}
