import to.richard.DivideByZeroException;
import to.richard.RPNCalculator;
import to.richard.RPNValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment2 {

    public static final String PROMPT_EXPR = "Enter a postfix expression: ";
    public static final String ERR_SYNTAX = "Error: Bad syntax!";
    public static final String ERR_UNDERFLOW = "Error: Stack underflow!";
    public static final String ERR_OPERANDS = "Error: Too many operands!";
    public static final String ERR_DIVIDE_0 = "Error: Division by 0!";
    public static final String RESULT_MSG = "Answer: ";
    public static final String PROMPT_CONTINUE = "Do you want to enter another expression (y/n): ";

    /**
     * Main application class
     *
     * @param args
     */
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continueProgram = true;

        RPNValidator validator = new RPNValidator();
        RPNCalculator calculator = new RPNCalculator();

        try {
            while(continueProgram){
                System.out.print(PROMPT_EXPR);
                String input = br.readLine();

                if(validator.syntaxError(input))
                    System.out.println(ERR_SYNTAX);
                else if(validator.stackUnderflow(input))
                    System.out.println(ERR_UNDERFLOW);
                else if(validator.tooManyOperands(input))
                    System.out.println(ERR_OPERANDS);
                else {
                    try {
                        Double result = calculator.calc(input);
                        System.out.print(RESULT_MSG);
                        System.out.println(result);
                    } catch(DivideByZeroException e){
                        System.out.println(ERR_DIVIDE_0);
                    }
                }

                System.out.print(PROMPT_CONTINUE);
                String continueAnswer = br.readLine();

                if(!continueAnswer.equals("y")){
                    continueProgram = false;
                }
            }
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
