package to.richard.test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

import to.richard.*;

import java.io.Console;

public class MemberSortTest {

    private LinkedList<Member> list;
    private MemberSortByPoints compare;

    @Before
    public void setUp() {
        compare = new MemberSortByPoints();
        list = new LinkedList<Member>();
        list.add(new Member(3.0f, 4.0f, Member.FRESHMAN, "Bob"));
        list.add(new Member(8.0f, 1.0f, Member.SENIOR, "Jim"));
        list.add(new Member(20.0f, 10.0f, Member.FRESHMAN, "Rob"));
        list.add(new Member(1.0f, 4.0f, Member.SOPHOMORE, "Larry"));
    }

    @Test
    public void testSort() throws Exception {
        MemberSort memberSort = new MemberSort();
        LinkedList<Member> sortedList = memberSort.sort(list, compare);
        String[] names = new String[]{"Rob", "Bob", "Larry", "Jim"};
        int index = 0;
        LinkedListIter<Member> iter = sortedList.iterator();
        while(iter.hasNext()){
            Member member = iter.next();
            assertEquals(names[index], member.getName());
            index++;
        }
    }
}
