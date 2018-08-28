package calculator;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        double result = Double.parseDouble(expression[0]);
        double PrevNum;
        double NextNum;

        for (int i = 1; i < expression.length; i += 2) {
            String op = expression[i];
            PrevNum = Double.parseDouble(expression[i - 1]);
            NextNum = Double.parseDouble(expression[i + 1]);
            if (op == "*") {
                expression[i + 1] = String.valueOf(PrevNum * NextNum);
                expression[i] = "+";
                expression[i - 1] = "0";
            } else if (op == "/") {
                expression[i + 1] = String.valueOf(PrevNum / NextNum);
                expression[i] = "+";
                expression[i - 1] = "0";
            }
        }
        for (int i = 1;i < expression.length; i += 2) {
            String op = expression[i];
            Double b = Double.parseDouble(expression[i + 1]);
            switch (op) {
                case "+":
                    result += b;
                    break;
                case "-":
                    result -= b;
                    break;
                default:
                    return "Error";
            }
        }
        return String.valueOf(result);
    }
}
