package gucheng.linkedlist;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionofTwoLinkedLists {

    public static void main(String args[])
    {
        ListNode c = createCommon();
        ListNode headA = createListA(c);
        ListNode headB = createListB(c);

        IntersectionofTwoLinkedLists  solution = new IntersectionofTwoLinkedLists();
        ListNode answer = solution.solution2(headA , headB);
        System.out.println(answer);
    }
    public static ListNode createListA(ListNode common)
    {
        ListNode node1 = new ListNode(1 , common);
        ListNode node4 = new ListNode(4 , node1);
        ListNode node2 = new ListNode(2 , node4);
        return node2 ;
    }

    public static ListNode createListB(ListNode common)
    {
        ListNode node1 = new ListNode(1 , common);
        ListNode node6 = new ListNode(6 , node1);
        ListNode node5 = new ListNode(5  , node6);

        return node5;
    }

    public static ListNode createCommon()
    {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4 , node5);
        ListNode node8 = new ListNode(8 , node4);
        return node8 ;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //return solution1(headA , headB);
        return solution2(headA , headB);
    }

    public ListNode solution2(ListNode headA , ListNode headB)
    {
        ListNode iteratorA = headA ;

        ListNode iteratorB = headB ;

        while(iteratorA.next != null && iteratorB.next != null)
        {
            iteratorA = iteratorA.next ;
            iteratorB = iteratorB.next ;
        }


        if(iteratorA.next == null)
        {
            iteratorA = headB ;
            while(iteratorB.next != null)
            {
                iteratorB=iteratorB.next ;
                iteratorA = iteratorA.next ;
            }
            iteratorB = headA ;
        }
        else{
            iteratorB = headA ;
            while(iteratorA.next != null){
                iteratorA=iteratorA.next ;
                iteratorB=iteratorB.next ;
            }
            iteratorA = headB ;
        }

        while(iteratorA!= null && iteratorB != null)
        {
            if(iteratorA == iteratorB){
                return iteratorA;
            }
            iteratorA = iteratorA.next ;
            iteratorB = iteratorB.next ;
        }

        return null ;
    }
    public ListNode solution1(ListNode headA , ListNode headB)
    {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        int diff = 0;
        if(lengthA > lengthB )
        {
            diff = lengthA - lengthB;
            headA = moveSteps(headA , diff);        }
        else{
            diff = lengthB - lengthA ;
            headB = moveSteps(headB , diff);
        }

        while(headA  != null && headB != null)
        {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next ;
            headB = headB.next ;
        }

        return null;
    }

    public ListNode moveSteps(ListNode head , int step)
    {
        while(step > 0)
        {
            head = head.next ;
            step --;
        }
        return head ;
    }
    public int getLength(ListNode head)
    {
        int length = 0;
        while(head != null)
        {
            length ++;
            head = head.next ;
        }
        return length ;
    }
}
