package gucheng.linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);

        ListNode head = dummy ;

        while(list1 != null && list2 != null)
        {

            if(list1.val < list2.val)
            {
                head.next = list1 ;
                list1 = list1.next ;
            }
            else{
                head.next = list2 ;
                list2 = list2.next ;
            }
            head = head.next ;
        }

        while(list1 != null)
        {
            head.next = list1 ;
            head = head.next ;
            list1 = list1.next ;
        }

        while(list2 != null){
            head.next = list2 ;
            head = head.next ;
            list2 = list2.next ;
        }
        return dummy.next ;
    }
}
