import static java.lang.System.out;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Stack;


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
 * <p>Given the <code>root</code> of a binary tree, <em>determine if it is a valid binary search tree</em>.<br>
 * A <strong>valid BST</strong> is defined as follows:
 * <ul>
 *    <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
 *    <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
 *    <li>Both the left and right subtrees must also be binary search trees.</li>
 * </ul>
 * 
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the tree is in the range [1, 10^4]</li>
 *    <li>-2^31 &le Node.val &le 2^31 - 1</li>
 * </ul></p>
 */
public class ValidateBinarySearchTree {
    public static String treeString(TreeNode root) {
	TreeNode n;
	StringBuilder sb = new StringBuilder();
	sb.append("[");
        recTreeString(root, sb);
	sb.append(']');
	return sb.toString();
    }

    /**
     * Doesn't work as expected.
     */
    private static void recTreeString(TreeNode r, StringBuilder acc) {
	if (r.left == null && r.right == null) {
	    acc.append(r.val).append(", ");
	    return;
	} else if (r.left == null) {
	    acc.append(r.val).append(", NULL, ");
	    recTreeString(r.right, acc);
	} else if (r.right == null) {
	    acc.append(r.val).append(", ");
	    recTreeString(r.left, acc);
	    acc.append(", NULL");
	} else {
	    acc.append(r.val).append(", ");
	    recTreeString(r.left, acc);
	    recTreeString(r.right, acc);
	    return;
	}
    }

    public static boolean isValidBST(TreeNode root) {
	return validateBST(root, null, null);
    }

    private static boolean validateBST(TreeNode r, Integer low, Integer high) {
	if (r == null) {
	    return true;
	}
	boolean invalidLowRange = low != null && r.val <= low;
	boolean invalidHighRange = high != null && r.val >= high;
	if (invalidHighRange || invalidHighRange) {
	    return false;
	}
	return validateBST(r.right, r.val, high) && validateBST(r.left, low, r.val);
    }

    public static void main(String[] args) {
	TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
	TreeNode root2b = new TreeNode(4, new TreeNode(3), new TreeNode(6));
	TreeNode root2 = new TreeNode(5, new TreeNode(1), root2b);
	TreeNode[] roots = {root1, root2};
	boolean[] rs = {true, false};
	for (int i = 0; i < roots.length; i++) {
	    TreeNode r = roots[i];
	    boolean ans = rs[i];
	    out.printf("r:\t%s\nans:\t%b\nres:\t%b\n\n",
		       treeString(r),
		       ans,
		       isValidBST(r));
	}
    }
}
