package gucheng.linkedlist;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {


        ListNode reversedHead = createReversedList(head);
        while(reversedHead != null && head != null)
        {
            if(reversedHead.val != head.val)
            {
                return false ;
            }
            reversedHead = reversedHead.next ;
            head = head.next ;
        }

        if(head != null || reversedHead != null)
        {
            return false ;
        }

        return true ;
    }

    public ListNode createReversedList(ListNode head)
    {

        ListNode dummy = new ListNode(0);

        while(head != null)
        {
            ListNode cur = new ListNode(head.val);
            cur.next = dummy.next;
            dummy.next = cur ;
            head = head.next ;
        }

        return dummy.next ;
    }


}
