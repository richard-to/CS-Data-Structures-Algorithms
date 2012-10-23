package to.richard;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Supermarket class to simulate distribution of customers
 */
public class Supermarket {

    /**
     * First distribution is for the time intervals.
     * First distribution will return the
     * correct distribution for customer flow at time.
     */
    Distribution<Distribution<Integer>> timeDistrib;
    Distribution<Integer> custProcTimeDistrib;
    LinkedList<CheckoutCounter> checkoutCounters;
    int minutesElapsed = 0;

    /**
     * The supermarket is considered closed when
     * the custFlowDistrib returns null.
     *
     * This means minutesElapsed has passed distribution range.
     */
    boolean isClosed = false;

    public Supermarket(
            Distribution<Distribution<Integer>> timeDistrib,
            Distribution<Integer> custProcTimeDistrib,
            LinkedList<CheckoutCounter> checkoutCounters){
        this.timeDistrib = timeDistrib;
        this.custProcTimeDistrib = custProcTimeDistrib;
        this.checkoutCounters = checkoutCounters;
    }

    /**
     * Simulates supermarket time one minute
     * @return void
     */
    public void simMinute(){
        if(!isClosed){
            Distribution<Integer> custFlowDistrib = this.timeDistrib.get(minutesElapsed);

            if(custFlowDistrib != null){
                int numCust = custFlowDistrib.get(Math.random());

                for(int i = 0; i < numCust; i++){
                    int processTime = this.custProcTimeDistrib.get(Math.random());
                    Customer cust = new Customer(processTime);

                    CheckoutCounter bestCounter = null;
                    Iterator<CheckoutCounter> iter = checkoutCounters.iterator();
                    while(iter.hasNext()){
                        CheckoutCounter counter = iter.next();
                        if(bestCounter == null ||
                                bestCounter.customersInLine() > counter.customersInLine()) {
                            bestCounter = counter;
                        }
                    }
                    bestCounter.addCustomer(cust);
                }
            } else {
                isClosed = true;
            }
        }

        if(!isComplete()){
            Iterator<CheckoutCounter> iter = checkoutCounters.iterator();
            while(iter.hasNext()){
                CheckoutCounter counter = iter.next();
                counter.increaseWaitingTime();
                counter.processCustomer();
            }
        }
        minutesElapsed++;
    }

    /**
     * Tests if simulation is complete
     * @return boolean
     */
    public boolean isComplete(){
        return (isClosed && countersEmpty()) ? true : false;
    }

    /**
     * Checks if counters are empty
     * @return boolean
     */
    public boolean countersEmpty(){
        Iterator<CheckoutCounter> iter = checkoutCounters.iterator();
        while(iter.hasNext()){
            CheckoutCounter counter = iter.next();
            if(!counter.isEmpty())
                return false;
        }
        return true;
    }

    /**
     * Prints statistics on supermarket performance
     */
    public void printStats(){
        Iterator<CheckoutCounter> iter = checkoutCounters.iterator();
        while(iter.hasNext()){
            CheckoutCounter counter = iter.next();
            System.out.println(counter.customersInLine());
        }
    }
}
