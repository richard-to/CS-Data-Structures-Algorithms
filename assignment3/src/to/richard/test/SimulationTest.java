package to.richard.test;

import org.junit.Test;
import to.richard.Customer;
import to.richard.Distribution;
import to.richard.Queue;

import static org.junit.Assert.assertEquals;

public class SimulationTest {

    @Test
    public void testCustomerGetMinutesLeft() {
        Customer customer = new Customer(6);
        assertEquals(new Integer(6), new Integer(customer.getMinutesLeft()));
    }

    @Test
    public void testCustomerIsFinished() {
        Customer customer = new Customer(6);
        assertEquals(false, customer.isFinished());
    }

    @Test
    public void testCustomerProcess() {
        Customer customer = new Customer(2);
        customer.process();
        assertEquals(new Integer(1), new Integer(customer.getMinutesLeft()));
        customer.process();
        assertEquals(new Integer(0), new Integer(customer.getMinutesLeft()));
        customer.process();
        assertEquals(new Integer(0), new Integer(customer.getMinutesLeft()));
        assertEquals(true, customer.isFinished());
    }

    @Test
    public void testCustomerProcessDistribution(){
        Distribution<Integer> distribution = new Distribution<Integer>();
        distribution.add(.20, 2).add(.40, 3).add(.60, 4).add(.80, 5).add(1.0, 6);
        assertEquals(new Integer(2), new Integer(distribution.get(0.0)));
        assertEquals(new Integer(3), new Integer(distribution.get(.20)));
        assertEquals(new Integer(4), new Integer(distribution.get(.4)));
        assertEquals(new Integer(5), new Integer(distribution.get(.65)));
        assertEquals(new Integer(6), new Integer(distribution.get(.9)));
    }

    @Test
    public void testCustomerCheckoutDistribution(){
        Distribution<Integer> distribution = new Distribution<Integer>();
        distribution.add(.1, 0).add(.50, 1).add(.75, 2).add(.95, 3).add(1.0, 4);
        assertEquals(new Integer(0), new Integer(distribution.get(0.01)));
        assertEquals(new Integer(1), new Integer(distribution.get(.1)));
        assertEquals(new Integer(2), new Integer(distribution.get(.76)));
        assertEquals(new Integer(3), new Integer(distribution.get(.94)));
        assertEquals(new Integer(4), new Integer(distribution.get(.96)));
    }

    @Test
    public void testTimeDistribution(){
        Distribution<Integer> distribution = new Distribution<Integer>();
        distribution.add(180.0, 0).add(360.0, 1).add(540.0, 2).add(780.0, 3).add(1000.0, 4);
        assertEquals(new Integer(0), new Integer(distribution.get(0)));
        assertEquals(new Integer(1), new Integer(distribution.get(180)));
        assertEquals(new Integer(2), new Integer(distribution.get(361)));
        assertEquals(new Integer(3), new Integer(distribution.get(600)));
        assertEquals(new Integer(4), new Integer(distribution.get(999)));
    }
}
