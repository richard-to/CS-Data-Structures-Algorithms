package to.richard;

/**
 * Checkout Counter queue
 */
public class CheckoutCounter {
    Queue<Customer> queue;

    public CheckoutCounter(){
        queue = new Queue<Customer>();
    }

    /**
     * Adds a customer to checkout counter
     * @param customer
     * @return
     */
    public CheckoutCounter addCustomer(Customer customer){
        queue.enqueue(customer);
        return this;
    }

    /**
     * Checks the number of customers in line
     */
    public int customersInLine(){
        return queue.currentSize();
    }
}
