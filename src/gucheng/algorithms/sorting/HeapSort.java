package gucheng.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSort {

    public static void main(String args[]){

        int[] nums  = new int[] { 3 , 7 , 9 , 2 ,4 , 10 , 6 , 5};
        int[] expected = Arrays.copyOf(nums , nums.length);
        Arrays.sort(expected);

        sort(nums);
        IntStream.of(nums).forEach(System.out::println);
        assertArrayEquals(nums , expected);

    }

    public static void sort(int[] nums)
    {


        for( int endIndex = nums.length-1 ; endIndex> 0  ; endIndex--)
        {


            int lastNonLeafIndex = (endIndex+1)/2-1;

            for(int index =lastNonLeafIndex ; index >= 0 ; index--){
                heapify(nums , index , endIndex);
            }


            // swap the first and the last
            int temp = nums[endIndex];
            nums[endIndex] = nums[0] ;
            nums[0]= temp ;

        }
    }

    public static void heapify(int[] nums , int index , int endIndex)
    {
        //  k >= 2K+1 , K >= 2k+2

        if(2* index+1 <= endIndex && nums[index] < nums[2*index+1])
        {
            int temp = nums[index];
            nums[index] = nums[2*index+1];
            nums[2*index+1]= temp ;

            heapify(nums , 2*index+1 , endIndex);
        }

        if(2* index+2 <= endIndex && nums[index] < nums[2*index+2])
        {
            int temp = nums[index];
            nums[index] = nums[2*index+2];
            nums[2*index+2]= temp ;
            heapify(nums , 2*index+2 , endIndex);
        }

    }
}
