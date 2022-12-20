package gucheng.datastructure.linkedlist;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);

        ListNode head = dummy ;
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a , b) -> a.val - b.val);
        for(ListNode node: lists)
        {
            if(node != null) {
                pq.offer(node);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode node = pq.poll();
            head.next = node ;
            head = head.next ;
            if(node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next ;
    }
}
