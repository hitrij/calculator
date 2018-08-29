package calculator;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
class Calculator {

    String calculate(String[] expression) {
        //проверка не является ли первый знак скобкой
        if (expression[0] != "(") {
            Double result = Double.parseDouble(expression[0]);
        }
        double PrevNum;
        double NextNum;
        Integer Brack_Start;
        Integer Brack_End;

        Brack_Start = 0;
        Brack_End = 0;

        //высчитываем выражение в скобках
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == "(") {
                Brack_Start = i;
            } else if (expression[i] == ")") {
                //в конце скобок начинаются расчёты внутри
                Brack_End = i;
                //вначале умножение и деление и замена результата
                for (int k = Brack_Start + 1; k < Brack_End - 1; k += 2) {
                    String op = expression[k + 1];
                    PrevNum = Double.parseDouble(expression[k]);
                    NextNum = Double.parseDouble(expression[k + 2]);
                    if (op == "*") {
                        expression[k + 2] = String.valueOf(PrevNum * NextNum);
                        expression[k + 1] = "+";
                        expression[k] = "0";
                    } else if (op == "/") {
                        expression[k + 2] = String.valueOf(PrevNum / NextNum);
                        expression[k + 1] = "+";
                        expression[k] = "0";
                    }
                }
                //итоговое вычисление внутри скобок
                double result = Double.parseDouble(expression[Brack_Start + 1]);
                for (int k = Brack_Start + 1; k < Brack_End - 1; k += 2) {
                    String op = expression[k + 1];
                    Double b = Double.parseDouble(expression[k + 2]);
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
                //замена скобок на результат внутри
                if (Brack_Start > 1) {
                    //если перед скобками умножение
                    if (expression[Brack_Start - 1] == "*" || expression[Brack_Start - 1] == "/") {
                        //если после скобок умножение
                        if (expression[Brack_End + 1] == "*" || expression[Brack_End + 1] == "/") {
                            for (int k = Brack_Start; k < Brack_End; k += 2) {
                                expression[k] = "1";
                                expression[k + 1] = "*";
                            }
                            expression[Brack_Start] = String.valueOf(result);
                            expression[Brack_End] = "1";
                            //повторение алгоритма пока не закончатся скобки
                            i = -1;
                            //после скобок сложение
                        } else {
                            for (int k = Brack_Start; k < Brack_End; k += 2) {
                                expression[k] = "0";
                                expression[k + 1] = "+";
                            }
                            expression[Brack_Start] = String.valueOf(result);
                            expression[Brack_End] = "0";
                            //повторение алгоритма пока не закончатся скобки
                            i = -1;
                        }
                        //если перед скобками сложение
                    } else {
                        //если после скобок умножение
                        if (expression[Brack_End + 1] == "*" || expression[Brack_End + 1] == "/") {
                            for (int k = Brack_Start; k < Brack_End; k += 2) {
                                expression[k] = "0";
                                expression[k + 1] = "+";
                            }
                            expression[Brack_End] = String.valueOf(result);
                            expression[Brack_Start] = "0";
                            //повторение алгоритма пока не закончатся скобки
                            i = -1;
                        //если после скобок сложение
                        } else {
                            for (int k = Brack_Start; k < Brack_End; k += 2) {
                                expression[k] = "0";
                                expression[k + 1] = "+";
                            }
                            expression[Brack_Start] = String.valueOf(result);
                            expression[Brack_End] = "0";
                            //повторение алгоритма пока не закончатся скобки
                            i = -1;
                        }
                    }
                //если скобки первые в выражении
                } else {
                    for (int k = Brack_Start; k < Brack_End; k += 2) {
                        expression[k] = "0";
                        expression[k + 1] = "+";
                    }
                    expression[Brack_End] = String.valueOf(result);
                    //повторение алгоритма пока не закончатся скобки
                    i = -1;
                }
            }
        }

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
        Double result = Double.parseDouble(expression[0]);
        for (int i = 1; i < expression.length; i += 2) {
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
