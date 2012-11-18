package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import to.richard.AvlNode;
import to.richard.AvlTree;

public class AvlTreeTest {

    @Test
    public void testInsertFind() throws Exception {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        assertEquals(null, tree.find(53));
        tree.insert(12).insert(5).insert(16).insert(8);
        assertEquals(new Integer(12), new Integer(tree.find(12)));
        assertEquals(new Integer(5), new Integer(tree.find(5)));
        assertEquals(new Integer(8), new Integer(tree.find(8)));
        assertEquals(null, tree.find(15));
    }

    @Test
    public void testInsertCase1() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(5).insert(15).insert(2).insert(1);
        String treeOut = "12 2 15 1 5 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testInsertCase2() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(5).insert(15).insert(2).insert(7).insert(8);
        String treeOut = "7 5 12 2 8 15 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testInsertCase3() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(5).insert(20).insert(25).insert(15).insert(17);
        String treeOut = "15 12 20 5 17 25 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testInsertCase4() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(5).insert(15).insert(17).insert(13).insert(19);
        String treeOut = "15 12 17 5 13 19 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDuplicate() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(3).insert(5).insert(2).insert(5);
    }

    @Test
    public void testEmpty(){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        assertEquals(true, tree.isEmpty());
        tree.insert(34);
        assertEquals(false, tree.isEmpty());
    }

    @Test
    public void testFindMin(){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(30).insert(54).insert(3).insert(55).insert(1);
        assertEquals(new Integer(1), new Integer(tree.findMin()));
    }

    @Test
    public void testFindMax(){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(30).insert(54).insert(3).insert(55).insert(1);
        assertEquals(new Integer(55), new Integer(tree.findMax()));
    }

    @Test
    public void remove(){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(30).insert(55).insert(33).insert(12)
                .insert(11).insert(57).insert(35).insert(36).insert(47).insert(32);
        assertEquals(new Integer(57), new Integer(tree.find(57)));
        tree.remove(57);
        assertEquals(null, tree.find(57));
        tree.remove(11);
        assertEquals(null, tree.find(11));
        tree.remove(30);
        assertEquals(null, tree.find(30));
        tree.remove(50);
        assertEquals(null, tree.find(50));
        tree.remove(47);
        assertEquals(null, tree.find(47));
    }

    @Test
    public void testRemoveCase1() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(6).insert(30).insert(4).insert(8).insert(25).insert(55)
                .insert(2).insert(5).insert(7).insert(11).insert(57).insert(1)
                .remove(8).remove(11);
        String treeOut = "12 4 30 2 6 25 55 1 5 7 57 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testRemoveCase2() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(40).insert(75).insert(28).insert(45).insert(80).insert(42).insert(49).remove(75);
        String treeOut = "45 40 50 28 42 49 80 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testRemoveCase3() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(25).insert(80).insert(10).insert(40).insert(60).insert(100)
                .insert(30).insert(55).insert(90).insert(150).insert(85).insert(95).remove(60);
        String treeOut = "50 25 90 10 40 80 100 30 55 85 95 150 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testRemoveCase4() {
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(12).insert(5).insert(20).insert(4).insert(18).insert(25).insert(40).remove(5);
        String treeOut = "20 12 25 4 18 40 ";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testPrintLevelEmpty(){
        String treeOut = "";
        AvlTree<Integer> tree = new AvlTree<Integer>();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testPrintLevel(){
        String treeOut = "50 30 55 12 33 52 ";
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(55).insert(30).insert(33).insert(12).insert(52);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTreeLevel();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }
    @Test
    public void testPrint(){

        String treeOut = "11 12 30 32 33 35 36 47 50 55 57 ";
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(30).insert(55).insert(33).insert(12)
                .insert(11).insert(57).insert(35).insert(36).insert(47).insert(32);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        tree.printTree();
        assertEquals(treeOut, outContent.toString());
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testMakeEmpty(){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(50).insert(30).insert(55).insert(33).insert(12)
                .insert(11).insert(57).insert(35).insert(36).insert(47).insert(32);
        tree.makeEmpty();
        assertEquals(true, tree.isEmpty());
    }
}
