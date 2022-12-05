package gucheng.binary;

import java.util.stream.IntStream;

// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {

        int sum = IntStream.of(nums).sum() ;
        int max = IntStream.of(nums).max().orElse(sum) ;


        return splitArray(nums , max , sum , k);

    }

    public int splitArray( int nums[] , int left , int right ,  int k)
    {
        // like fine the first occurance

        while(left < right){

            int middle = left + ( right -left )/2 ;


            int splits = calculateSplits(nums , middle);

            if(splits == k){
                right = middle ;
            }
            else if ( splits < k){
                right = middle -1 ;
            }
            else{
                left = middle +1;
            }
        }

        return left ;
    }

    public int calculateSplits(int[] nums , int cap){

        int count = 1;
        int total = 0;
        for(int index = 0 ;index < nums.length ; index++){
            if(total + nums[index] > cap){
                total = nums[index];
                count ++;
            }
            else{
                total += nums[index];
            }
        }

        return count ;
    }

    public static void main(String args[]){
        int nums[]  = new int[] {7,2,5,10,8};
        SplitArrayLargestSum  splitArrayLargestSum = new SplitArrayLargestSum();
        System.out.println(splitArrayLargestSum.splitArray(nums , 2));

        nums = new int[] {1,2,3,4,5};;
        System.out.println(splitArrayLargestSum.splitArray(nums , 2));

    }
}
