package gucheng.algorithms.sorting;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public void sortColors(int[] nums) {

        int left = 0 ;
        int right = nums.length-1 ;
        int index = 0 ;
        while(index <= right){

            switch(nums[index]){
                case 0:
                    swap(nums , index , left);
                    index++;
                    left++;
                    break;
                case 1:
                    index++;
                    break;
                case 2:
                    swap(nums , index , right);
                    right -- ;
                    break;
            }
        }
    }

    public void swap(int[] nums  , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String args[]){
        SortColors  sortColors = new SortColors();

        int nums[] = new int[] {2,0,2,1,1,0};
        sortColors.sortColors(nums);
        System.out.println(IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
