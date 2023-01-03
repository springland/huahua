package gucheng.algorithms.prefixsum;
// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length+1];
        int ans = Integer.MAX_VALUE;
        for(int index = 1 ; index < sums.length ; index++){
            sums[index] += sums[index-1]+ nums[index-1];
        }

        int left = 0 ;
        for(int right = 1 ; right < sums.length ; right++){
            if(sums[right] - sums[left] >= target){
                while(sums[right] - sums[left] >= target){
                    ans = Math.min(ans , right - left);
                    left ++ ;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
}
