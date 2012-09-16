package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.Member;

public class MemberTest {
    @Test
    public void testGetStanding() throws Exception {
        Member member = new Member(0.0f, 0.0f, "Fr", "Bob");
        assertEquals("Fr", member.getStanding());
    }

    @Test
    public void testGetName() throws Exception {
        Member member = new Member(0.0f, 0.0f, "Fr", "Bob");
        assertEquals("Bob", member.getName());
    }

    @Test
    public void testGetPointsEarned() throws Exception {
        Member member = new Member(8.6f, 2.6f, "Fr", "Bob");
        assertEquals(2.6f, member.getPointsEarned(), 0.0);
    }

    @Test
    public void testGetHoursAttempted() throws Exception {
        Member member = new Member(1.5f, 4.5f, "Fr", "Bob");
        assertEquals(1.5f, member.getHoursAttempted(), 0.0);
    }

    @Test
    public void testEquals() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, "Fr", "Bob");
        Member member2 = new Member(1.5f, 4.5f, "Fr", "Bob");

        assertEquals(true, member1.equals(member1));
        assertEquals(true, member1.equals(member2));
    }

    @Test
    public void testNotEquals() throws Exception {
        Member member1 = new Member(1.5f, 4.5f, "So", "Bob");
        Member member2 = new Member(1.5f, 4.5f, "Fr", "Bob");
        assertEquals(false, member1.equals(member2));
    }
}
