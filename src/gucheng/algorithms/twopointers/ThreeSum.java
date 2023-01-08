package gucheng.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int index = 0 ; index <  nums.length-2 ; index++)
        {
            if(index > 0 && nums[index] == nums[index-1]) continue ;
            List<List<Integer>> threeSums = threeSums(nums , index , index+1 , nums.length-1);
            ans.addAll(threeSums);
        }
        return ans ;
    }

    public List<List<Integer>> threeSums(int[] nums , int index , int beginIndex , int endIndex){

        int targetValue = -nums[index];
        List<List<Integer>> ans = new ArrayList<>();
        while(beginIndex < endIndex){
            if(nums[beginIndex] + nums[endIndex] == targetValue){
                ans.add(List.of(nums[index] , nums[beginIndex] , nums[endIndex]));
                while(beginIndex < endIndex && nums[beginIndex +1] == nums[beginIndex]){
                    beginIndex ++;
                }
                beginIndex ++ ;
                while(endIndex > beginIndex && nums[endIndex-1] == nums[endIndex]){
                    endIndex--;
                }
                endIndex -- ;
            }else if (nums[beginIndex] + nums[endIndex] < targetValue ){
                while(beginIndex < endIndex && nums[beginIndex+1] == nums[beginIndex]) beginIndex++;
                beginIndex ++;
            } else {
                while(beginIndex < endIndex && nums[endIndex-1] == nums[endIndex] ) endIndex-- ;
                endIndex-- ;
            }
        }

        return ans ;
    }

    public static void main(String args[]){
        int nums[] ;
        nums = new int[] {-1,0,1,2,-1,-4};

        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));

    }
}
