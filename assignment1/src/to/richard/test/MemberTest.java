package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.Member;

public class MemberTest {
    @Test
    public void testGetStanding() throws Exception {
        Member member = new Member(0.0f, 0.0f, Member.FRESHMAN, "Bob");
        assertEquals(Member.FRESHMAN, member.getStanding());
    }

    @Test
    public void testGetName() throws Exception {
        Member member = new Member(0.0f, 0.0f, Member.FRESHMAN, "Bob");
        assertEquals("Bob", member.getName());
    }

    @Test
    public void testGetPointsEarned() throws Exception {
        Member member = new Member(8.6f, 2.6f, Member.FRESHMAN, "Bob");
        assertEquals(2.6f, member.getPointsEarned(), 0.0);
    }

    @Test
    public void testGetHoursAttempted() throws Exception {
        Member member = new Member(1.5f, 4.5f, Member.FRESHMAN, "Bob");
        assertEquals(1.5f, member.getHoursAttempted(), 0.0);
    }

    @Test
    public void testEquals() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, Member.FRESHMAN, "Bob");
        Member member2 = new Member(1.5f, 4.5f, Member.SOPHOMORE, "Bob");

        assertEquals(true, member1.equals(member1));
        assertEquals(true, member1.equals(member2));
    }

    @Test
    public void testNotEquals() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, Member.SOPHOMORE, "Bob");
        Member member2 = new Member(1.5f, 4.5f, Member.FRESHMAN, "Bob Three");
        assertEquals(false, member1.equals(member2));
    }

    @Test
    public void testIsNamed() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, Member.SOPHOMORE, "Bob");
        assertEquals(true, member1.isNamed("Bob"));
    }

    @Test
    public void testUpdateGrades() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, Member.SOPHOMORE, "Bob");
        member1.updateGrades(1.5f, 3f);
        assertEquals(3f, member1.getHoursAttempted(), 0.0);
        assertEquals(7.5f, member1.getPointsEarned(), 0.0);
    }

    @Test
    public void testUpdateStanding() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, Member.SOPHOMORE, "Bob");
        member1.updateGrades(1.5f, 34f).updateStanding();
        assertEquals(Member.SOPHOMORE, member1.getStanding());
        member1.updateGrades(1.5f, 60f).updateStanding();
        assertEquals(Member.SENIOR, member1.getStanding());
    }
}
