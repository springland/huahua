package gucheng.linkedlist;

//  https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumbers2 {

    public static void main(String args[])
    {

        AddTwoNumbers2 add = new AddTwoNumbers2();

        ListNode l14 = new ListNode(3);
        ListNode l13 = new ListNode(4 , l14);
        ListNode l12 = new ListNode(2 , l13);
        ListNode l11 = new ListNode(7 , l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6 , l23);
        ListNode l21 = new ListNode(5 , l22);

        ListNode head = add.addTwoNumbers(l11  , l21);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode head = null;
        int carry = 0;
        int value = 0 ;
        while(r1 != null && r2 != null)
        {
            value = r1.val + r2.val + carry ;
            carry = value /10 ;
            ListNode node = new ListNode(value%10 , head);
            head = node ;
            r1 = r1.next ;
            r2 = r2.next ;
        }

        while(r1 != null)
        {
            value = r1.val  + carry ;
            carry = value /10 ;
            ListNode node = new ListNode(value%10 , head);
            head = node ;

            r1 = r1.next ;
        }

        while(r2 != null)
        {
            value = r2.val  + carry ;
            carry = value /10 ;
            ListNode node = new ListNode(value%10 , head);
            head = node ;

            r2 = r2.next ;
        }

        while(carry > 0)
        {
            ListNode node = new ListNode(carry%10 , head);
            head = node ;
            carry /= 10 ;
        }

        return head ;

    }

    public ListNode reverse(ListNode head)
    {

        ListNode newHead = null;
        ListNode cur = head ;

        while(cur != null)
        {
            ListNode temp = cur.next ;
            cur.next = newHead ;
            newHead = cur ;
            cur = temp ;
        }

        return newHead ;
    }


}
