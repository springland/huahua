package gucheng.stackandqueue;

import static org.junit.jupiter.api.Assertions.assertFalse;

// https://leetcode.com/problems/design-circular-queue/
public class MyCircularQueue {


    public static void main(String args[])
    {
        MyCircularQueue queue  = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        assertFalse(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
    int front ;

    int end ;

    int nums[];

    public MyCircularQueue(int k) {
        nums = new int[k+1];
    }

    public boolean enQueue(int value) {

        if(isFull())
        {
            return false ;
        }

        nums[end] = value ;
        end = (end+1)%nums.length ;
        return true ;
    }

    public boolean deQueue() {

        if(isEmpty())
        {
            return false ;
        }

        front = (front+1)%nums.length ;
        return true ;

    }

    public int Front() {

        if(isEmpty())
        {
            return -1 ;
        }

        return nums[front];

    }

    public int Rear() {

        if(isEmpty())
        {
            return -1;
        }
        if(end > 0) {
            return nums[end - 1];
        }
        else{
            return nums[nums.length-1];
        }
    }

    public boolean isEmpty() {

        return front == end ;


    }

    public boolean isFull() {

        return (end+1)% nums.length == front ;

    }

}
