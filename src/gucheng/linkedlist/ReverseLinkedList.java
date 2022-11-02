package gucheng.linkedlist;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    public static void main(String args[])
    {
        ReverseLinkedList   reverseLinkedList = new ReverseLinkedList();

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2 , node3);
        ListNode head = new ListNode(1 , node2);

        head = reverseLinkedList.reverseList(head);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next ;
        }


    }
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;

        ListNode cur = head ;

        while(cur != null)
        {
            ListNode next = cur.next ;
            cur.next = newHead ;
            newHead = cur ;
            cur = next ;
        }

        return newHead ;
    }

}
