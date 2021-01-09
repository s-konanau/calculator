package online.javalearn.calculator.expression.parser;

import online.javalearn.calculator.expression.exception.UnsupportedOperandException;
import online.javalearn.calculator.expression.exception.UnsupportedOperandValueException;
import online.javalearn.calculator.expression.symbol.Arabic;
import online.javalearn.calculator.expression.symbol.Roman;
import online.javalearn.calculator.expression.symbol.Value;

import java.util.Set;

/**
 * Parses an {@link Arabic} or a {@link Roman} value.
 * A value must be between 1 and 10 included or RuntimeException will be thrown.
 */
final class ValueParser {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;
    private final Set<Character> validRomanSymbols =
            Set.of('I', 'V', 'X');

    ValueParser() {
    }

    /**
     * @param value a string representation of a value formed from
     *              Hindi-Arabic or Roman numerals
     * @return a {@link Arabic} or {@link Roman} value
     */
    Value parseValue(String value) {
        boolean isRoman = true;
        int number;

        if (Character.isDigit(value.charAt(0))) {
            number = Integer.parseInt(value);
            isRoman = false;
        } else {

            for (char symbol : value.toCharArray()) {
                if (!validRomanSymbols.contains(symbol)) {
                    throw new UnsupportedOperandException(
                            "Invalid symbol in the operand: " + symbol);
                }
            }

            number = Converter.romanToIntValue(value);
        }

        if (!insideValidInterval(number)) {
            throw new UnsupportedOperandValueException(
                    "Value mast be inside range: [" + MIN_VALUE + ", "
                            + MAX_VALUE + "]. Passed " + number + ".");
        }

        return isRoman ? new Roman(value, number) : new Arabic(number);
    }

    private boolean insideValidInterval(int value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }
}
