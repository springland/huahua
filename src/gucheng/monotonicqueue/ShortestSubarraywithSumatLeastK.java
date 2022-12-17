package gucheng.monotonicqueue;

import java.util.Deque;
import java.util.LinkedList;


// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
public class ShortestSubarraywithSumatLeastK {

    public int shortestSubarray(int[] nums, int k) {

        //return brutalForce(nums , k);
        return queue(nums , k);
    }

    public int queue(int[] nums, int k){
        int ans = Integer.MAX_VALUE ;

        // get prefix
        long[] sum = new long[nums.length+1];

        for(int index = 0 ; index < nums.length ; index++){
            sum[index+1] = nums[index] + sum[index];
        }

        Deque<Integer>  queue = new LinkedList<>();

        for(int index = 0 ; index < sum.length ; index++){

            while(!queue.isEmpty() && sum[index] - sum[queue.peekFirst()] >= k){
                ans = Math.min(ans , index - queue.peekFirst() );
                queue.pollFirst();
            }
            while(!queue.isEmpty() && sum[queue.peekLast()] > sum[index]){
                queue.pollLast();
            }
            queue.offerLast(index);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans ;

    }

    public int brutalForce(int[] nums, int k){
        int ans = Integer.MAX_VALUE;

        for(int outterIndex = 0 ; outterIndex < nums.length; outterIndex++){
            int total = 0 ;

            for(int innerIndex = outterIndex ; innerIndex < nums.length ; innerIndex ++){
                total += nums[innerIndex];
                if(total >= k){
                    if((innerIndex - outterIndex+1) < ans ){
                        ans =  innerIndex - outterIndex+1;
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }

    public static void main(String[] args){
        int[] nums = null;

        ShortestSubarraywithSumatLeastK shortestSubarraywithSumatLeastK = new ShortestSubarraywithSumatLeastK();

        nums = new int[] {1};
       System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 1));

        nums = new int[] {84,-37,32,40,95};
        System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 167));

        nums = new int[] {-28,81,-20,28,-29};
        System.out.println(shortestSubarraywithSumatLeastK.shortestSubarray(nums , 89));
    }
}
