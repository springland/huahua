package gucheng.algorithms.prefixsum;
// https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        int[] prefixSums = new int[nums.length];
        int[] suffixSums = new int[nums.length];
        int sum  = 0;

        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            prefixSums[index] = sum ;
        }

        sum = 0 ;
        for(int index = nums.length-1 ; index >= 0 ; index--){

            sum  += nums[index];
            suffixSums[index] = sum ;

        }

        for(int index = 0 ; index < nums.length ; index++){
            if(prefixSums[index] == suffixSums[index]){
                return index ;
            }
        }
        return -1 ;
    }

    public static void main(String args[]){
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int nums[];
        nums = new int[] {1,7,3,6,5,6};
        System.out.println(findPivotIndex.pivotIndex(nums));
        nums = new int[] {1,2,3};
        System.out.println(findPivotIndex.pivotIndex(nums));
        nums = new int[] {2,1, -1};
        System.out.println(findPivotIndex.pivotIndex(nums));
    }
}
