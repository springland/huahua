package gucheng.datastructure.linkedlist;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode onestep = head ;
        ListNode twosteps = head ;

        while(onestep != null && twosteps != null)
        {
            twosteps = twosteps.next ;
            if(twosteps == null)
            {
                break;
            }
            else if(twosteps == onestep)
            {
                return true ;
            }

            twosteps = twosteps.next;
            if(twosteps == null)
            {
                break;
            }
            else if (twosteps == onestep) {
                return true;
            }
            onestep = onestep.next ;
        }

        return false ;
    }

}
