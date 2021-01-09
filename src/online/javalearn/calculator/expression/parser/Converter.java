package online.javalearn.calculator.expression.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * A util class for converting numbers from one numeral system to another.
 */
public final class Converter {
    private static final Map<Integer, String> arabicToRoman =
            new HashMap<>(20, 1f);

    static {
        Integer[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

        for (int i = 0; i < arabic.length; i++) {
            arabicToRoman.put(arabic[i], roman[i]);
        }
    }

    /**
     * @param value a number for converting. A value of the number must be
     *              between 1 and 199 included.
     * @return a corresponding number formed with Roman numerals
     */
    public static String arabicToRoman(int value) {

        if (value <= 0) {
            throw new NumberFormatException(value
                    + " can not be represented with the numerical notation" +
                    " based on the Roman system.");
        }

        StringBuilder roman = new StringBuilder(8);
        int place = 1;

        while (value != 0) {
            int digit = value % 10;

            if (digit != 0) {
                roman.insert(0, arabicToRoman.get(digit * place));
            }

            value /= 10;
            place *= 10;
        }

        return roman.toString();
    }

    /**
     * @param value a number formed with Roman numerals
     * @return a corresponding int value
     */
    public static int romanToIntValue(String value) {
        int result = 0;

        for (int i = value.length() - 1; i >= 0; i--) {

            switch (value.charAt(i)) {
                case 'I':
                    if (result >= 5) {
                        result = result - 1;
                    } else {
                        result = result + 1;
                    }
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'X':
                    if (result >= 50) {
                        result = result - 10;
                    } else {
                        result = result + 10;
                    }
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    if (result >= 500) {
                        result = result - 100;
                    } else {
                        result = result + 100;
                    }
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;
            }

        }

        return result;
    }

}
