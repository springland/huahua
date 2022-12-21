package gucheng.algorithms.sorting;

import java.util.*;

// https://leetcode.com/problems/maximum-gap/
public class MaximumGap {

    public int maximumGap(int[] nums) {

        // You must write an algorithm that runs in linear time and uses linear extra space.

        //return quickSort(nums) ;
        return radixSort(nums);
    }

    public int radixSort(int[] nums) {


        if(nums.length <= 1) {
            return 0 ;
        }
        // radix sort is O(n)  , the input range is 0 ~ 10^9 , so O(9n) , use counting sort


        int base = 1 ;
        for(int baseIndex = 0 ; baseIndex < 10 ; baseIndex ++){
            TreeMap<Integer , List<Integer>> treeMap = new TreeMap<>();
            for(int index = 0 ; index < nums.length ; index++){
                int remainder = (nums[index]/base)%10 ;
                List<Integer>  list = treeMap.getOrDefault(remainder , new ArrayList<>());

                list.add(nums[index]);
                treeMap.put(remainder , list);
            }
            base = base * 10 ;

            int index = 0;
            while(!treeMap.isEmpty())
            {
                Map.Entry<Integer , List<Integer>> entry = treeMap.pollFirstEntry();
                for( int value : entry.getValue()){
                    nums[index++] = value ;
                }
            }
        }

        int ans = Integer.MIN_VALUE ;
        for(int index = 1 ; index < nums.length ; index++){
            ans = Math.max(ans , nums[index] - nums[index-1]);
        }

        return ans ;
    }

    public int quickSort(int[] nums){
        if(nums.length <= 1) {
            return 0 ;
        }
        Arrays.sort(nums);

        int ans = Integer.MIN_VALUE ;
        for(int index = 1 ; index < nums.length ; index++){
            ans = Math.max(ans , nums[index] - nums[index-1]);
        }
        return ans ;
    }

    public static void main(String[] args){
        int[] nums ;

        nums = new int[] {3,6,9,1} ;
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(nums));


    }

}
