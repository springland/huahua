package gucheng.algorithms.twopointers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
public class SparseVector {


    ArrayList<int[]> valuesList ;
    int size ;
    SparseVector(int[] nums) {

        valuesList = new ArrayList<>();
        int beginIndex = 0;
        int endIndex = 0 ;

        int[] value ;

        while(endIndex < nums.length){
            while(endIndex < nums.length && nums[beginIndex] == nums[endIndex]) endIndex++;
            value = new int[] {nums[beginIndex] , endIndex-1};
            valuesList.add(value);
            beginIndex = endIndex ;

        }
        if(beginIndex < nums.length) {
            value = new int[]{nums[beginIndex], endIndex-1};
            valuesList.add(value);
        }
        size = nums.length ;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int ans = 0 ;

        int left = 0 ;
        int right = 0 ;
        for(int index = 0 ; index <size ; index++){

            while(left < valuesList.size() && valuesList.get(left)[1] < index){
                left ++ ;
            }
            if(right < vec.valuesList.size() && vec.valuesList.get(right)[1] < index){
                right ++ ;
            }
            ans +=  valuesList.get(left)[0] * vec.valuesList.get(right)[0];

        }
        return ans ;
    }

    public static void main(String args[]){
        int[] nums1 = new int[] {1,0,0,2,3};
        int[] nums2 = new int[] {0,3,0,4,0};

        SparseVector vec1 = new SparseVector(nums1);
        SparseVector vec2 = new SparseVector(nums2);

        System.out.println(vec1.dotProduct(vec2));
    }

}
