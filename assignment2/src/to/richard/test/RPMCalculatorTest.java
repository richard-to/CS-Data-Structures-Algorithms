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
        assertEquals(false, validator.syntaxError(input));
    }

    @Test
    public void testBadSyntax(){
        String input = "1 abd 3 + 4 5 * /";
        RPMValidator validator = new RPMValidator();
        assertEquals(true, validator.syntaxError(input));
    }

    @Test
    public void testBadSyntaxNegative(){
        String input = "1 3 + 4 -52 * /";
        RPMValidator validator = new RPMValidator();
        assertEquals(true, validator.syntaxError(input));
    }

    @Test
    public void testValidStackUnderflow(){
        String input = "1 3 + 5 -";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowSqrt(){
        String input = "1 3 + 5 sqrt sqrt -";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowSingleOperand(){
        String input = "15";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowComplexExpression(){
        String input = "11 22 33 44 55 66 77 88 + - sqrt * / / sqrt * +";
        RPMValidator validator = new RPMValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testStackUnderflowError(){
        String input = "11 22 + /";
        RPMValidator validator = new RPMValidator();
        assertEquals(true, validator.stackUnderflow(input));
    }
}
