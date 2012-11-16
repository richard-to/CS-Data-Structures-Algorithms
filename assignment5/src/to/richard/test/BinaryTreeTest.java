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
}
