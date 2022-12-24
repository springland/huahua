package gucheng.algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK {

    public int subarraysDivByK(int[] nums, int k) {

        int sums[] = new int[nums.length];
        int sum = 0 ;
        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            sums[index] = sum ;
        }

        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int ans = 0 ;
        for(int index = 0 ; index < nums.length ; index++){
            int remainder = (sums[index]%k +k)%k ;
            if(map.containsKey(remainder)){
                ans += map.get(remainder);
            }
            map.put(remainder , map.getOrDefault(remainder , 0)+1);
        }

        return ans ;
    }

    public static void main(String args[]){
        SubarraySumsDivisiblebyK subarraySumsDivisiblebyK = new SubarraySumsDivisiblebyK();
        int[] nums ;
        nums = new int[] {4,5,0,-2,-3,1};
        System.out.println(subarraySumsDivisiblebyK.subarraysDivByK(nums , 5));

        nums = new int[]{5};
        System.out.println(subarraySumsDivisiblebyK.subarraysDivByK(nums , 9));
    }
}
