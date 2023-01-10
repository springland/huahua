package gucheng.algorithms.twopointers;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode oneStep = head;
        ListNode twoSteps = head;

        while (oneStep != null && twoSteps != null) {


            if (twoSteps.next == null || twoSteps.next.next == null) {

                return null;
            }
            twoSteps = twoSteps.next.next;
            oneStep = oneStep.next ;

            if (twoSteps == oneStep) break;

        }
        if (oneStep == null || twoSteps == null) {
            return null;
        }

        twoSteps = head;

        while (twoSteps != oneStep) {
            oneStep = oneStep.next;
            twoSteps = twoSteps.next;
        }

        return oneStep;
    }

    public static void main(String args[]){

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next ;

        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        System.out.println(linkedListCycleII.detectCycle(head));
    }
}