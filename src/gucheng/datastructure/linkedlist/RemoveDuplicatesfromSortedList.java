package gucheng.datastructure.linkedlist;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head ;

        while(cur != null)
        {
            if(cur.next != null && cur.val == cur.next.val)
            {
                    cur.next = cur.next.next;
            }
            else{
                cur = cur.next ;
            }

        }
        return head ;
    }
}
