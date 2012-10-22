package to.richard;

public class Customer {
    private int minutesToProcess;
    private int minutesLeft;
    private int minutesWaiting;

    public Customer(int minutesToProcess){
        this.minutesToProcess = minutesToProcess;
        this.minutesLeft = minutesToProcess;
        this.minutesWaiting = 0;
    }

    /**
     * Gets minutes left to process customer
     * @return int
     */
    public int getMinutesLeft(){
        return this.minutesLeft;
    }

    /**
     * Checks if customer is finished processing
     * @return boolean
     */
    public boolean isFinished() {
        return (minutesLeft == 0) ? true : false;
    }

    /**
     * Processes customer for interval (1 minute)
     *
     * Decrements a minute from the time needed to process
     * customer. If no minutes left, nothing happens.
     *
     * @return Customer
     */
    public Customer process(){
        if(!isFinished())
            --minutesLeft;
        return this;
    }

    /**
     * Increments waiting time by 1 minute
     * @return Customer
     */
    public Customer increaseWaitTime(){
        minutesWaiting++;
        return this;
    }
}