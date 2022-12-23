package gucheng.algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // two sum template
        Map<Integer , Integer> map = new HashMap<>();
        int sum = 0 ;
        int ans = 0 ;
        map.put(0 , 1);
        for(int index = 0 ; index < nums.length; index++){
            sum += nums[index];
            int target = sum - k ;
            ans += map.getOrDefault(target , 0);
            map.put(sum , map.getOrDefault(sum , 0)+1);

        }
        return ans ;
    }

    public static void main(String args[]){

        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int nums[] ;
        nums = new int[] {1 , 1 , 1};
        System.out.println(subarraySumEqualsK.subarraySum(nums , 2));
    }
}
