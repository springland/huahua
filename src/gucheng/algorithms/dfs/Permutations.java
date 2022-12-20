package gucheng.algorithms.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/permutations/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>>  result = new ArrayList<>();

        permute(nums , 0 ,  result);
        return result ;
    }

    public void permute(int nums[] ,int start ,   List<List<Integer>> result ) {

        if(start == nums.length){

            result.add(IntStream.of(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
            return ;
        }

        for(int index = start ; index < nums.length ; index++){
            swap(nums , start ,index) ;

            permute(nums , start+1 ,  result);
            swap(nums , start ,index) ;
        }

    }

    public void swap( int[] nums , int  left , int right )
    {
        int temp = nums[left];
        nums[left] = nums[right] ;
        nums[right] = temp ;
    }

    public static void main(String args[]){

        int[] nums = new int[] { 1 , 2 , 3        } ;
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }

}
