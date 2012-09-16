package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.Member;
import to.richard.MemberList;

public class MemberListTest {
    @Test
    public void testAdd() throws Exception {
        Member member = new Member("Bob");
        MemberList memberList = new MemberList();
        memberList.add(member);
        assertEquals(member.toString(), memberList.toString());
    }

    @Test
    public void testAddDuplicate() throws Exception {
        Member member = new Member("Bob");
        MemberList memberList = new MemberList();
        memberList.add(member);
        assertEquals(false, memberList.add(member));
        assertEquals(member.toString(), memberList.toString());
    }

    @Test
    public void testContains() throws Exception {
        Member member = new Member("Bob");
        MemberList memberList = new MemberList();
        memberList.add(member);
        assertEquals(true, memberList.contains(member));
    }
}
