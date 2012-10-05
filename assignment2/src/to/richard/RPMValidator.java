package to.richard;

/**
 * Validates RPM Input
 */
public class RPMValidator {

    /**
     * Validate syntax of expression
     *
     * @param input
     * @return boolean
     */
    public boolean validateSyntax(String input){
        String[] tokens = input.split(" ");
        for(String token:tokens){
            String trimmedToken = token.trim();
            if(!trimmedToken.isEmpty() && !trimmedToken.matches("(sqrt|[\\-\\+\\*/]{1}|[0-9]+)")){
                return false;
            }
        }
        return true;
    }
}
