package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.RPNValidator;
import to.richard.RPNCalculator;

public class RPNCalculatorTest {

    @Test
    public void testValidSyntax(){
        String input = " 1 3 + 4 5 * / 45   sqrt -";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.syntaxError(input));
    }

    @Test
    public void testBadSyntax(){
        String input = "12 3f -";
        RPNValidator validator = new RPNValidator();
        assertEquals(true, validator.syntaxError(input));
    }

    @Test
    public void testBadSyntaxNegative(){
        String input = "1 3 + 4 -52 * /";
        RPNValidator validator = new RPNValidator();
        assertEquals(true, validator.syntaxError(input));
    }

    @Test
    public void testValidStackUnderflow(){
        String input = "1 3 + 5 -";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowSqrt(){
        String input = "1 3 + 5 sqrt sqrt -";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowSingleOperand(){
        String input = "15";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testValidStackUnderflowComplexExpression(){
        String input = "11 22 33 44 55 66 77 88 + - sqrt * / / sqrt * +";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.stackUnderflow(input));
    }

    @Test
    public void testStackUnderflowError(){
        String input = "1 2 * / 3 4 -";
        RPNValidator validator = new RPNValidator();
        assertEquals(true, validator.stackUnderflow(input));
    }

    @Test
    public void testTooManyOperandsValid(){
        String input = "11 22 33 44 55 66 77 88 + - * / / * +";
        RPNValidator validator = new RPNValidator();
        assertEquals(false, validator.tooManyOperands(input));
    }

    @Test
    public void testTooManyOperands(){
        String input = "8 3 + 4 sqrt 6 *";
        RPNValidator validator = new RPNValidator();
        assertEquals(true, validator.tooManyOperands(input));
    }

    @Test
    public void testPostfixCalculation() throws Exception {
        String input = "100 567 -";
        RPNCalculator calc = new RPNCalculator();
        assertEquals(-467.0, calc.calc(input), 0.001);
    }

    @Test
    public void testPostfixCalculation2() throws Exception {
        String input = "100";
        RPNCalculator calc = new RPNCalculator();
        assertEquals(100, calc.calc(input), 0.001);
    }

    @Test
    public void testPostfixCalculation3() throws Exception {
        String input = "16 sqrt";
        RPNCalculator calc = new RPNCalculator();
        assertEquals(4, calc.calc(input), 0.001);
    }

    @Test
    public void testPostfixCalculation4() throws Exception {
        String input = "1 3 + 4 5 * /";
        RPNCalculator calc = new RPNCalculator();
        assertEquals(0.2, calc.calc(input), 0.001);
    }

    @Test
    public void testPostfixCalculation5() throws Exception {
        String input = "36 3 4 5 + sqrt * / sqrt";
        RPNCalculator calc = new RPNCalculator();
        assertEquals(2, calc.calc(input), 0.001);
    }
}
