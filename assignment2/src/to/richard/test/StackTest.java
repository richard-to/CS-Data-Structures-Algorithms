package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.Stack;
import to.richard.UnderflowException;

public class StackTest {

    @Test
    public void testEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPush(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void testPushTwice(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1).push(3);
        assertEquals(new Integer(3), stack.top());
    }

    @Test
    public void testTop(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(new Integer(1), stack.top());
    }

    @Test
    public void testEmptyTop(){
        Stack<Integer> stack = new Stack<Integer>();
        assertEquals(null, stack.top());
    }

    @Test
    public void testPop() throws UnderflowException {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1).pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPopTwice() throws UnderflowException {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1).push(3).push(4).pop().pop();
        assertEquals(new Integer(1), stack.top());
    }

    @Test(expected=UnderflowException.class)
    public void testPopUnderflow() throws UnderflowException{
        Stack<Integer> stack = new Stack<Integer>();
        stack.pop();
    }

    @Test
    public void testTopAndPop() throws UnderflowException {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertEquals(new Integer(1), stack.topAndPop());
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testTopAndPopEmpty() throws UnderflowException {
        Stack<Integer> stack = new Stack<Integer>();
        assertEquals(null, stack.topAndPop());
    }
}
