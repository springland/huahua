package gucheng.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>>  result = new ArrayList<>();
        permute(nums , 0 , nums.length-1 , result);

        return result ;
    }

    public void permute(int[] nums , int beginIndex , int endIndex  , List<List<Integer>>result)
    {

        if(beginIndex == nums.length-1) {
            result.add( IntStream.of(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        }

        for( int index = beginIndex ; index <= endIndex ; index++)
        {
            swap(nums , beginIndex , index);
            permute(nums , beginIndex+1 , endIndex , result);
            swap(nums, beginIndex ,index);
        }
    }

    protected void swap(int[] nums , int leftIndex ,int rightIndex){
        int temp = nums[leftIndex];
        nums[leftIndex]= nums[rightIndex];
        nums[rightIndex]= temp ;

    }


}
