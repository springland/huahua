package gucheng.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationII {

    public static void main(String args[]){
        int nums[] = new int[] {0,1,0,0,9};
        PermutationII permutation = new PermutationII();
        List<List<Integer>>  result = permutation.permuteUnique(nums);

        result.stream().forEach(System.out::println);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        permuteUnique(nums , 0 , result);
        return result ;

    }

    public void permuteUnique(int[] nums , int beginIndex  , List<List<Integer>> result)
    {
        if(beginIndex == nums.length -1){
            result.add(IntStream.of(nums).mapToObj(Integer::valueOf).collect(Collectors.toList()));
            return ;
        }

        HashSet<Integer> visited = new HashSet<>();

        for(int index = beginIndex ; index < nums.length ; index++)
        {
            swap(nums , beginIndex ,index);
            if(visited.add(nums[beginIndex])){
                permuteUnique(nums , beginIndex+1 , result);
            }
            swap(nums , beginIndex , index);
        }


    }

    public void swap(int[] nums , int leftIndex , int rightIndex){
        int temp = nums[leftIndex];
        nums[leftIndex]= nums[rightIndex];
        nums[rightIndex]= temp ;
    }
}
