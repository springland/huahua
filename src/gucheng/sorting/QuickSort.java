package gucheng.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class QuickSort {


    public static void main(String args[]){

        int[] nums  = new int[] { 3 , 7 , 9 , 2 ,4 , 10 , 6 , 5};
        int[] expected = Arrays.copyOf(nums , nums.length);
        Arrays.sort(expected);

        sort(nums  );
        IntStream.of(nums).forEach(System.out::println);
        assertArrayEquals(nums , expected);
    }

    public static void sort(int nums[] )
    {
        sort(nums , 0 , nums.length-1);
    }

    public static void sort(int nums[]  , int beginIndex , int endIndex){

        if(beginIndex >= endIndex){
            return ;
        }


        int left = beginIndex -1 ;
        int pivotal = nums[endIndex];
        for(int index = beginIndex ; index < endIndex ; index++){
            if(nums[index] <= pivotal){
                left ++ ;
                int temp = nums[index];
                nums[index] = nums[left] ;
                nums[left] = temp ;
            }
        }
        left ++ ;
        nums[endIndex] = nums[left];
        nums[left] = pivotal ;

        sort(nums , beginIndex , left-1);
        sort(nums , left+1 , endIndex);
    }
}
