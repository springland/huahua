package gucheng.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarrayswithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {

        int ans = 0 ;
        if(k == 0){
            return ans ;
        }
        ans = atMostK(nums , k) - atMostK(nums , k-1);
        return ans ;
    }


    public int atMostK(int nums[] , int k){
        int ans = 0 ;
        Map<Integer , Integer> countMap  = new HashMap<>();
        int leftIndex = 0 ;
        for(int rightIndex = 0 ; rightIndex < nums.length ; rightIndex++){

            if(countMap.getOrDefault(nums[rightIndex] , 0) == 0) k -- ;
            countMap.put(nums[rightIndex] , countMap.getOrDefault(nums[rightIndex] , 0)+1);

            while(k < 0){
                countMap.put(nums[leftIndex] , countMap.get(nums[leftIndex])-1);
                if(countMap.get(nums[leftIndex]) == 0) k++;
                leftIndex++;
            }


            // If a subarray has K distinct elements, then total subarrays will be n*(n+1)/2,
            // which will include subarrays with k , k-1, k-2, k-3...1 distinct elements.  for example 3 elements  1 + 2 + 3 = 6 = 3*(3+1)/2

            // Not sure why this works
            ans += rightIndex - leftIndex +1 ;
        }

        // ans is atMostK  , for example {1,2,1,2,3} , k = 2  , ans = 12
        return ans ;
    }

    public static void main(String args[]){
        int nums[] ;

        nums = new int[] {1,2,1,2,3};
        SubarrayswithKDifferentIntegers subarrayswithKDifferentIntegers = new SubarrayswithKDifferentIntegers();

        //[ 1] , [2] , [1] , [2] , [3] , [1 , 2] ,[2 ,1] ,[1, 2]  [1 ,2 , 1] , [2 ,1 , 2] ,  [1 ,2 ,1 , 2] ,  , [2 , 3]  , totally 12
        System.out.println(subarrayswithKDifferentIntegers.atMostK(nums , 2));

        System.out.println(subarrayswithKDifferentIntegers.subarraysWithKDistinct(nums , 2));
    }
}


