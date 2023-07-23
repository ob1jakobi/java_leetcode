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
	StringBuilder sb = new StringBuilder();
	sb.append('[');
	ListNode n;
        for (n = head; n.next != null; n = n.next) {
	    sb.append(n.val).append(", ");
	}
	sb.append(n.val).append(']');
	out.println(sb.toString());
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
	boolean rNodeHead;            // If the n - cSize < 0, then rNode is head
        int cSize, diff;              // cSize: The known current size of list; diff: n - cSize
	ListNode cNode, rNode, next;  // cNode: currently iterated node; rNode: node ID'd for removal

	cSize = 0;
	cNode = head;
        while (cNode != null) {
	    diff = cSize - n;
	    rNodeHead = diff <= 0;
	    rNode = rNodeHead ? head : rNode.next;
	    cSize++;
	    cNode = cNode.next;
	}
	if (rNode.next == null) {
	    rNode = null;
	} else {
	    next = rNode.next;
	    rNode.val = next.val;
	    rNode.next = next.next;
	    next = null;
	}
	return head;
    }
    

    public static void main(String[] args) {
	ListNode head1 =
	    new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head2 = new ListNode(1);
	ListNode head3 = new ListNode(1, new ListNode(2));

	ListNode[] hs = {head1, head2, head3};
	
	int[] ns = {2, 1, 1};

	for (int i = 0; i < hs.length; i++) {
	    ListNode l = hs[i];
	    out.print("l:\t");
	    printList(l);
	    int n = ns[i];
	    out.println("n:\t" + n);
	    out.print("r:\t");
	    ListNode r = removeNthFromEnd(l, i + 1);
	    printList(r);
	}
    }
}
