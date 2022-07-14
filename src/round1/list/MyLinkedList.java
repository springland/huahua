package round1.list;

/**
 * https://leetcode.com/problems/design-linked-list/
 */
public class MyLinkedList {

    class Node {
        int val ;
        Node prev ;
        Node next ;

        Node(){

        }

        Node(int val)
        {
            this.val = val ;
        }


    }

    Node head  = null;
    Node tail  = null;
    public MyLinkedList() {
        head  = new Node();
        tail  = new Node();

        head.next = tail ;
        tail.prev = head ;

    }

    public int get(int index) {


        Node node = head ;
        while(node != tail && index-- >= 0){
            node = node.next ;
        }
        if(node == tail){
            return -1 ;
        }
        else{
            return node.val ;
        }

    }

    public void addAtHead(int val) {

        Node node = new Node(val);
        node.next = head.next ;
        node.next.prev = node ;
        node.prev=head ;
        head.next = node ;

    }

    public void addAtTail(int val) {

        Node node = new Node(val) ;
        node.next = tail ;
        node.prev = tail.prev ;
        tail.prev = node ;
        node.prev.next = node ;
    }

    public void addAtIndex(int index, int val) {

        Node node = head ;
        while(index-- >= 0){
            node = node.next ;
        }

        if(node != null ){
            Node newNode = new Node(val);
            newNode.next = node ;
            newNode.prev = node.prev ;
            node.prev = newNode ;
            newNode.prev.next = newNode ;

        }
    }

    public void deleteAtIndex(int index) {

        Node node = head ;
        while(index-- >= 0){
            node = node.next ;
        }

        if(node != null && node != tail)
        {
            Node prev = node.prev ;
            prev.next = node.next ;
            node.next.prev = prev ;

        }

    }

    public static void main(String args[]){
        MyLinkedList  list = new MyLinkedList();


        list.addAtHead(7);

        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3 ,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        /*

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1 , 2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);;
        System.out.println(list.get(1));
        */
    }
}
