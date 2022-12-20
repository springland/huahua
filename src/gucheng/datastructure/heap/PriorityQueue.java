package gucheng.datastructure.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

// create a min priority queue
public class PriorityQueue {


    public static void main(String args[])
    {

        PriorityQueue pq = new PriorityQueue(10);
        pq.offer(5);
        pq.offer(8);
        pq.offer(3);
        assertEquals(pq.peek() , 3);
        pq.offer(2);
        pq.offer(-5);
        assertEquals(pq.peek() , -5);
        assertEquals(pq.poll() , -5);
        assertEquals(pq.poll() , 2);
        assertEquals(pq.poll() , 3);
        assertEquals(pq.peek() , 5);

    }
    int nums[] ;
    int size ;
    public PriorityQueue(int size)
    {
        nums = new int[size];
        this.size = 0 ;

    }

    public boolean offer(int num)
    {
        if(size < nums.length)
        {
            nums[size] = num ;
            size ++ ;

            int index = size -1 ;
            int parentIndex = (index-1)/2;
            while(parentIndex >= 0) {
                if (nums[parentIndex] > nums[index]) {
                    swap(nums , parentIndex , index);
                    index = parentIndex ;
                    parentIndex = parentIndex/2 ;
                }
                else{
                    break;
                }
            }
            return true ;
        }
        return false ;
    }

    public Integer poll()
    {
        if(size == 0)
        {
            return null;
        }

        Integer value = nums[0];

        swap(nums , 0 , size-1);
        size -- ;
        pushdown(nums , 0 , size);

        return value ;
    }

    protected void pushdown(int nums[] , int index , int size)
    {
        if(index*2 + 2 < size)
        {
            if(nums[index*2 +2] < nums[index*2+1])
            {
                swap(nums , index , index*2+2);
                pushdown(nums , index*2+2 , size);
            }
            else{
                swap(nums , index ,index*2+1);
                pushdown(nums , index*2+1 , size);
            }

        }
        else if ( index*2 + 1 < size){
            if(nums[index*2+1] < nums[index]) {
                swap(nums, index, index * 2 + 1);
                pushdown(nums, index * 2 + 1, size);
            }
        }
    }



    protected void swap(int nums[] , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;

    }
    public Integer peek()
    {
        if(size == 0)
        {
            return null;
        }
        return nums[0];
    }
}
