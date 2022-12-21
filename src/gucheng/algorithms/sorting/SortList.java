package gucheng.algorithms.sorting;

// https://leetcode.com/problems/sort-list/
public class SortList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode sortList(ListNode head) {

          if(head == null || head.next == null){
              return head ;
          }
          ListNode left = null ;
          ListNode right = null ;

          if(head.next.next == null){

              left = head ;
              right = left.next ;
              left.next = null;

          }
          else {
              ListNode middle = findMiddle(head);

              right = middle.next;
              middle.next = null;

              left = head;

              left = sortList(left);
              right = sortList(right);

          }
        return merge(left, right);
    }

    public ListNode merge(ListNode left  , ListNode right){
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left ;
                left = left.next ;
            }
            else{
                tail.next = right ;
                right = right.next ;
            }
            tail = tail.next ;
            tail.next = null;
        }
        while(left != null){
            tail.next = left ;
            left = left.next ;
            tail = tail.next ;
            tail.next = null;
        }

        while(right != null){
            tail.next = right ;
            right = right.next ;
            tail = tail.next ;
            tail.next = null;
        }

        return dummyHead.next;

    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next ;
        }

        return slow ;
    }

    public static void main(String args[]){
          ListNode head = new ListNode(4);
          head.next = new ListNode(2);
          head.next.next = new ListNode(1);
          head.next.next.next = new ListNode(3);

        SortList sortList = new SortList();
        sortList.sortList(head);
    }
}
