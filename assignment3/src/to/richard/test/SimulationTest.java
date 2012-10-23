package to.richard.test;

import org.junit.Test;
import to.richard.*;

import static org.junit.Assert.assertEquals;

public class SimulationTest {

    @Test
    public void testCustomerGetMinutesLeft() {
        Customer customer = new Customer(6);
        assertEquals(new Integer(6), new Integer(customer.getMinutesLeft()));
        assertEquals(new Integer(6), new Integer(customer.getMinutesToProcess()));
    }

    @Test
    public void testCustomerGetMinutesToProcess() {
        Customer customer = new Customer(6);
        assertEquals(new Integer(6), new Integer(customer.getMinutesToProcess()));
    }

    @Test
    public void testCustomerIncreaseWaitingTime(){
        Customer customer = new Customer(6);
        customer.increaseWaitTime().increaseWaitTime();
        assertEquals(new Integer(2), new Integer(customer.getMinutesWaiting()));
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
        assertEquals(new Integer(2), new Integer(distribution.get(.74)));
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

    @Test
    public void testCheckoutCounterAdd(){
        CheckoutCounter counter = new CheckoutCounter();
        Customer customer1 = new Customer(6);
        Customer customer2 = new Customer(4);
        assertEquals(true, counter.isEmpty());
        counter.addCustomer(customer1).addCustomer(customer2);
        assertEquals(new Integer(2), new Integer(counter.customersInLine()));
    }

    @Test
    public void testProcessCustomer(){
        CheckoutCounter counter = new CheckoutCounter();
        Customer customer1 = new Customer(2);
        Customer customer2 = new Customer(5);
        counter.addCustomer(customer1).addCustomer(customer2);
        counter.increaseWaitingTime().processCustomer();
        assertEquals(new Integer(1), new Integer(customer1.getMinutesWaiting()));
        assertEquals(new Integer(1), new Integer(customer1.getMinutesLeft()));
        counter.increaseWaitingTime().processCustomer();
        assertEquals(new Integer(2), new Integer(customer1.getMinutesWaiting()));
        assertEquals(new Integer(0), new Integer(customer1.getMinutesLeft()));
        counter.increaseWaitingTime().processCustomer();
        assertEquals(new Integer(2), new Integer(customer1.getMinutesWaiting()));
        assertEquals(new Integer(0), new Integer(customer1.getMinutesLeft()));
        assertEquals(new Integer(3), new Integer(customer2.getMinutesWaiting()));
        assertEquals(new Integer(4), new Integer(customer2.getMinutesLeft()));
    }

    @Test
    public void testSimEmpty(){

        Distribution<Integer> custProcTimeDistrib = new Distribution<Integer>();
        custProcTimeDistrib.add(.20, 2).add(.40, 3).add(.60, 4).add(.80, 5).add(1.0, 6);

        Distribution<Integer> custFlowDistrib1 = new Distribution<Integer>();
        custFlowDistrib1.add(.1, 0).add(.5, 1).add(.75, 2).add(.95, 3).add(1.0, 4);

        Distribution<Integer> custFlowDistrib2 = new Distribution<Integer>();
        custFlowDistrib2.add(.1, 0).add(.3, 1).add(.55, 2).add(.8, 3).add(.9, 4).add(1.0, 5);

        Distribution<Distribution<Integer>> timeDistrib = new Distribution<Distribution<Integer>>();
        timeDistrib.add(20.0, custFlowDistrib1)
                .add(40.0, custFlowDistrib2);

        LinkedList<CheckoutCounter> checkoutCounters = new LinkedList<CheckoutCounter>();
        checkoutCounters.add(new CheckoutCounter());
        Supermarket supermarket = new Supermarket(
                timeDistrib, custProcTimeDistrib, checkoutCounters);
        supermarket.countersEmpty();
    }

    @Test
    public void testSimIsComplete(){

        Distribution<Integer> custProcTimeDistrib = new Distribution<Integer>();
        custProcTimeDistrib.add(1.0, 1);

        Distribution<Integer> custFlowDistrib1 = new Distribution<Integer>();
        custFlowDistrib1.add(1.0, 1);

        Distribution<Integer> custFlowDistrib2 = new Distribution<Integer>();
        custFlowDistrib2.add(1.0, 2);

        Distribution<Distribution<Integer>> timeDistrib = new Distribution<Distribution<Integer>>();
        timeDistrib.add(20.0, custFlowDistrib1)
                .add(40.0, custFlowDistrib2);

        LinkedList<CheckoutCounter> checkoutCounters = new LinkedList<CheckoutCounter>();
        checkoutCounters.add(new CheckoutCounter());
        Supermarket supermarket = new Supermarket(
                timeDistrib, custProcTimeDistrib, checkoutCounters);
        int count = 0;
        while(!supermarket.isComplete()){
            supermarket.simMinute();
            count++;
        }
        assertEquals(new Integer(60), new Integer(count));
    }

    @Test
    public void testSimIsComplete2(){

        Distribution<Integer> custProcTimeDistrib = new Distribution<Integer>();
        custProcTimeDistrib.add(1.0, 40);

        Distribution<Integer> custFlowDistrib1 = new Distribution<Integer>();
        custFlowDistrib1.add(1.0, 1);


        Distribution<Distribution<Integer>> timeDistrib = new Distribution<Distribution<Integer>>();
        timeDistrib.add(5.0, custFlowDistrib1);

        LinkedList<CheckoutCounter> checkoutCounters = new LinkedList<CheckoutCounter>();
        checkoutCounters.add(new CheckoutCounter());
        Supermarket supermarket = new Supermarket(
                timeDistrib, custProcTimeDistrib, checkoutCounters);
        int count = 0;
        while(!supermarket.isComplete()){
            supermarket.simMinute();
            count++;
        }
        assertEquals(new Integer(161), new Integer(count));
    }
}
