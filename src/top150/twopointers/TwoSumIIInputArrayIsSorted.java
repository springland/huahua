package top150.twopointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
public class TwoSumIIInputArrayIsSorted {


    public int[] twoSum(int[] numbers, int target) {

            int left = 0 ;
            int right = numbers.length-1 ;

            while(left < right){
                int sum = numbers[left]+ numbers[right];
                if(sum == target){
                    break;
                }
                else if ( sum < target){
                    left ++;
                }
                else{
                    right --;
                }
            }

            return new int[] {left+1 , right+1};
    }

}
