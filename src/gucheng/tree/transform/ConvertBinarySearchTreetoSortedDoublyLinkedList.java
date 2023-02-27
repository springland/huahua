package gucheng.tree.transform;
// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
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

    ;

    public Node treeToDoublyList(Node root) {

        if(root == null){
            return null;
        }
        Node head = covertTreeToDoublyList(root);
        Node tail = head ;
        while(tail.right != null){
            tail = tail.right ;
        }

        head.left = tail ;
        tail.right = head ;
        return head ;
    }

    public Node covertTreeToDoublyList(Node root){


        Node head = root;

        if (root.left != null) {
            head = covertTreeToDoublyList(root.left);
            Node node = head;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root;
            root.left = node ;
        }

        if (root.right != null) {
            Node rightHead = covertTreeToDoublyList(root.right);
            root.right = rightHead;
            rightHead.left = root ;
        }

        return head;

    }
    public static void main(String[] args){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        ConvertBinarySearchTreetoSortedDoublyLinkedList  convertBinarySearchTreetoSortedDoublyLinkedList = new ConvertBinarySearchTreetoSortedDoublyLinkedList();

        Node list = convertBinarySearchTreetoSortedDoublyLinkedList.treeToDoublyList(root);
        System.out.println(list.val);

    }
}