package gucheng.heap;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSort {


    public static void main(String args[]){

        int[] nums = new int[]{ 3 , 2 , 4 , 9 , 5 , 7};
        int[] sorted = Arrays.copyOf(nums , nums.length);
        Arrays.sort(sorted);
        sort(nums);
        assertArrayEquals(sorted , nums);

    }
    public static void sort(int nums[])
    {
        sort(nums , nums.length);

    }

    public static void sort(int nums[] , int length)
    {
        for(int size = length ; size >= 1 ; size -- )
        {

            for(int index = (size -1) /2 ; index >= 0 ; index --)
            {
                heapify(nums , index , size);
            }
            swap(nums , 0 , size-1);
        }
    }

    public static void heapify(int nums[] , int index , int size)
    {
        if(2*index+1 < size && nums[index] < nums[2*index+1])
        {
            swap(nums , index , 2*index+1);
            heapify(nums , 2*index+1 , size);
        }
        if(2*index+2 < size && nums[index] < nums[2*index+2])
        {
            swap(nums  , index , 2*index+2);
            heapify(nums , 2*index+1 , size);
        }
    }
    public static void swap(int nums[] , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }
}
