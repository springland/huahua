package round1.list;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>( ( a , b)-> a.val - b.val);

        for(ListNode head : lists){
            if(head != null)  pq.offer(head);
        }

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node ;
            tail = tail.next ;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return dummyHead.next ;
    }
}
