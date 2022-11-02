package gucheng.linkedlist;

// https://leetcode.com/problems/linked-list-cycle-ii/

/*
    b+c = circle
    a = before circle
    one step =   a + b
    two steps = a + b + c + b = a+2b +c

    a + 2b +c = 2*(a+b) = 2a + 2b

    a = c

 */
public class LinkedListCycleII {

    public static void main(String args[] )
    {
        ListNode head = buildCircle();

        LinkedListCycleII  detect = new LinkedListCycleII();

        head = detect.detectCycle(head);
        System.out.println(head.val);
    }

    public static ListNode buildCircle()
    {
        //
        //
        //      -----------|
        //      |          |
        // 3 -> 2 -> 0 -> -4
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);

        node3.next = node2 ;
        node2.next = node0 ;
        node0.next = node_4 ;
        node_4.next = node2 ;
        return node3 ;
    }
    public ListNode detectCycle(ListNode head) {

        ListNode onestep = head ;

        ListNode twosteps = head ;

        while(onestep != null && twosteps != null )
        {
            if(twosteps.next == null || twosteps.next.next == null)
            {
                twosteps = null;
                break;
            }
            twosteps = twosteps.next.next ;
            onestep = onestep.next ;

            if(twosteps == onestep)
            {
                break;
            }

        }

        if(twosteps != null && onestep != null)
        {
            twosteps = head ;
            while(twosteps != onestep)
            {
                twosteps = twosteps.next ;
                onestep = onestep.next ;
            }
            return onestep;
        }
        else {
            return null;
        }
    }
}
