package to.richard;

/**
 * Checkout Counter queue
 */
public class CheckoutCounter {
    Queue<Customer> queue;
    LinkedList<Customer> list;
    Customer customer;
    PerformanceMonitor perfMon;

    public CheckoutCounter(PerformanceMonitor perfMon){
        queue = new Queue<Customer>();
        list = new LinkedList<Customer>();
        this.perfMon = perfMon;
    }

    /**
     * Adds a customer to checkout counter
     * @param customer
     * @return CheckCounter
     */
    public CheckoutCounter addCustomer(Customer customer){
        queue.enqueue(customer);
        list.add(customer);
        return this;
    }

    /**
     * Checks the number of customers in line
     * @return int
     */
    public int customersInLine(){
        return queue.currentSize();
    }

    /**
     * Checks if checkout line is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return customersInLine() == 0 ? true : false;
    }

    /**
     * Increments customer wait time
     * @return CheckoutCounter
     */
    public CheckoutCounter increaseWaitingTime(){
        Iterator<Customer> iter = list.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            customer.increaseWaitTime();
        }
        return this;
    }

    /**
     * Processes customer at front of line
     * @return CheckoutCounter
     */
    public CheckoutCounter processCustomer() {
        if(customer == null && !queue.isEmpty()){
            customer = queue.dequeue();
        }

        if(customer != null){
            customer.process();
            if(customer.isFinished()){
                list.remove(customer);
                perfMon.trackCustomer(customer);
                customer = null;
            }
        }

        return this;
    }

    /**
     * Gets current customer
     * @return Customer
     */
    public Customer getCurrentCustomer(){
        return customer;
    }
}
