package round1.divideandconquer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {


        int[]  smallerCounts = new int[nums.length];
        smallerCounts[nums.length-1] = 0;

        countSmaller(nums , smallerCounts , nums.length-2);

        return IntStream.of(smallerCounts).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public void countSmaller(int nums[] , int smallerCounts[] , int index)
    {
        if(index == -1)
        {
            return ;
        }



        countSmaller(nums , smallerCounts , index-1);

    }
}
