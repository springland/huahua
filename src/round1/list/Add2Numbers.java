package round1.list;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(l1 != null && l2 != null){
            int value = l1.val + l2.val + carry;
            carry = value /10;
            value = value%10;
            tail.next = new ListNode(value);
            tail = tail.next ;
            l1 = l1.next ;
            l2 = l2.next ;

        }

        while(l1 != null){
            int value = l1.val + carry ;
            carry = value /10 ;
            value = value%10 ;
            tail.next = new ListNode(value);
            tail = tail.next ;
            l1 = l1.next ;
        }

        while(l2 != null){
            int value = l2.val + carry ;
            carry = value /10 ;
            value = value%10 ;
            tail.next = new ListNode(value);
            tail = tail.next ;
            l2 = l2.next ;
        }

        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


}
