package gucheng.divideandconquer;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead ;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a , b) -> a.val - b.val);

        for(ListNode listnode : lists){
            if(listnode != null) pq.offer(listnode);
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.offer(node.next);
            }
            tail.next = node ;
            node.next = null;
            tail = tail.next ;
        }

        return dummyHead.next ;

    }
}
