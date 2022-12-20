package gucheng.algorithms.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        subsetsWithDup(nums , 0 , new ArrayList<>() , result);
        return result ;
    }

    public void subsetsWithDup(int nums[] , int start ,  List<Integer> subset , List<List<Integer>> result){
        result.add( new ArrayList(subset));

        for(int index = start ; index < nums.length ; index++){

            if(index != start && nums[index] == nums[index-1]) continue ;
            subset.add(nums[index]);
            subsetsWithDup(nums , index+1 , subset , result);
            subset.remove(subset.size()-1);
        }

    }


    public static void main(String args[]){
        int[] nums = new int[] { 1 , 2 , 2 , 2 , 3};
        SubsetsII  subset = new SubsetsII();

        System.out.println(subset.subsetsWithDup(nums));



    }
}
