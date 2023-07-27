import static java.lang.System.out;
import java.util.ArrayList;


/**
 * Definition for singly-linked list
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}


/**
 * <p>Given the <code>head</code> of a singly-linked list, return <code>true</code> <em>if it is a
 * palindrome or <code>false</code> otherwise</em>.<br>
 *
 * Constraints:
 * <ul>
 *    <li>The number of nodes in the list is in the range [1, 10^5]</li>
 *    <li>0 &le Node.val &le 9</li>
 * </ul>
 *
 */
public class PalindromeLinkedList {

    /**
     * Stores the <code>val</code> from each node in <code>head</code> in an <code>ArrayList</code>.
     * After all values have been added to the <code>ArrayList</code>, the <code>ArrayList</code> is
     * trimmed to its real size, and then iterated over from both the front and back. If either of the
     * numbers is different, then we know the <code>ArrayList</code>, and therefore <code>head</code>
     * is not a palindrome. If the iteration completes and there were no differences between the front
     * and back halves, then it must be a palindrome.
     */
    public static boolean isPalindrome(ListNode head) {
	int i, j;
	ArrayList<Integer> arr = new ArrayList<>();
	for (; head != null; head = head.next) {
	    arr.add(head.val);
	}
	arr.trimToSize();
	for (i = 0, j = arr.size() - 1; i < j; i++, j--) {
	    if (arr.get(i) != arr.get(j))
		return false;
	}
	return true;
    }


    public static void main(String[] args) {
	ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
	ListNode head2 = new ListNode(1, new ListNode(2));
	ListNode head3 = new ListNode(8);
	ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))));
	ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(1)));

	ListNode[] hs = {head1, head2, head3, head4, head5};

	for (ListNode h: hs) {
	    out.printf("%b\n", isPalindrome(h));
	}
    }
}
