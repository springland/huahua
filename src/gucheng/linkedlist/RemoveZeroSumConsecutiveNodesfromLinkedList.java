package gucheng.linkedlist;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class RemoveZeroSumConsecutiveNodesfromLinkedList {


    public static void main(String args[])
    {
        RemoveZeroSumConsecutiveNodesfromLinkedList solution = new RemoveZeroSumConsecutiveNodesfromLinkedList();
        ListNode head = createList1();

        head = solution.removeZeroSumSublists(head);
        print(head);

        head = createList2();
        head = solution.removeZeroSumSublists(head);
        print(head);

        head = createList3();
        head = solution.removeZeroSumSublists(head);
        print(head);

    }

    public static ListNode createList1()
    {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(3 , node5);
        ListNode node3 = new ListNode(-3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);
        return node1;
    }

    public static ListNode createList2()
    {
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(-3 , node5);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);
        return node1;

    }

    public static ListNode createList3()
    {
        ListNode node5 = new ListNode(-2);
        ListNode node4 = new ListNode(-3 , node5);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);
        return node1;

    }

    public static void print(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val);
            System.out.print(',');
            head = head.next ;
        }
        System.out.println(' ');
    }
    public ListNode removeZeroSumSublists(ListNode head) {

        // prefix sum?
        // calculate all of the prefix sum , then find the same prefix sum to determine the zero sum sublist

        // use hashmap to record existing value

        Map<Integer , ListNode> valuesMap = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head ;

        int total = 0;

        valuesMap.put(0, dummy);
        ListNode cur = head ;
        while(cur != null)
        {
            total = cur.val + total ;

            if(valuesMap.containsKey(total))
            {
                ListNode prev = valuesMap.get(total);

                ListNode temp = prev.next ;
                int val = total ;
                while(temp != cur)
                {
                    val +=  temp.val ;
                    valuesMap.remove(val);
                    temp = temp.next ;
                }
                prev.next = cur.next ;
            }
            else{
                valuesMap.put(total , cur);
            }
            cur = cur.next ;

        }

        return dummy.next ;

    }
}
