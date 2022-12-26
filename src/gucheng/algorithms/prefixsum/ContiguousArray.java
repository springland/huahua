package gucheng.algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/
public class ContiguousArray {
    public int findMaxLength(int[] nums) {

        //return brutalForce(nums);
        return prefixsum(nums);
    }

    public int prefixsum(int nums[]){
        int ans = 0 ;
        Map<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int[] sums = new int[nums.length];
        map.put(0 , -1);
        for(int index = 0 ; index < nums.length ; index++){
            if(nums[index] == 0 ) {
                sum += -1;
            }else{
                sum += 1 ;
            }
            sums[index] = sum ;
        }

        for(int index = 0 ; index < sums.length ; index++){
            if(map.containsKey(sums[index])){
                ans = Math.max(ans , index - map.get(sums[index]));
            }else {
                map.put(sums[index], index);
            }
        }

        return ans ;
    }
    public int brutalForce(int nums[]){
        int ans = 0 ;
        for(int leftIndex = 0 ; leftIndex < nums.length-1 ; leftIndex++){
            for(int rightIndex = leftIndex +1 ; rightIndex < nums.length ; rightIndex++){
                if(isValid(nums , leftIndex , rightIndex)){
                    ans = Math.max(ans , rightIndex - leftIndex+1);
                }
            }
        }
        return ans ;
    }
    public boolean isValid(int nums[] , int beginIndex , int endIndex){
        int  sum = 0;
        for(int index = beginIndex ; index <= endIndex ; index++){
            sum += nums[index];
        }
        return sum == endIndex - beginIndex +1 - sum ;
    }

    public static void main(String args[]){
        ContiguousArray contiguousArray = new ContiguousArray();
        int nums[] ;
        nums = new int[] {0 , 1};
        System.out.println(contiguousArray.findMaxLength(nums));

        nums = new int[] {0 , 1, 0};
        System.out.println(contiguousArray.findMaxLength(nums));

        nums = new int[] {0 ,1 , 0 , 1};
        System.out.println(contiguousArray.findMaxLength(nums));
    }
}
