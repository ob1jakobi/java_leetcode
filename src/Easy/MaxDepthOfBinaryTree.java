import static java.lang.System.out;
import java.lang.StringBuilder;


/**
 * Definition for a binary tree node
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
	this.val = val;
	this.left = left;
	this.right = right;
    }
}


/**
 * <p>Given the <code>root</code> of a binary tree, return <em>its maximumn depth</em>.<br>
 *
 * A binary tree's <strong>maximum depth</strong> is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.<br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the tree is in the range[0, 10^4]</li>
 *    <li>-100 &le Node.val &le 100</li>
 * </ul></p>
 */
public class MaxDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        return recDepth(root, 0);
    }

    /**
     * The first time that this function is called, the <code>depth</code> is 0, in case the root of the
     * binary tree is <code>null</code>. In the event that the root of the binary tree isn't <code>null</code>,
     * we recurse over each child node, incrementing the <code>depth</code> by 1. Because we want the maximum
     * depth, we want the max depth that either child node reaches, therefore we can utilize the
     * <code>Math</code> module's <code>max</code> function to determine which child node is the largest
     * by recursing through the tree.
     */
    private static int recDepth(TreeNode n, int depth) {
	if (n == null) {
	    return depth;
	} else {
	    return Math.max(recDepth(n.left, depth + 1), recDepth(n.right, depth + 1));
	}
    }

    public static void main(String[] args) {
	TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
	TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
	TreeNode root3 = new TreeNode(1);
	TreeNode root4 = null;

	TreeNode[] rs = {root1, root2, root3, root4};
	for (TreeNode r: rs) {
	    out.printf("%s%n", maxDepth(r));
	}
    }
}
