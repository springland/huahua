package gucheng.tree.bst;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    public Node treeToDoublyList(Node root) {


        Node head = convertToList(root);
        if(head != null){
            Node tail = head ;
            while(tail.right != null) tail = tail.right ;
            head.left = tail;
            tail.right = head ;
        }


        return head;
    }

    public Node convertToList(Node root){

        if(root == null){
            return null ;
        }

        Node head = root;


        if(root.left != null){
            head =  convertToList(root.left);
            Node tail = head;
            while(tail.right != null){
                tail = tail.right ;
            }
            tail.right = root ;
            root.left = tail ;

        }


        if(root.right != null){
            root.right = convertToList(root.right);
            root.right.left = root ;
        }
        return head ;

    }
}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
