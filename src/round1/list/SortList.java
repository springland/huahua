package round1.list;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {
    public ListNode sortList(ListNode head) {



        if(head == null || head.next == null){
            return head ;
        }
        if(head.next.next == null){
            if(head.val < head.next.val){
                return head ;
            }
            else{
                ListNode temp = head.next ;
                temp.next = head ;
                head.next = null;
                return temp ;
            }
        }

        ListNode one = head ;
        ListNode two = head ;
        while(two != null && two.next != null ){
            one = one.next ;
            two = two.next ;
            if(two != null){
                two = two.next ;
            }
        }

        ListNode right = sortList(one.next);
        one.next = null;
        ListNode left = sortList(head);

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left ;
                tail = tail.next ;
                left = left.next ;
                tail.next = null;
            }
            else{
                tail.next = right ;
                tail = tail.next ;
                right = right.next ;
                tail.next = null;
            }
        }

        if(left != null){
            tail.next = left ;
        }
        if(right != null){
            tail.next = right ;
        }
        return dummyHead.next ;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        SortList sort = new SortList();
        sort.sortList(head);

    }
}
