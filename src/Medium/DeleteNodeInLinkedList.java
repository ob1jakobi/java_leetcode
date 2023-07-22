import java.lang.StringBuilder;


/**
 * Definition for the singly-linked list
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
	this.val = x;
    }
}

/**
 * <p>There is a singly-linked list <code>head</code> and we want to delete a node, <code>node</code>,
 * in it. You are given the node to be deleted, <code>node</code>. You will <strong>not be given
 * access</strong> to the first node of <code>head</code>. All the values of the linked list are
 * <strong>unique</strong>, and it is guaranteed that the given node <code>node</code> is not the
 * last node in the linked list. Delete the given node. Note that by deleting the node, we do not
 * mean removing it from memory, we mean:
 * <ul>
 *     <li>The value of the given node should not exist in the linked list.</li>
 *     <li>The number of nodes in the list should decrease by one.</li>
 *     <li>All the values before `node` should be in the same order.</li>
 *     <li>All the values after `node` should be in the same order.</li>
 * </ul></p>
 *
 * <p>Custom testing:
 * <ul>
 *     <li>For the input, you should provide the entire linked list `head` and the given `node`.
 *         `node` should not be the last node of the list and should be an actual node in the list.</li>
 *     <li>We will build the linked list and pass the node to your function.</li>
 *     <li>The output will be the entire list after calling your function.</li>
 * </ul></p>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the given list is in the range [2, 1000]</li>
 *    <li>-1000 &le node.val &le 1000</li>
 *    <li>The value of each node in the list is unique</li>
 *    <li>The node to be deleted is in the list and is not a tail node</li>
 * </ul>
 */
public class DeleteNodeInLinkedList {

    

    public static void printList(ListNode head) {
	StringBuilder result = new StringBuilder();
	result.append("LN [");
        for (ListNode h = head; h != null; h = h.next) {
	    if (h.next == null) {
		result.append(h.val);
	    } else {
		result.append(h.val).append(", ");
	    }
	}
	result.append("]");
	System.out.println(result.toString());
    }

    /**
     * <p>The intuition for this solution is to simply have the given node "become" the next node.
     * This is achieved by creating a <code>ListNode</code> variable that is the next, non-tail/null
     * node in the list. We then take our given node, <code>node</code> change all of its fields to
     * that of the next node, and then simply "delete" <code>nextNode</code> by removing any
     * reference to it. The end result is that the given node becomes the next node.</p>
     */
    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;       // Variable for the node to replace the given node
	node.val = nextNode.val;             // Make the given node's value be the next nodes value
	node.next = nextNode.next;           // Make the given node's next field point to nextNode's next field
	nextNode = null;                     // "delete" the reference to nextNode.
    }


    public static void main(String[] args) {

	ListNode head1;
	head1 = new ListNode(4);
	head1.next = new ListNode(5);
	head1.next.next = new ListNode(1);
	head1.next.next.next = new ListNode(9);
	head1.next.next.next.next = new ListNode(10);
	head1.next.next.next.next.next = new ListNode(11);
	head1.next.next.next.next.next.next = new ListNode(32);	

        ListNode head2;
	head2 = new ListNode(4);
	head2.next = new ListNode(5);
	head2.next.next = new ListNode(1);
	head2.next.next.next = new ListNode(9);
	head2.next.next.next.next = new ListNode(19);
	head2.next.next.next.next.next = new ListNode(88);	
	
	ListNode head3;
	head3 = new ListNode(4);
	head3.next = new ListNode(5);
	head3.next.next = new ListNode(1);
	head3.next.next.next = new ListNode(-10);
	head3.next.next.next.next = new ListNode(-18);

	ListNode head4;
	head4 = new ListNode(4);
	head4.next = new ListNode(5);
	head4.next.next = new ListNode(1);

	ListNode head5;
	head5 = new ListNode(18);
	head5.next = new ListNode(-34);

	ListNode[] ls = {head1, head2, head3, head4, head5};
        int i = 1;
	for (ListNode l: ls) {
	    int j = i;
	    System.out.print("List before deletion:\t");
	    printList(l);
	    ListNode n = l;
	    while (j < ls.length) {
		n = n.next;
		j++;
	    }
	    System.out.printf("Selected deletion node:\t%d\n", n.val);
	    deleteNode(n);
	    System.out.print("List after deletion:\t");
	    printList(l);
	    System.out.println();
	    i++;
	}
    }
}
