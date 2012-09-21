import to.richard.LinkedList;
import to.richard.Member;

public class BenchmarkLinkedList {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            System.out.println("Run " + i);
            benchmark(1000);
            benchmark(10000);
            benchmark(100000);
        }
    }

    public static void benchmark(int count){
        LinkedList<Member> list = new LinkedList<Member>();
        long t1 = System.nanoTime();
        for(int i = 0; i < count; i++){
            list.add(new Member("name" + i));
        }
        long t2 = System.nanoTime();
        System.out.format("Count: %-7d Time: %d ns %n", count, (t2 - t1));
    }
}
