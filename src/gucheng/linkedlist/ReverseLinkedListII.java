package gucheng.linkedlist;

// https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {


    public static void main(String args[])
    {


        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

        ListNode head = reverseLinkedListII.createList()  ;

        head = reverseLinkedListII.reverseBetween(head , 2 , 4);
        ListNode node = head ;
        while(node != null)
        {
            System.out.println(node.val);
            node = node.next ;
        }


        head = reverseLinkedListII.createList()  ;
        head = reverseLinkedListII.reverseBetween(head , 1 , 1);
        node = head ;
        while(node != null)
        {
            System.out.println(node.val);
            node = node.next ;
        }


        head = new ListNode(1);
        head = reverseLinkedListII.reverseBetween(head , 1 , 1);
        node = head ;
        while(node != null)
        {
            System.out.println(node.val);
            node = node.next ;
        }

    }

    public ListNode createList()
    {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4 , node5);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);

        return node1 ;
    }

    public ListNode reverseBetween(ListNode head , int left , int right)
    {
        ListNode dummy = new ListNode(0 , head);

        ListNode prev = dummy ;
        ListNode cur = head ; ;

        int count = 1;
        while(count < left){


            count ++ ;
            prev = prev.next ;
            cur = cur.next ;
        }


        ListNode reverseHead = null ;
        while(count <= right)
        {
            ListNode temp = cur.next ;
            cur.next = reverseHead ;
            reverseHead = cur ;
            cur = temp ;
            count++;
        }

        if(reverseHead != null)
        {
            prev.next.next = cur ;
            prev.next = reverseHead ;

        }

        return dummy.next ;

    }
    public ListNode reverseBetweenI(ListNode head, int left, int right) {

        ListNode newHead = null;

        int count = 1;
        ListNode beforeLeft = null ;

        ListNode afterRight = null;

        ListNode cur = head ;
        while(cur != null && count < right)
        {
            if(count+1 == left)
            {
                beforeLeft = cur ;
            }
            count++;
            cur = cur.next ;
        }

        afterRight = cur.next ;

        newHead = afterRight ;
        if(beforeLeft != null) {
            cur = beforeLeft.next;
        }
        else{
            cur = head ;
        }
        count = left ;

        while(count <= right)
        {
            ListNode temp = cur.next ;
            cur.next = newHead ;
            newHead = cur ;
            cur = temp ;
            count++;
        }

        if(beforeLeft == null) {
            return newHead;
        }
        else{
            beforeLeft.next = newHead ;
            return head ;
        }


    }
}
