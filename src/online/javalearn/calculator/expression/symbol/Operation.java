package online.javalearn.calculator.expression.symbol;

/**
 * The basic arithmetic operations.
 */
public enum Operation {

    ADDITION("+") {
        @Override
        public int compute(int a, int b) {
            return a + b;
        }
    },

    SUBTRACTION("-") {
        @Override
        public int compute(int a, int b) {
            return a - b;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public int compute(int a, int b) {
            return a * b;
        }
    },

    DIVISION("/") {
        @Override
        public int compute(int a, int b) {
            return a / b;
        }
    };

    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    /**
     * @param a an operand at the left side of an operation sign
     * @param b an operand at the right side of an operation sign
     * @return a result of an operation
     */
    public abstract int compute(int a, int b);

    /**
     * @return a symbol denotes an operation
     */
    public String getSign() {
        return sign;
    }
}
