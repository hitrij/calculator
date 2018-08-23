package calculator;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        System.out.println(expression[0]);
        System.out.println(expression[1]);
        System.out.println(expression[2]);
        System.out.println(expression[3]);
        System.out.println(expression[4]);
        Double a = Double.parseDouble(expression[0]);
        Double b = Double.parseDouble(expression[2]);

        double result = 0;

        switch (expression[1]) {
            case "+":
                if (expression.length > 4) {
                    Double c = Double.parseDouble(expression[4]);
                    switch (expression[3]) {
                        case "+":
                            result = a + b + c;
                            break;
                        case "-":
                            result = a + b - c;
                            break;
                        case "*":
                            result = a + b * c;
                            break;
                        case "/":
                            result = a + b / c;
                            break;
                        default:
                            return "Error";
                    }
                }else{
                    result = a + b;
                }
                break;
            case "*":
                if (expression.length > 4) {
                    Double c = Double.parseDouble(expression[4]);
                    switch (expression[3]) {
                        case "+":
                            result = a * b + c;
                            break;
                        case "-":
                            result = a * b - c;
                            break;
                        case "*":
                            result = a * b * c;
                            break;
                        case "/":
                            result = a * b / c;
                            break;
                        default:
                            return "Error";
                    }
                }else{
                    result = a * b;
                }
                break;
            case "/":
                if (expression.length > 4) {
                    Double c = Double.parseDouble(expression[4]);
                    switch (expression[3]) {
                        case "+":
                            result = a / b + c;
                            break;
                        case "-":
                            result = a / b - c;
                            break;
                        case "*":
                            result = a / b * c;
                            break;
                        case "/":
                            result = a / b / c;
                            break;
                        default:
                            return "Error";
                    }
                }else{
                    result = a / b;
                }
                break;
            case "-":
                if (expression.length > 4) {
                    Double c = Double.parseDouble(expression[4]);
                    switch (expression[3]) {
                        case "+":
                            result = a - b + c;
                            break;
                        case "-":
                            result = a - b - c;
                            break;
                        case "*":
                            result = a - b * c;
                            break;
                        case "/":
                            result = a - b / c;
                            break;
                        default:
                            return "Error";
                    }
                }else{
                    result = a + b;
                }
                break;
            default:
                return "Error";
        }
        return String.valueOf(result);
    }

}
