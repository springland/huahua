package top150.array;

import java.util.Arrays;

// https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
public class MajorityElement {
    public int majorityElement(int[] nums) {


        //return solution1(nums);
        return solution2(nums);
    }

    public int solution1(int[] nums){

        Arrays.sort(nums);
        return nums[nums.length/2];

    }

    public int solution2(int[] nums){

        int count = 1 ;
        int majorElement = nums[0];

        for(int index = 1 ; index < nums.length ;index++ ){

            if(nums[index] == majorElement){
                count ++;
            }
            else{
                count -- ;
                if(count < 0){
                    count = 1;
                    majorElement = nums[index];
                }
            }

        }

        return majorElement ;
    }
}
