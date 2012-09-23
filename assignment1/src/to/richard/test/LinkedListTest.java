package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.Member;
import to.richard.LinkedList;
import to.richard.LinkedListNode;
import to.richard.LinkedListIter;

public class LinkedListTest {

    @Test
    public void testIsEmptyTrue() throws Exception{
        LinkedList<Member> list = new LinkedList<Member>();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() throws Exception{
        Member member = new Member("Bob");
        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void testAddFirst() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member1);
        list.addFirst(member2);
        assertEquals(member2, list.getFirst());
    }

    @Test
    public void testAddLast() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member1);
        list.addLast(member2);
        list.addFirst(member3);
        assertEquals(member2, list.getLast());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member1);
        list.addLast(member2);
        list.addFirst(member3);
        assertEquals(member3, list.removeFirst());
    }

    @Test
    public void testRemoveFirstEmpty() throws Exception {
        LinkedList<Member> list = new LinkedList<Member>();
        assertEquals(null, list.removeFirst());
    }

    @Test
    public void testRemoveLast() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member1);
        list.addLast(member2);
        list.addFirst(member3);
        assertEquals(member2, list.removeLast());
    }

    @Test
    public void testRemoveLastEmpty() throws Exception {
        LinkedList<Member> list = new LinkedList<Member>();
        assertEquals(null, list.removeLast());
    }

    @Test
    public void testSize() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.addFirst(member1);
        list.addLast(member2);
        list.addFirst(member3);

        list.removeLast();
        assertEquals(2, list.size());

        list.removeFirst();
        assertEquals(1, list.size());

        list.removeFirst();
        assertEquals(0, list.size());
    }

    @Test
    public void testAddPos0() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1);
        assertEquals(member1, list.getFirst());
        list.add(0, member2);
        assertEquals(member2, list.getFirst());
    }

    @Test
    public void testAddPos3() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(0, member3).add(2, member4);
        assertEquals(member3, list.getFirst());
        assertEquals(member1, list.getLast());
        list.removeLast();
        assertEquals(member4, list.getLast());
    }

    @Test
    public void testAddPosLast() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(1, member3).add(2, member4);
        assertEquals(member1, list.removeLast());
        assertEquals(member4, list.removeLast());
        assertEquals(member3, list.removeLast());
        assertEquals(member2, list.removeLast());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddPosOutOfBounds() throws Exception {
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(2, member2);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddPosNegative() throws Exception {
        Member member1 = new Member("Bob");

        LinkedList<Member> list = new LinkedList<Member>();
        list.add(-1, member1);
    }

    @Test
    public void testContainsTrue(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(0, member3).add(0, member4);
        assertEquals(true, list.contains(member3));
    }

    @Test
    public void testContainsFalse(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member3).add(0, member4);
        assertEquals(false, list.contains(member2));
    }

    @Test
    public void testRemovePosEnd(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(0, member3).add(0, member4);
        assertEquals(member1, list.remove(3));
        assertEquals(member2, list.getLast());
        assertEquals(3, list.size());
    }

    @Test
    public void testRemovePosSingle(){
        Member member1 = new Member("Bob");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1);
        assertEquals(member1, list.remove(0));
        assertEquals(null, list.getLast());
        assertEquals(null, list.getFirst());
        assertEquals(0, list.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemovePosOutOfBounds(){
        Member member1 = new Member("Bob");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1);
        list.remove(1);
    }

    @Test
    public void testRemoveEnd(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(0, member3).add(0, member4);
        assertEquals(true, list.remove(member1));
        assertEquals(member2, list.getLast());
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveSingle(){
        Member member1 = new Member("Bob");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1);
        assertEquals(true, list.remove(member1));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveFalse(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).addLast(member3);
        assertEquals(false, list.remove(member4));
    }

    @Test
    public void testGet(){
        Member member1 = new Member("Bob");
        Member member2 = new Member("Jim");
        Member member3 = new Member("Sam");
        Member member4 = new Member("Pam");

        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1).add(0, member2).add(0, member3).add(0, member4);
        assertEquals(member1, list.get(3));
        assertEquals(member4, list.get(0));
        assertEquals(member3, list.get(1));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetOutOfBounds(){
        Member member1 = new Member("Bob");
        LinkedList<Member> list = new LinkedList<Member>();
        list.add(0, member1);
        list.get(1);
    }
}
