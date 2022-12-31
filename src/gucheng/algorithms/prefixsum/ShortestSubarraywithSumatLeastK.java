package gucheng.algorithms.prefixsum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] nums, int k) {

        int ans = Integer.MAX_VALUE;


        long[] sums = new long[nums.length+1] ;
        for(int index = 1 ; index < sums.length ; index++){
            sums[index] = sums[index-1] + nums[index-1]; ;
        }

        Deque<Integer> queue = new LinkedList<>();

        for(int index = 0 ; index < sums.length ; index++){

            while(!queue.isEmpty() && sums[index] - sums[queue.peekFirst()] >=k){
                ans = Math.min(ans , index - queue.pollFirst());
            }


            while(!queue.isEmpty() && sums[index] < sums[queue.peekLast()] ){
                queue.pollLast();
            }
            queue.offerLast(index);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }

    public static void main(String args[]){
        int nums[]  ;
        ShortestSubarraywithSumatLeastK shortestSubarraywithSumatLeastK = new ShortestSubarraywithSumatLeastK();
        nums = new int[] {1};
        System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 1));
        nums = new int[]{ 1, 2};
       System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 4));
        nums = new int[]{ 2 , -1, 2};
        System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 3));
    }

}
