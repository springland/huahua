package round1.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while(head != null)
        {
            ListNode next = head.next ;

            head.next = prev ;
            prev = head ;
            head = next ;
        }

        return prev ;
    }
}
