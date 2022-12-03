package gucheng.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// https://leetcode.com/problems/combinations/
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int[] nums = IntStream.range( 1 , n+1).toArray();
        combine(nums, 0 , k , new ArrayList<>() , result);
        return result ;
    }

    public void combine(int[] nums , int start , int k , List<Integer> subset , List<List<Integer>> result){

        if(subset.size() ==  k){
            result.add(new ArrayList<>(subset));
        }

        for(int index = start ; index < nums.length ; index++){
            subset.add(nums[index]);

            combine(nums , index+1 , k , subset , result);
            subset.remove(subset.size()-1);

        }
    }

    public static void main(String[] args){

        Combinations combinations = new Combinations();

        System.out.println(combinations.combine(3 , 2));
    }
}
