package gucheng.algorithms.prefixsum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubarraySum{

    public boolean checkSubarraySum(int[] nums, int k) {
        // two sum
        // 余數相同 and size >= 2

        boolean ans = false ;
        int sums[] = new int[nums.length];
        int sum = 0 ;
        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
            sums[index] = sum;
        }

        Map<Integer , Integer> firstOccurIndex = new HashMap<>();
        firstOccurIndex.put(0 , -1);
        for(int index = 0 ; index < nums.length ; index++){
            int remainder = (sums[index] % k + k)%k;  // to make the remainder between 0 , k even sums[index] is negative

            if(firstOccurIndex.containsKey(remainder)){
                if(index - firstOccurIndex.get(remainder) >= 2){
                    ans = true ;
                    break;
                }
            }else{
                    firstOccurIndex.put(remainder , index);
            }
        }
        return ans ;
    }

    public static void main(String[] args){

        int nums[] ;
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        nums = new int[] {23,2,4,6,7};
        //System.out.println(continuousSubarraySum.checkSubarraySum(nums , 6));
        nums = new int[] { 23 , 2 , 6 , 4 , 7};
        //System.out.println(continuousSubarraySum.checkSubarraySum(nums , 6));
        //System.out.println(continuousSubarraySum.checkSubarraySum(nums , 13));

        nums = new int[] {23,2,4,6,6};
        // 23 , 2 , 4 , 6 -> 35
        System.out.println(continuousSubarraySum.checkSubarraySum(nums , 7));
        nums = new int[]{1 , 0};
        System.out.println(continuousSubarraySum.checkSubarraySum(nums , 2));
        nums = new int[]{1 , 0 , 0};
      System.out.println(continuousSubarraySum.checkSubarraySum(nums , 2));
        nums = new int[]{2 ,4 , 3};
        System.out.println(continuousSubarraySum.checkSubarraySum(nums , 6));
        nums = new int[] { 1 , 2 , 12};
        System.out.println(continuousSubarraySum.checkSubarraySum(nums , 6));
    }
}
