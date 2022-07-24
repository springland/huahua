package round1.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfaSortedArray {
    public int[] sortedSquares(int[] nums) {

        int i = 0 ;
        int j = nums.length-1 ;

        List<Integer>  ans = new ArrayList<>();

        while(i <= j){

            if(nums[i]* nums[i] < nums[j] *nums[j])
            {
                ans.add(nums[j] *nums[j]);
                j--;
            }
            else{
                ans.add(nums[i] *nums[i]);
                i++;

            }
        }

        Collections.reverse(ans);
        int data[] = new int[ans.size()];
        for(int index = 0 ; index < data.length ; index++){
            data[index] = ans.get(index);
        }

        return data ;
    }
}
