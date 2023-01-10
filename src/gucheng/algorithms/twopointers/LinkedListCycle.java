package gucheng.algorithms.twopointers;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode oneStep = head;
        ListNode twoSteps = head;

        while (oneStep != null && twoSteps != null) {
            if (twoSteps.next == null || twoSteps.next.next == null) {
                return false;
            }
            twoSteps = twoSteps.next;
            if(twoSteps == oneStep){
                return true ;
            }
            twoSteps = twoSteps.next ;
            if(twoSteps == oneStep){
                return true ;
            }

            oneStep = oneStep.next;
        }

        return false;
    }
}