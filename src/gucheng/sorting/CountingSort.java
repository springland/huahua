package gucheng.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingSort {

    public static void main(String args[]){

        int[] nums  = new int[] { 3 , 7 , 9 , 2 ,4 , 3 , 2  , 7 , 9 , 4 , 3,10 , 6 , 5};
        int[] expected = Arrays.copyOf(nums , nums.length);
        Arrays.sort(expected);
        sort(nums);
        IntStream.of(nums).forEach(System.out::println);
        assertArrayEquals(nums , expected);


    }


    public static  void sort(int nums[])
    {

        // assume range is between 0 to 99
        int[] count = new int[100];

        for( int num : nums){
            count[num] ++;
        }

        for(int index = 1 ; index < count.length ; index++)
        {
            count[index] += count[index-1];
        }

        int[] result = new int[nums.length];
        for(int num : nums){
            result[--count[num]] = num ;
        }

        System.arraycopy(result , 0 , nums , 0 , nums.length);
    }
}
