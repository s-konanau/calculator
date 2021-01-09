package online.javalearn.calculator;

import online.javalearn.calculator.expression.Expression;
import online.javalearn.calculator.expression.parser.ExpressionParser;
import online.javalearn.calculator.expression.symbol.Value;

import java.util.Scanner;

/**
 * A main class.
 */
public class Calculator {

    /**
     * An entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ExpressionParser expressionParser = new ExpressionParser();

        while (true) {

            Expression expression = expressionParser.parse(in.nextLine());
            Value result = expression.compute();
            System.out.println(result.getValue());

        }
    }

}
