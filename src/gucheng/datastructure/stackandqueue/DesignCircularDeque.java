package gucheng.datastructure.stackandqueue;

// https://leetcode.com/problems/design-circular-deque/description/
public class DesignCircularDeque {

    public DesignCircularDeque(int k) {
        nums = new int[k+1];

    }
    int nums[] ;
    int front ;
    int end  ;

    public boolean insertFront(int value) {
        if(isFull())
        {
            return false ;
        }

        front = front -1;
        if(front < 0)
        {
            front = nums.length-1;
        }
        nums[front] = value ;

        return true ;
    }

    public boolean insertLast(int value) {

        if(isFull())
        {
            return false ;
        }
        nums[end] = value ;
        end = (end+1)%nums.length;
        return true ;
    }

    public boolean deleteFront() {

        if(isEmpty())
        {
            return false ;
        }

        front = (front+1)%nums.length;
        return true ;
    }

    public boolean deleteLast() {

        if(isEmpty())
        {
            return false ;
        }

        end = end -1 ;
        if(end < 0)
        {
            end = nums.length-1;
        }
        return true ;
    }

    public int getFront() {
        if(isEmpty())
        {
            return -1 ;
        }

        return nums[front];
    }

    public int getRear() {
        if(isEmpty())
        {
            return -1 ;
        }

        if(end == 0){
            return nums[nums.length-1];
        }
        else{
            return nums[end-1];
        }
    }

    public boolean isEmpty() {
        return front == end ;

    }

    public boolean isFull() {

        return (end +1 % nums.length) == front ;
    }


}
