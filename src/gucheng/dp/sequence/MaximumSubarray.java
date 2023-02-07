package gucheng.dp.sequence;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        return recursive(nums);
    }

    public int recursive(int[] nums){

        Integer[] memo = new Integer[nums.length];
        return recursive(nums , 0  , memo);
    }

    public int recursive(int[] nums , int index , Integer[] memo){
        return 0 ;
    }

}
