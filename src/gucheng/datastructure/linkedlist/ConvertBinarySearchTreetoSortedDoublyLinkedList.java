package gucheng.datastructure.linkedlist;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/ (premium only )
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

    }

    public Node treeToDoublyList(Node root) {


        if(root == null){
            return null ;
        }



        Node[] headTail = convertToDoublyList(root);

        if(headTail != null){
            headTail[0].left = headTail[1];
            headTail[1].right = headTail[0];
            return headTail[0];
        }
        else{
            return null;
        }

    }

    public Node[]  convertToDoublyList(Node root){


        Node[] headTail = new Node[2];

        if(root == null){
            return headTail ;
        }

        Node[] leftHeadTail = convertToDoublyList(root.left);
        Node[] rightHeadTail = convertToDoublyList(root.right);

        if(leftHeadTail[0] == null){
            headTail[0] = root ;
            root.left = null;
        }
        else{

            headTail[0] = leftHeadTail[0];
            root.left = leftHeadTail[1];
            leftHeadTail[1].right = root ;
        }

        if(rightHeadTail[0] == null)
        {
            headTail[1] = root ;
            root.right = null;
        }
        else{

            headTail[1] = rightHeadTail[1];
            root.right = rightHeadTail[0] ;
            rightHeadTail[0].left = root ;
        }

        return headTail ;
    }


    public static void main(String[] args){
        Node root = new Node(4);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        root.left = node2 ;
        root.right = node5 ;

        Node node1 = new Node(1);
        Node node3 = new Node(3);

        node2.left = node1 ;
        node2.right = node3 ;

        ConvertBinarySearchTreetoSortedDoublyLinkedList  convert = new ConvertBinarySearchTreetoSortedDoublyLinkedList();

        Node head = convert.treeToDoublyList(root);

        head.left.right = null ;
        while(head != null){
            System.out.print( head.val + "   ");
            head = head.right ;
        }
        System.out.println();
    }

}
