package gucheng.linkedlist;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
        {
            return head ;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head ;

        ListNode cur = head.next ;
        while(cur != null && cur.val == head.val)
        {
            cur = cur.next ;
        }
        if(head.next == cur)
        {
            // head is not duplicated , keep it
            head.next = deleteDuplicates(cur);
        }
        else{
            // head is a duplicated value
            dummy.next = deleteDuplicates(cur);
        }


        return dummy.next ;

    }
}
