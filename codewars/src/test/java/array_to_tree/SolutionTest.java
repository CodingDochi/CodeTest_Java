package array_to_tree;


import org.junit.jupiter.api.Test;
import org.hamcrest.CoreMatchers;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class SolutionTest {

    @Test
    public void emptyArray() {
        TreeNode expected = null;
        assertEquals(Solution.arrayToTree(arrayFrom()),(expected));
    }

    @Test
    public void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
        assertThat(Solution.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), CoreMatchers.is(expected));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }
}