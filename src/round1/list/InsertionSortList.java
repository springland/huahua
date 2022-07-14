package round1.list;

/**
 *
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead = new ListNode();

        while(head != null)
        {

            ListNode next = head.next ;

            ListNode node = dummyHead;
            while(node.next != null && node.next.val < head.val){
                node = node.next ;
            }
            head.next = node.next ;
            node.next = head ;
            head = next ;
        }

        return dummyHead.next ;
    }

}
