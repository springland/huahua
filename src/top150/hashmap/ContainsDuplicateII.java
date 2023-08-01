package top150.hashmap;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer , Integer>  numberIndexMap = new HashMap<>();

        for(int index = 0 ; index < nums.length ; index++){

            if(numberIndexMap.containsKey(nums[index])){

                if(Math.abs(index - numberIndexMap.get(nums[index])) <= k){
                    return true ;
                }
            }
            numberIndexMap.put(nums[index]  , index);
        }

        return false ;
    }
}
