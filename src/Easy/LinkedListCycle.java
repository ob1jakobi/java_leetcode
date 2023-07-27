import static java.lang.System.out;
import java.util.HashSet;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}


/**
 * <p>Given <code>head</code>, the head of a linked list, determine if the linked list has a cycle in it.<br>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the <code>next</code> pointer. Internally, <code>pos</code> is used to denote
 * the index of the node that tail's <code>next</code> pointer is connected to. <strong>Note that
 * <code>pos</code> is not passed as a parameter</strong>.<br>
 * Return <code>true</code> <em>if there is a cycle in the linked list</em>. Otherwise, return 
 * <code>false</code><br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the list is in the range [0, 10^4]</li>
 *    <li>-10^5 &le Node.val &le 10^5</li>
 *    <li>`pos` is `-1` or a valid index in the list.</li>
 * </ul></p>
 */
public class LinkedListCycle {

    /**
     * Uses a <code>HashSet</code> and compares node references to see if there's a cycle, since that
     * node will be present in the <code>HashSet</code>. An empty list (<code>null</code> head) or a list
     * that does not have a cycle will lead to <code>null</code>, thus returning <code>false</code>.
     */
    public static boolean hasCycle(ListNode head) {
	HashSet<ListNode> s = new HashSet<>();
	for (; head != null; head = head.next) {
	    if (s.contains(head)) {
		return true;
	    }
	    s.add(head);
	}
	return false;
    }

    /**
     * Uses two node pointers in <code>head</code>, where one pointer iterates "slowly" by only traversing
     * to the next adjacent node, and the other pointer iterates "quickly" by traversing two nodes at a time.
     * If there's no cycle, then the list will terminate with a <code>null</code> pointer, thus returning
     * <code>false</code>; however, if there is a cycle, eventually the fast node will "lap" the slower pointer,
     * in a manner where the fast pointer will ultimately point to the same node as the slow pointer. This
     * will terminate the <code>while</code> loop, thus returning <code>true</code>.
     */
    public static boolean hasCycle2(ListNode head) {
	ListNode slow, fast;
	
	if (head == null || head.next == null) {
	    return false;
	}
	
	slow = head;
	fast = head.next;
	while (slow != fast) {
	    // Checking fast is only requirement, since it skips two nodes.
	    if (fast == null || fast.next == null) {
		return false;
	    }
	    slow = slow.next;
	    fast = fast.next.next;
	}
	return true;
    }


    public static void main(String[] args) {
	ListNode head1 = new ListNode(3);
	ListNode h1Temp1 = new ListNode(2, new ListNode(0));
	head1.next = h1Temp1;
	ListNode h1Temp2 = new ListNode(-4, h1Temp1);
	h1Temp1.next.next = h1Temp2;
	
	ListNode head2 = new ListNode(1);
	ListNode h2Temp = new ListNode(2, head2);
	head2.next = h2Temp;
	
	ListNode head3 = new ListNode(1);
	ListNode head4 = null;

	ListNode[] hs = {head1, head2, head3, head4};
	for (ListNode h: hs) {
	    out.printf("hasCycle:\t%b%n", hasCycle(h));
	    out.printf("hasCycle2:\t%b%n", hasCycle2(h));
	}
    }
}
