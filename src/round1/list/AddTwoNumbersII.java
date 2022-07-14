package round1.list;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead ;
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);

        int carry = 0 ;

        while(t1 != null && t2 != null){
            int value =( t1.val + t2.val + carry)%10; ;
            carry = (t1.val + t2.val + carry)/10;

            tail.next = new ListNode(value);
            tail = tail.next ;
            t1 = t1.next ;
            t2 = t2.next ;
        }

        while(t1 != null){

            int value = (t1.val + carry)%10;
            carry = (t1.val + carry)/10;
            tail.next = new ListNode(value);
            tail = tail.next ;
            t1 = t1.next ;
        }

        while(t2 != null){
            int value = (t2.val + carry)%10;
            carry = (t2.val + carry)/10;
            tail.next = new ListNode(value);
            tail = tail.next ;
            t2 = t2.next ;
        }
        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return reverse(dummyHead.next);
    }

    protected ListNode  reverse(ListNode head){

        ListNode prev = null;
        while(head.next != null){
            ListNode next = head.next ;
            head.next = prev ;
            prev = head ;
            head = next ;
        }
        head.next = prev ;
        return head ;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        AddTwoNumbersII  two = new AddTwoNumbersII();
        ListNode tail = two.reverse(head);
        while(tail != null){
            System.out.println(tail.val);
            tail = tail.next ;

        }
    }
}
