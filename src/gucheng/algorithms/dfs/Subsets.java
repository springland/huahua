package gucheng.algorithms.dfs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>>  subsets = new ArrayList<>();

        //subsets(nums , 0 , new ArrayList<Integer>() , subsets);
        subsets(nums , subsets);

        return subsets;
    }

    public void subsets(int nums[] , int start , List<Integer> subset , List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(subset));
        for(int index = start ; index < nums.length ; index++){
            subset.add(nums[index]);
            subsets(nums , index+1 , subset , subsets);
            subset.remove(subset.size()-1);

        }
    }

    public void subsets(int nums[] , List<List<Integer>> subsets) {

        int size =0 ;
        for(int index = 0 ; index < nums.length ; index++) {
            size= (size <<  1) | 1 ;
        }

        for(int num = 0 ; num <= size ; num++){

            List<Integer>  subset = new ArrayList<>();
            int mask =  1;
            for( int index = 0 ; index < nums.length ; index++ ){
                if((num & mask) != 0){
                    subset.add(nums[index]);
                }
                mask = mask << 1 ;
            }
            subsets.add(subset);
        }
    }

    public static void main(String args[]){
        int[] nums = new int[] { 1 , 2 , 3};

        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
