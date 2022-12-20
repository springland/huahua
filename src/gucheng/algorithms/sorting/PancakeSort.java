package gucheng.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PancakeSort {

    public static void main(String args[])
    {

        int[] nums  = new int[] { 3 , 7 , 9 , 2 ,4 , 3 , 2  , 7 , 9 , 4 , 3,10 , 6 , 5};
        int[] expected = Arrays.copyOf(nums , nums.length);
        Arrays.sort(expected);

        sort(nums);
        IntStream.of(nums).forEach(System.out::println);
        assertArrayEquals(nums , expected);

    }

    public static void sort(int nums[])
    {
        sort(nums , nums.length);
    }

    public static void sort(int nums[] , int length)
    {
        int endIndex = 0 ;

        if(length <= 1 )
        {
            return ;
        }
        for(int index = 0 ; index < length; index++ )
        {
            if(nums[index] > nums[endIndex]){
                endIndex = index ;
            }
        }

        flip(nums , 0 , endIndex);

        flip(nums , 0 , length-1);

        sort(nums , length-1);


    }

    public static void flip(int nums[] , int beginIndex , int endIndex)
    {
        while(beginIndex < endIndex)
        {
            int temp = nums[beginIndex];
            nums[beginIndex]= nums[endIndex];
            nums[endIndex] = temp;

            beginIndex ++;
            endIndex -- ;
        }
    }
}
