package calc;

import static java.lang.Character.isDigit;

public class Calculator {

    private Calculator() {
        /* This utility class should not be instantiated */
    }

    public static final int MAX_DIGITS = 15;
    public static final int MAX_DECIMALS = 10;

    /**
     * Parses and evaluates a simple expression of the form "x" or "x op y", where "x" and "y" are decimal numbers
     * and "op" is "+", "-", "*", or "/". Spaces between or around "x", "y" and "op" are ignored.
     * <p>
     * If "x" or "y" is not a valid number (see {@link #num(String, int)}), the string "invalid number" is returned. If "operator" is not one of the operators listed above, the string
     * "invalid operator" is returned.
     */
    public static String evaluate(String expr) {
        int index;
        int end;
        double firstNumber;
        double secondNumber;
        char operator;

        index = 0;
        end = num(expr, index);

        if (end < 0) {
            return "invalid number";
        }
        firstNumber = Double.parseDouble(expr.substring(index, end));
        index = fastForward(expr, end);

        if (index == expr.length()) {
            return Double.toString(firstNumber);
        }

        operator = expr.charAt(index);
        index++;
        index = fastForward(expr, index);
        end = num(expr, index);

        if (end < 0) {
            return "invalid number";
        }
        secondNumber = Double.parseDouble(expr.substring(index, end));

        switch (operator) {
        case '+' -> {
            return Double.toString(firstNumber + secondNumber);
        }
        case '-' -> {
            return Double.toString(firstNumber - secondNumber);
        }
        case '*' -> {
            return Double.toString(firstNumber * secondNumber);
        }
        case '/' -> {
            return "" + secondNumber / firstNumber;
        }
        default -> {
            return "invalid operator";
        }
        }
    }

    /**
     * @return The index of the first character in 's' that comes after the 'start' index and is not a space.
     */
    private static int fastForward(String s, int start) {
        int index = start;
        while (charFinder(s, index) == ' ') {
            index++;
        }
        return index;
    }

    /**
     * Finds the end of a number in 's', starting at
     * the index 'startIndex'. A number may (in this order) contain: a single minus, zero or more digits, a
     * decimal point, and again zero or more digits. There must be at least one
     * digit, before or after the decimal point.
     *
     * @return The index right after the end of the found number (so it can be used for {@link String#substring(int, int)})
     */
    private static int num(String s, int startIndex) {

        int index = startIndex;

        boolean check = false;
        if (charFinder(s, index) == '-') {
            index++;
        }
        while (isDigit(charFinder(s, index))) {
            index++;
            check = false;
        }
        if (charFinder(s, index) == '.') {
            index++;
            while (isDigit(charFinder(s, index))) {
                index++;
            }
            check = false;
        }
        if (!check) {
            return index;
        } else {
            return -1;
        }
    }

    // Gibt das Nullzeichen (\0) zurück wenn der Index nicht im String liegt
    private static char charFinder(String s, int index) {
        if (index < s.length()) {
            return s.charAt(index);
        } else {
            return '\0';
        }


    }
}
