package top150.array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {



        int headIndex = 0 ;

        int currentValueIndex = -1 ;
        for(int index = 0 ; index < nums.length ; index++ ){
            if(currentValueIndex < 0 || nums[index] != nums[currentValueIndex]){
                nums[headIndex++] = nums[index];
                currentValueIndex = index ;
            }
        }

        return headIndex ;
    }
}
