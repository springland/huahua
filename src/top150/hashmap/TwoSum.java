package top150.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/two-sum/?envType=study-plan-v2&envId=top-interview-150
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        Map<Integer  , Integer>  map = new HashMap<>();
        for(int index = 0 ; index < nums.length ; index++){
            int value = target - nums[index];

            if(map.containsKey(value)){

                ans[0] = map.get(value);
                ans[1] = index ;
                break;
            }
            else{
                map.put(nums[index] , index);
            }

        }

        return ans ;
    }
}
