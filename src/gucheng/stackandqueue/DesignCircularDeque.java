package gucheng.stackandqueue;

// https://leetcode.com/problems/design-circular-deque/description/
public class DesignCircularDeque {

    public DesignCircularDeque(int k) {
        nums = new int[k+1];

    }
    int nums[] ;
    int front ;
    int end  ;

    public boolean insertFront(int value) {

    }

    public boolean insertLast(int value) {

    }

    public boolean deleteFront() {

    }

    public boolean deleteLast() {

    }

    public int getFront() {

    }

    public int getRear() {

    }

    public boolean isEmpty() {
        return front == end ;

    }

    public boolean isFull() {

        return (end +1 % nums.length) == front ;
    }


}
