package gucheng.monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNodeInLinkedList {

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[] nextLargerNodes(ListNode head) {

         Stack<ListNode> montonicStack = new Stack<>() ;
         Stack<ListNode> listnodeStack = new Stack<>();

         while(head != null){
             listnodeStack.push(head);
             head = head.next ;
         }

         int[] result = new int[listnodeStack.size()];
         int index = result.length-1 ;
         while(!listnodeStack.isEmpty())
         {
             ListNode node = listnodeStack.pop();
             while(!montonicStack.isEmpty() &&  montonicStack.peek().val <= node.val){
                 montonicStack.pop();
             }
             if(montonicStack.isEmpty()){
                 result[index] = 0 ;
             }else {
                 result[index] =  montonicStack.peek().val;
             }
             montonicStack.push( node);
             index -- ;

         }
         return result ;
    }


}
