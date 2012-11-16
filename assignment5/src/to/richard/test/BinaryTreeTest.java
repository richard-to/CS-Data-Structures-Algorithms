package to.richard.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import to.richard.BinaryNode;
import to.richard.BinaryTree;

public class BinaryTreeTest {

    @Test
    public void testInsertFind() throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assertEquals(null, tree.find(53));
        tree.insert(12).insert(5).insert(16).insert(8);
        assertEquals(new Integer(12), new Integer(tree.find(12)));
        assertEquals(new Integer(5), new Integer(tree.find(5)));
        assertEquals(new Integer(8), new Integer(tree.find(8)));
        assertEquals(null, tree.find(15));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDuplicate() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(3).insert(5).insert(2).insert(5);
    }

    @Test
    public void testEmpty(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        assertEquals(true, tree.isEmpty());
        tree.insert(34);
        assertEquals(false, tree.isEmpty());
    }

    @Test
    public void testFindMin(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(30).insert(54).insert(3).insert(55).insert(1);
        assertEquals(new Integer(1), new Integer(tree.findMin()));
    }

    @Test
    public void testFindMax(){
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(30).insert(54).insert(3).insert(55).insert(1);
        assertEquals(new Integer(55), new Integer(tree.findMax()));
    }
}
