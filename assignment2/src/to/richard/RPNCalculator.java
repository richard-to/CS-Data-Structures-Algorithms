package to.richard;

/**
 * Calculates RPM input
 */
public class RPNCalculator {

    /**
     * Calculates valid rpm expression
     *
     * @param input
     * @return result of calculation
     * @throws DivideByZeroException
     */
    public double calc(String input) throws DivideByZeroException {
        Stack<Double> operandStack = new Stack<Double>();
        String[] tokens = input.split(" ");

        for(String token:tokens){
            String trimmedToken = token.trim();
            if(!trimmedToken.isEmpty()){
                if(trimmedToken.matches("[0-9]+")){
                    operandStack.push(new Double(trimmedToken));
                } else if(trimmedToken.equals("sqrt")){
                    Double operator = operandStack.topAndPop();
                    operandStack.push(Math.sqrt(operator));
                } else if(trimmedToken.equals("+")){
                    Double operator2 = operandStack.topAndPop();
                    Double operator1 = operandStack.topAndPop();
                    operandStack.push(operator1 + operator2);
                } else if(trimmedToken.equals("-")){
                    Double operator2 = operandStack.topAndPop();
                    Double operator1 = operandStack.topAndPop();
                    operandStack.push(operator1 - operator2);
                } else if(trimmedToken.equals("*")){
                    Double operator2 = operandStack.topAndPop();
                    Double operator1 = operandStack.topAndPop();
                    operandStack.push(operator1 * operator2);
                } else if(trimmedToken.equals("/")){
                    Double operator2 = operandStack.topAndPop();
                    Double operator1 = operandStack.topAndPop();
                    if(operator2 != 0)
                        operandStack.push(operator1 / operator2);
                    else
                        throw new DivideByZeroException();
                }
            }
        }
        return operandStack.topAndPop();
    }
}
