import static java.lang.System.out;
import java.lang.StringBuilder;


/**
 * Definition of singly-linked list
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
 * <p>Given the <code>head</code> of a singly linked list, reverse the list and return <em>the reversed 
 * list</em>.<br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the list is in the range `[0, 5000]`</li>
 *    <li>-5000 &le node.val &le 5000</li>
 * </ul></p>
 */
public class ReverseLinkedList {

    /**
     * Helper function for printing the linked lists.
     */
    public static String listToString(ListNode head) {
	if (head == null) {
	    return "[]";
	}
	ListNode n;
	StringBuilder result = new StringBuilder();
	result.append('[');
	for (n = head; n.next != null; n = n.next) {
	    result.append(n.val).append(", ");
	}
	result.append(n.val).append("]");
	return result.toString();
    }


    public static ListNode reverseList(ListNode head) {
	ListNode n, result, temp;
	result = null;
	for (n = head; n != null; n = n.next) {
	    if (result == null) {
		result = new ListNode(n.val);       // Must use new ListNode and not assign result = n
	    } else {
		temp = new ListNode(n.val, result);
		result = temp;
		temp = null;
	    }
	}
	return result;
    }


    public static void main(String[] args) {
	ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	ListNode head2 = new ListNode(1, new ListNode(2));
	ListNode head3 = new ListNode(1);
	ListNode head4 = null;

	ListNode[] hs = {head1, head2, head3, head4};

	for (ListNode h: hs) {
	    out.printf("h:\t%s\n", listToString(h));
	    ListNode r = reverseList(h);
	    out.printf("r:\t%s\n", listToString(r));
	}
    }
}
