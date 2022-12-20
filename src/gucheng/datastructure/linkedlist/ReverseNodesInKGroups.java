package gucheng.datastructure.linkedlist;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroups {

    public static void main(String args[])
    {
        ReverseNodesInKGroups  reverseNodesInKGroups = new ReverseNodesInKGroups();

        ListNode head ;
        head = reverseNodesInKGroups.createList();
        print(head);

        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,1);
        print(head);

        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,2);
        print(head);


        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,3);
        print(head);

        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,4);
        print(head);

        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,5);
        print(head);

        head = reverseNodesInKGroups.createList();
        head = reverseNodesInKGroups.reverseKGroup(head ,6);
        print(head);

    }


    public static void print(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val);
            System.out.print(',');
            head = head.next ;
        }
        System.out.println("");
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


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1 , head);


        ListNode cur = head ;
        int count = 1;

        while(cur != null && count < k)
        {
            cur = cur.next ;
            count++;
        }
        if(cur == null)
        {
            return head ;
        }

        cur = head ;
        ListNode prev = null;
        count = 1;
        while(count <= k)
        {
            ListNode temp = cur.next ;
            cur.next = prev ;
            prev = cur ;
            cur = temp ;
            count ++;

        }

        dummy.next.next = reverseKGroup(cur , k);
        dummy.next = prev ;
        return dummy.next ;


    }



}
