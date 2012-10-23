import to.richard.*;

public class Assignment3{

    public static final int numCheckoutCounters = 11;

    public static void main(String[] args) throws Exception {

        /**
         * Distribution for customer process time
         */
        Distribution<Integer> custProcTimeDistrib = new Distribution<Integer>();
        custProcTimeDistrib.add(.20, 2).add(.40, 3).add(.60, 4).add(.80, 5).add(1.0, 6);

        /**
         * Distribution for customer flow at time intervals
         */
        Distribution<Integer> custFlowDistrib1 = new Distribution<Integer>();
        custFlowDistrib1.add(.1, 0).add(.5, 1).add(.75, 2).add(.95, 3).add(1.0, 4);

        Distribution<Integer> custFlowDistrib2 = new Distribution<Integer>();
        custFlowDistrib2.add(.1, 0).add(.3, 1).add(.55, 2).add(.8, 3).add(.9, 4).add(1.0, 5);

        Distribution<Integer> custFlowDistrib3 = new Distribution<Integer>();
        custFlowDistrib3.add(.1, 0).add(.4, 1).add(.7, 2).add(.9, 3).add(1.0, 4);

        Distribution<Integer> custFlowDistrib4 = new Distribution<Integer>();
        custFlowDistrib4.add(.05, 0).add(.25, 1).add(.55, 2).add(.80, 3).add(.9, 4).add(1.0, 5);

        Distribution<Integer> custFlowDistrib5 = new Distribution<Integer>();
        custFlowDistrib5.add(.1, 0).add(.5, 1).add(.75, 2).add(.95, 3).add(1.0, 4);


        /**
         * Distribution for time intervals. Not really a distribution, but this
         * will do for now.
         */
        Distribution<Distribution<Integer>> timeDistrib = new Distribution<Distribution<Integer>>();
        timeDistrib.add(180.0, custFlowDistrib1)
                .add(360.0, custFlowDistrib2)
                .add(540.0, custFlowDistrib3)
                .add(780.0, custFlowDistrib4)
                .add(1000.0, custFlowDistrib5);

        /**
         * Checkout counters
         */
        PerformanceMonitor perfMon = new PerformanceMonitor();
        LinkedList<CheckoutCounter> checkoutCounters = new LinkedList<CheckoutCounter>();
        for(int i = 0; i < numCheckoutCounters; i++)
            checkoutCounters.add(new CheckoutCounter(perfMon));
        Supermarket supermarket = new Supermarket(
                timeDistrib, custProcTimeDistrib, checkoutCounters);

        while(!supermarket.isComplete()){
            supermarket.simMinute();
        }

        System.out.println("Test with " + numCheckoutCounters + " checkout counters");
        System.out.println("----------------------------------");
        System.out.println("Total customers: " + perfMon.getTotalCustomers());
        System.out.println("Longest wait time: " + perfMon.getLongestWaitTime() + " minutes");
        System.out.println("Avg wait time: " + perfMon.getAvgWaitTime() + " minutes");
        System.out.println("Avg checkout time: " + perfMon.getAvgCheckoutTime() + " minutes");
    }
}
