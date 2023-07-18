package top150.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/3sum/?envType=study-plan-v2&envId=top-interview-150
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for(int index = 0 ; index < nums.length ; index++){

            if(index == 0 || nums[index-1] != nums[index]){
                twoSum(nums , index , res);

            }

        }
        return res;
    }

    public void twoSum(int[] nums , int index , List<List<Integer>> res){

        if(nums[index] > 0){
            return ;
        }

        int left = index+1 ;
        int right = nums.length-1;

        while(left < right){
            int sum = nums[index] + nums[left] + nums[right];
            if(sum == 0){
                List<Integer> ans = List.of(nums[index] , nums[left] , nums[right]);
                res.add(ans);

                left++;
                while(left < right && nums[left] == nums[left-1])left++;
            }
            else if ( sum < 0){
                left ++;
            }else {
                right --;
            }
        }
    }
}
