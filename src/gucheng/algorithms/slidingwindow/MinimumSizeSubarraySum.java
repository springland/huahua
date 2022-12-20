package gucheng.algorithms.slidingwindow;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;

        int leftIndex = 0 ;
        int sum = 0 ;
        for(int rightIndex = 0 ; rightIndex < nums.length ; rightIndex++){
            sum += nums[rightIndex];
            while(sum >= target ){
                ans = Math.min(ans , rightIndex - leftIndex+1);
                sum -= nums[leftIndex];
                leftIndex++;
            }
        }


        return ans == Integer.MAX_VALUE ? 0 : ans ;
    }

    public static void main(String args[]){
        int nums[] ;
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();

        nums = new int[] {2,3,1,2,4,3};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7 , nums));

        nums = new int[] {1,4,4};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(4 , nums));

        nums = new int[] {1,1,1,1,1,1,1,1};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(11 , nums));

    }
}
