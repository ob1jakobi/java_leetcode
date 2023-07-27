

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

    public static boolean isValidBST(TreeNode root) {
	// TODO:
    }

    public static void main(String[] args) {
	// TODO:
    }
}
