package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.RPMValidator;
import to.richard.Stack;
import to.richard.UnderflowException;

public class RPMCalculatorTest {

    @Test
    public void testValidSyntax(){
        String input = "1 3 + 4 5 * /";
        RPMValidator validator = new RPMValidator();
        assertEquals(true, validator.validateSyntax(input));
    }
}
