package gucheng.algorithms.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/permutations-ii/description/
public class PermutationII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        permuteUnique(nums , 0 , result , used);

        return result ;

    }

    public void permuteUnique(int[] nums , int start , List<List<Integer>> result , boolean[] used){
        if(start == nums.length){
            result.add(IntStream.of(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
            return ;
        }

        HashSet<Integer>  visited = new HashSet<>();
        for(int index = start ; index < nums.length ; index++){

            swap(nums , start , index);
            if(visited.add(nums[start])) {
                permuteUnique(nums, start + 1, result, used);
            }
            swap(nums , start , index);
        }
    }
    public void swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right ] = temp ;

    }

    public static void main(String args[]){
        int nums[] = new int[] {0,1,0,0,9};
        PermutationII permutation = new PermutationII();
        System.out.println(permutation.permuteUnique(nums));
    }

}
