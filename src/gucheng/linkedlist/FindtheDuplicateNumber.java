package gucheng.linkedlist;


import java.util.stream.IntStream;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int duplicate = -1;
        for(int index = 0 ; index < nums.length ; index++)
        {
            int numIndex =Math.abs(nums[index]);

            if(nums[numIndex] < 0){
                duplicate = numIndex ;
                break;
            }
            nums[numIndex] = -nums[numIndex];
        }

        for(int index = 0 ; index < nums.length ; index++)
        {
            if(nums[index] < 0){
                nums[index] = -nums[index];
            }
        }

        return duplicate ;
    }

}
