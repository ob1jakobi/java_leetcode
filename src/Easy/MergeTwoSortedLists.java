import java.lang.StringBuilder;
import static java.lang.System.out;


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
 * <p>You're given the heads of two sorted linked lists <code>list1</code> <code>list2</code>.<br>
 * Merge the two lists into one <strong>sorted</strong> list. The list should be made by splicing
 * together the nodes of the first two lists. Return <em>the head of the merged list</em>.<br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in both lists is in the range of `[0, 50]`</li>
 *    <li>-100 &le Node.val &le 100</li>
 *    <li>Both `list1` and `list2` are sorted in non-decreasing order</li>
 * </ul>
 */
public class MergeTwoSortedLists {

    public static void printList(ListNode head) {
	ListNode n;
	if (head == null) {
	    out.println("[]");
	} else {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (n = head; n.next != null; n = n.next) {
		sb.append(n.val).append(", ");
	    }
	    sb.append(n.val).append("]");
	    out.println(sb.toString());
	}
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO:
    }


    public static void main(String[] args) {
	ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4)));
	ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4)));
	ListNode head3 = null;
	ListNode head4 = null;
	ListNode head5 = null;
	ListNode head6 = new ListNode(0);

	ListNode[] hs = {head1,head2,head3,head4,head5,head6};

	for (int i = 0; i < hs.length -1; i += 2) {
	    ListNode h1 = hs[i];
	    ListNode h2 = hs[i + 1];
	    out.print("list1:\t");
	    printList(h1);
	    out.print("list2:\t");
	    printList(h2);
	    ListNode r = mergeTwoLists(h1, h2);
	    out.print("result:\t");
	    printList(r);
	}
    }
}
