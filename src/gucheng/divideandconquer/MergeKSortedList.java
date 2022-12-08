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


    public ListNode mergeKLists(ListNode[] lists){

        if(lists.length == 0){
            return null;
        }
        return mergeKListsDivideAndConquer(lists , 0 , lists.length-1);
    }

    public ListNode mergeKListsDivideAndConquer(ListNode[] lists , int beginIndex , int endIndex)
    {


        if(beginIndex == endIndex) {
            return lists[beginIndex];
        }

        int middle = beginIndex + ( endIndex - beginIndex)/2 ;
        ListNode left = mergeKListsDivideAndConquer(lists , beginIndex , middle);
        ListNode right = mergeKListsDivideAndConquer(lists , middle +1 , endIndex);

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead ;

        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left ;
                left = left.next ;
                tail = tail.next ;
                tail.next = null ;

            }else{
                tail.next = right ;
                tail = right ;
                right = right.next;
                tail.next = null;
            }
        }

        if(left != null){
            tail.next = left ;
        }
        if(right != null){
            tail.next = right ;
        }

        return dummyHead.next ;
    }
    public ListNode mergeKListsPQ(ListNode[] lists) {
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

    public static void main(String[] args){

        MergeKSortedList merge = new MergeKSortedList();
        merge.mergeKLists( new ListNode[0]);
        merge.mergeKLists( new ListNode[] { null});

    }
}
