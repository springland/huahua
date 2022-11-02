package gucheng.linkedlist;

//https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {


    public static void main(String args[])
    {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        int carry = 0 ;
        while(l1 != null && l2 != null)
        {
            int value = l1.val + l2.val + carry ;

            carry = value /10;
            value = value %10 ;

            ListNode node = new ListNode(value);
            head.next = node ;
            head = node ;

            l1 = l1.next ;
            l2 = l2.next ;
        }

        while(l1 != null)
        {
            int value = l1.val + carry ;
            carry = value /10;
            value = value %10 ;

            ListNode node = new ListNode(value);
            head.next = node ;
            head = node ;
            l1 = l1.next ;

        }

        while(l2 != null)
        {
            int value = l2.val + carry ;
            carry = value /10;
            value = value %10 ;

            ListNode node = new ListNode(value);
            head.next = node ;
            head = node ;
            l2 = l2.next ;

        }

        while(carry > 0)
        {
            ListNode node = new ListNode(carry%10);
            carry /= 10 ;
            head.next = node ;
            head = node ;
        }
        return dummyHead.next;


    }

}
