import java.util.Random;

import to.richard.LinkedList;
import to.richard.Member;
import to.richard.MemberSort;
import to.richard.MemberSortByPoints;

public class BenchmarkMergeSort {
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
        MemberSortByPoints compare = new MemberSortByPoints();
        MemberSort sort = new MemberSort();
        Random rand = new Random();
        for(int i = 0; i < count; i++){
            list.add(new Member(0.0f, rand.nextFloat(), Member.FRESHMAN,  "name" + i));
        }
        long t1 = System.nanoTime();
        sort.sort(list, compare);
        long t2 = System.nanoTime();
        System.out.format("Count: %-7d Time: %d ns %n", count, (t2 - t1));
    }
}
