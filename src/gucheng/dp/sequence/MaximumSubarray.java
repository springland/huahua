package gucheng.dp.sequence;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int ans = Integer.MIN_VALUE ;
        int sum = 0;

        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            ans = Math.max(ans , sum);
            if(sum < 0){
                sum = 0;
            }


        }
        return ans ;
    }


}
