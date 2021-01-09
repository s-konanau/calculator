package online.javalearn.calculator.expression.symbol;

import java.util.Objects;

/**
 * Represents a value in the Hindu-Arabic numeral system.
 */
public class Arabic implements Value {
    private final int value;

    /**
     * @param value a value in the Hindu-Arabic numeral system (ex. 1, 9)
     */
    public Arabic(int value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return Integer.toString(value);
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != Arabic.class) {
            return false;
        }

        Arabic other = (Arabic) obj;

        return this.value == other.value;
    }

    @Override
    public String toString() {
        return "Arabic{value:" + value + "}";
    }
}
