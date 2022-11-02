package gucheng.linkedlist;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class RemoveNthNodeFromEndofList {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);

        dummy.next = head ;
        ListNode fast  = dummy;
        ListNode slow = dummy ;


        int count = 0 ;
        while(count < n)
        {
            count++;
            fast = fast.next ;
        }

        while(fast.next != null)
        {
            fast = fast.next ;
            slow = slow.next ;
        }
        slow.next = slow.next.next ;

        return dummy.next ;
    }

}
