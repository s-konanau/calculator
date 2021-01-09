package online.javalearn.calculator.expression;

import online.javalearn.calculator.expression.parser.Converter;
import online.javalearn.calculator.expression.symbol.Arabic;
import online.javalearn.calculator.expression.symbol.Operation;
import online.javalearn.calculator.expression.symbol.Roman;
import online.javalearn.calculator.expression.symbol.Value;

/**
 * Represent an expression that can be computed.
 */
public class Expression {
    private final Value firstOperand;
    private final Value secondOperand;
    private final Operation operation;

    /**
     * @param firstOperand  an operand at the left side of an operation sign
     * @param secondOperand an operand at the right side of an operation sign
     * @param operation     an arithmetic operation
     */
    public Expression(Value firstOperand, Value secondOperand, Operation operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public Value getFirstOperand() {
        return firstOperand;
    }

    public Value getSecondOperand() {
        return secondOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    /**
     * Evaluates an expression.
     *
     * @return a computed value
     */
    public Value compute() {
        int result = operation
                .compute(firstOperand.intValue(), secondOperand.intValue());

        if (firstOperand.getClass() == Roman.class) {
            String romanValue = Converter.arabicToRoman(result);

            return new Roman(romanValue, result);
        }

        return new Arabic(result);
    }
}
