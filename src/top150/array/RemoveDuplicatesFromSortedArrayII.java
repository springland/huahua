package top150.array;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        int currentValueIndex = -1 ;
        int headIndex = 0 ;
        int maxOccur = 2 ;

        for(int index = 0 ; index < nums.length ; index++){

            if(currentValueIndex < 0 || nums[index] != nums[currentValueIndex]){
                nums[headIndex++] = nums[index];
                currentValueIndex = index ;
            }
            else if( index - currentValueIndex < maxOccur){
                nums[headIndex++] = nums[index];
            }
        }

        return headIndex ;
    }
}
