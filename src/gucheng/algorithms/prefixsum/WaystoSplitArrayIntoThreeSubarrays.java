package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/
public class WaystoSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {

        int[] sums = new int[nums.length];
        int sum = 0;
        int ans = 0 ;
        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            sums[index] = sum ;
        }

        return ans ;
    }
}
