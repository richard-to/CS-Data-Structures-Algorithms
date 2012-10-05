package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.RPMValidator;
import to.richard.Stack;
import to.richard.UnderflowException;

public class RPMCalculatorTest {

    @Test
    public void testValidSyntax(){
        String input = " 1 3 + 4 5 * / 45   sqrt -";
        RPMValidator validator = new RPMValidator();
        assertEquals(true, validator.validateSyntax(input));
    }

    @Test
    public void testBadSyntax(){
        String input = "1 abd 3 + 4 5 * /";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.validateSyntax(input));
    }

    @Test
    public void testBadSyntaxNegative(){
        String input = "1 3 + 4 -52 * /";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.validateSyntax(input));
    }
}
