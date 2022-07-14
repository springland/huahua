package round1.list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false ;
        }

        ListNode one = head ;
        ListNode two = head ;

        while(one != null  && two != null ){
            one = one.next ;
            if(two.next != null){
                two = two.next.next ;
            }
            else{
                two = null;
            }

            if(one != null && two != null && one == two){
                return true ;
            }
        }
        return false ;

    }
}
