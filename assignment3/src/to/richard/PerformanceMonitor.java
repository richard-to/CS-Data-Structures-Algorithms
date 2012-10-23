package to.richard;

/**
 * Tracks performance of supermarket checkout counters
 */
public class PerformanceMonitor {
    LinkedList<Customer> trackedCustomers;

    public PerformanceMonitor(){
        trackedCustomers = new LinkedList<Customer>();
    }

    public PerformanceMonitor trackCustomer(Customer customer){
        trackedCustomers.add(customer);
        return this;
    }

    /**
     * Gets total customers
     * @return int
     */
    public int getTotalCustomers(){
        return trackedCustomers.size();
    }

    /**
     * Gets total wait time
     * @return int
     */
    public int getTotalWaitTime(){
        int waitTime = 0;
        Iterator<Customer> iter = trackedCustomers.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            waitTime += customer.getMinutesWaiting();
        }
        return waitTime;
    }

    /**
     * Gets total checkout time
     * @return int
     */
    public int getTotalCheckoutTime(){
        int checkoutTime = 0;
        Iterator<Customer> iter = trackedCustomers.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            checkoutTime += customer.getMinutesToProcess();
        }
        return checkoutTime;
    }

    /**
     * Gets longest wait time
     * @return int
     */
    public int getLongestWaitTime(){
        int longestWait = 0;
        Iterator<Customer> iter = trackedCustomers.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            if(longestWait < customer.getMinutesWaiting()){
                longestWait = customer.getMinutesWaiting();
            }
        }
        return longestWait;
    }

    /**
     * Gets avg wait time
     * @return double
     */
    public double getAvgWaitTime(){
        int totalCustomers = getTotalCustomers();
        int totalWait = getTotalWaitTime();
        return totalWait / totalCustomers;
    }

    /**
     * Gets avg checkout time
     * @return double
     */
    public double getAvgCheckoutTime(){
        int totalCustomers = getTotalCustomers();
        int totalCheckoutTime = getTotalCheckoutTime();
        return totalCheckoutTime / totalCustomers;
    }
}
