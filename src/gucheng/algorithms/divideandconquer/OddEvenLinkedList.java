package gucheng.algorithms.divideandconquer;

// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode oddEvenList(ListNode head) {

          // You must solve the problem in O(1) extra space complexity and O(n) time complexity.

        // seems I can only get nLogn for divide and conquer
        return notDivideAndConquer(head);


    }

    public ListNode notDivideAndConquer(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head ;

        ListNode tail = dummy ;
        while(tail.next != null) {
            tail = tail.next ;
        }

        ListNode last = tail ;

        ListNode prev = dummy ;
        ListNode node = head ;
        int count = 1;
        while(node != null && node != last){
            if(count %2 == 0){
                prev.next = node.next ;
                ListNode temp = node.next ;
                tail.next = node ;
                node.next = null;
                tail = node ;
                node = temp ;
            }
            else{
                prev = node ;
                node = node.next ;
            }
            count ++;
        }
        if(node != null && count %2 == 0){
            if(node.next != null){
                prev.next = node.next ;
                tail.next = node ;
                node.next = null;

            }

        }

        return dummy.next ;

    }

    public static void main(String[] args){
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);

        ListNode answer = oddEvenLinkedList.oddEvenList(head);
        System.out.println(answer);
    }

}
