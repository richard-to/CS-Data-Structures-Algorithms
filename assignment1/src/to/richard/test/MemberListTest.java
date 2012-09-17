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

    @Test
    public void testDropUnderPerforming() throws Exception {
        Member member1 = new Member(15.0f, 60.0f, Member.SOPHOMORE, "Bob");
        Member member2 = new Member(15.0f, 60.0f, Member.SOPHOMORE, "Joe");
        Member member3 = new Member(30.0f, 60.5f, Member.SOPHOMORE, "Jim");
        Member member4 = new Member(15.0f, 60.0f, Member.SOPHOMORE, "Bill");
        Member member5 = new Member(15.0f, 60.0f, Member.SOPHOMORE, "Moe");

        MemberList memberList = new MemberList();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        memberList.add(member5);

        MemberList dropList = memberList.dropUnderPerforming();
        assertEquals(4, memberList.size());
        assertEquals(1, dropList.size());
        assertEquals(false, memberList.contains(member3));
        assertEquals(true, dropList.contains(member3));
    }
}
