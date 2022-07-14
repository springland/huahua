package round1.list;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        if(head == null) {
            return head ;
        }
        //return solution1(head);

        return solution2(head);
    }


    public ListNode solution1(ListNode  head){

        ListNode one = head ;
        ListNode two = head ;

        int count = 0;
        while(two != null){
            count ++;
            one = one.next ;
            two = two.next ;
            if(two == null){
                break;
            }
            two = two.next ;
            if(one == two){
                break;
            }
        }

        if(two == null){
            return two ;
        }
        one = head ;
        while(true){
            two = one.next ;
            for(int index = 0 ; index < count*2 ; index++){
                if(two == one){
                    return one ;
                }
                two = two.next ;
            }
            one = one.next ;
        }
    }

    public ListNode solution2(ListNode  head){

        ListNode one = head ;
        ListNode two = head ;

        while(two != null){
            one = one.next ;
            two = two.next ;
            if(two == null){
                break;
            }
            two = two.next ;
            if(one == two){
                break;
            }
        }

        if(two == null){
            return two ;
        }

        one = head ;
        while(one != two){
            one = one.next ;
            two = two.next ;
        }
        return two ;
    }
}
