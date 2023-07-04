package top150.array;

// https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int headIndex = 0 ;

        for(int index = 0 ; index < nums.length ; index++){
            if(nums[index] != val){
                nums[headIndex++] = nums[index];
            }
        }
        return headIndex ;
    }
}
