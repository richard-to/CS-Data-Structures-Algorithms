package to.richard;

/**
 * Validates RPM Input
 */
public class RPNValidator {

    /**
     * Checks for syntax error
     *
     * @param input
     * @return boolean
     */
    public boolean syntaxError(String input){
        String[] tokens = input.split(" ");
        for(String token:tokens){
            String trimmedToken = token.trim();
            if(!trimmedToken.isEmpty() && !trimmedToken.matches("(sqrt|[\\-\\+\\*/]{1}|[0-9]+)")){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for stack underflow
     *
     * @param input
     * @return boolean
     */
    public boolean stackUnderflow(String input){
        String[] tokens = input.split(" ");

        int operators = 0;
        int operands = 0;

        for(String token:tokens){
            String trimmedToken = token.trim();
            if(!trimmedToken.isEmpty()){
                if(trimmedToken.equals("sqrt")){
                    if(operands == 0){
                        return true;
                    }
                }else if(trimmedToken.matches("[\\-\\+\\*/]{1}")){
                    operators++;
                } else if(trimmedToken.matches("[0-9]+")){
                    operands++;
                }

                if((operators > 0 || operands > 0) && operands <= operators){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for too many operands
     *
     * @param input
     * @return boolean
     */
    public boolean tooManyOperands(String input){
        String[] tokens = input.split(" ");

        int operators = 0;
        int operands = 0;

        for(String token:tokens){
            String trimmedToken = token.trim();
            if(!trimmedToken.isEmpty() && !trimmedToken.equals("sqrt")){
                if(trimmedToken.matches("[\\-\\+\\*/]{1}"))
                    operators++;
                else if(trimmedToken.matches("[0-9]+"))
                    operands++;
            }
        }

        if(operands - operators > 1)
            return true;
        else
            return false;
    }
}
