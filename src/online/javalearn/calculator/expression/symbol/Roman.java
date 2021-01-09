package online.javalearn.calculator.expression.symbol;

import java.util.Objects;

/**
 * Represents a value in the Roman numeral system.
 */
public class Roman implements Value {
    private final String value;
    private final int intValue;

    /**
     * @param value    a value in the Roman numeral system (ex. I, IX)
     * @param intValue a value in the Hindu-Arabic numeral system (ex. 1, 9)
     */
    public Roman(String value, int intValue) {
        this.value = value;
        this.intValue = intValue;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int intValue() {
        return intValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, intValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != Roman.class) {
            return false;
        }

        Roman other = (Roman) obj;

        return Objects.equals(this.value, other.value)
                && this.intValue == other.intValue();
    }

    @Override
    public String toString() {
        return "Roman{value:" + value + "," + intValue + "}";
    }
}
