package round1.list;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead ;
        if(head == null || head.next == null){
            return head ;
        }


        while(head != null && head.next != null){
            ListNode next = head.next ;
            head.next = next.next ;
            next.next = head ;
            prev.next = next ;
            prev = head ;
            head = head.next;
        }



        return dummyHead.next ;
    }
}
