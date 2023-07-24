import static java.lang.System.out;
import java.lang.StringBuilder;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
	this.val = val;
    }
    ListNode(int val, ListNode next) {
	this.val = val;
	this.next = next;
    }
}


/**
 * <p>Given <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end
 * of the list and return its head.</p>
 * 
 * <p>Examples:<br>
 *
 * <strong>Input:</strong> <code>head</code> = [1, 2, 3, 4, 5], <code>n</code> = 2<br>
 * <strong>Output:</strong> [1, 2, 3, 5]<br><br>
 * 
 * <strong>Input:</strong> <code>head</code> = [1], <code>n</code> = 1<br>
 * <strong>Output:</strong> []<br><br>
 *
 * <strong>Input:</strong> <code>head</code> = [1, 2], <code>n</code> = 1<br>
 * <strong>Output:</strong> [1]<br><br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the list is `sz`</li>
 *    <li>1 &le `sz` &le 30</li>
 *    <li>0 &le node.val &le 100</li>
 *    <li>1 &le n &le sz</li>
 * </ul>
 * </p>
 */
public class RemoveNthNodeFromEndOfList {

    public static void printList(ListNode head) {
	if (head == null) {
	    out.println("[]");
	    return;
	}
	StringBuilder sb = new StringBuilder();
	sb.append('[');
	ListNode n;
        for (n = head; n.next != null; n = n.next) {
	    sb.append(n.val).append(", ");
	}
	sb.append(n.val).append(']');
	out.println(sb.toString());
    }


    /**
     * <p>In order to remove the correct node on a single pass, we start counting the nodes from the
     * head of the list, <code>head</code>. The first node, which is <code>head</code>, is index 0.
     * We initialize two different nodes that are used for separate purposes:
     * <ul>
     *    <li>cNode: the node that represents the currently iterated node in the list. This is
     *        initially initialized to `head` and iterates over every node in the list.</li>
     *    <li>rNode: the node that will be placed before the node that is to be removed. This is
     *        also initially initialized to `head`, but is only incremented if the size of the
     *        list (which we compute as we iterate over the list) is larger than `n`.</li>
     * </ul>
     *
     * The reason we only increment <code>rNode</code> if the size of the list is larger than
     * <code>n</code> is because <code>n</code> is the index position <em>from the last node in the
     * list</em>. <code>rNode</code> must be the node directly preceeding the node to be removed.
     * This cannot be the case if the given <code>n</code> is the same size as the list, which means
     * we have to remove the head node, <code>head</code> and make <code>head</code> point to the
     * next node in the list.</p>
     *
     * <p>The result that is returned will be the head of this list, but which specific node is
     * returned (if any), depends on the node selected for deletion and the size of the list.
     * If the node selected for deletion is the first node in the list, (i.e., it's the same node
     * that <code>head</code> and <code>rNode</code> points to), then we make <code>head</code> point
     * to the <code>next</code> field of the <code>rNode</code>. If the list is a singleton, then
     * <code>head</code> will now point to <code>null</code>, because we've deleted the only node.
     * If the list is not a singleton, then head will point to the 2nd node in the list.</p>
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cNode, rNode, next;
	int size;
        rNode = head;
	size = 0;
	for (cNode = head; cNode != null; cNode = cNode.next) {
	    if (size > n) {            // Could also do if (size++ > n) {...}
		rNode = rNode.next;
	    }
	    size++;
	}
        if (n == size) {
	    // Remove the first node (set head to be rNode's next node)
	    head = rNode.next;
	    rNode = null;
	} else if (n == 1) {
	    // Remove the last node (set rNode's next node to be null)
	    rNode.next = null;
	} else {
	    // Make rNode's next field point to the node after the next node
	    next = rNode.next;
	    rNode.next = next.next;
	    next = null;
	}
	return head;
    }
    

    public static void main(String[] args) {
	ListNode head1 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head2 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head3 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head4 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head5 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head6 = new ListNode(1, new ListNode(2));
	ListNode head7 = new ListNode(1, new ListNode(2));
	ListNode head8 = new ListNode(1);

	ListNode[] heads = {head1, head2, head3, head4, head5, head6, head7, head8};

	int[] ns = {1,2,3,4,5,1,2,1};

	for (int i = 0; i < ns.length; i++) {
	    ListNode head = heads[i];
	    int n = ns[i];
	    out.print("head:\t");
	    printList(head);
	    out.printf("n:\t%d\n", n);
	    ListNode result = removeNthFromEnd(head, n);
	    out.print("result:\t");
	    printList(result);
	    out.println();
	}
    }
}
