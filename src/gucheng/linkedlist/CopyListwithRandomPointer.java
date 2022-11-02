package gucheng.linkedlist;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {

        if(head == null)
        {
            return  head;
        }
        Node cur = head ;
        Node cloned = null;
        // add cloned node after each
        while(cur != null)
        {
            cloned = new Node(cur.val);
            cloned.next = cur.next ;
            cur.next = cloned ;
            cur = cloned.next ;
        }

        // copy the random pointer

        cur = head ;
        while(cur != null)
        {
            cloned = cur.next ;
            if(cur.random != null) {
                cloned.random = cur.random.next;
            }
            cur = cloned.next ;
        }

        Node clonedHead = head.next ;
        cur = head ;
        cloned = clonedHead ;

        while(cur != null )
        {
            cur.next = cur.next.next ;
            cur = cur.next ;

            if(cloned.next != null) {
                cloned.next = cloned.next.next;
                cloned = cloned.next;
            }
        }

        return clonedHead ;


    }
}
