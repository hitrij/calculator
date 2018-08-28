package calculator;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {

        for (int i = 1; i < expression.length; i += 2) {
            String op = expression[i];
            Double a = Double.parseDouble(expression[i - 1]);
            Double b = Double.parseDouble(expression[i + 1]);
            if (op == "*") {
                expression[i - 1] = String.valueOf(a * b);
                expression[i] = "+";
                if (expression.length <= i + 2) {
                    if (expression[i + 2] == "*" || expression[i + 2] == "/") {
                        expression[i + 1] = "1";
                    } else {
                        expression[i + 1] = "0";
                    }
                } else if (op == "/") {
                    expression[i - 1] = String.valueOf(a / b);
                    expression[i] = "+";
                    if (expression[i + 2] == "*" || expression[i + 2] == "/") {
                        expression[i + 1] = "1";
                    } else {
                        expression[i + 1] = "0";
                    }
                }
            }
        }
        double result = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i += 2) {
            String op = expression[i];
            Double b = Double.parseDouble(expression[i + 1]);
            if (op == "+") {
                result += b;
            } else if (op == "-") {
                result -= b;
            }
        }

        return String.valueOf(result);
    }
}
