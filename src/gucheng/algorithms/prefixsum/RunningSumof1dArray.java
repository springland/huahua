package gucheng.algorithms.prefixsum;
//https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {

        int sum = 0 ;
        int sums[] = new int[nums.length];
        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            sums[index] = sum;
        }
        return sums ;
    }
}
