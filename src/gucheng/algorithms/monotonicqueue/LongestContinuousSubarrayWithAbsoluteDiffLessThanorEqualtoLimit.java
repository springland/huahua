package gucheng.algorithms.monotonicqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    public int longestSubarray(int[] nums, int limit) {

        return pq(nums , limit);
      //  return queue(nums  , limit);
    }


    public int pq(final int[] nums , int limit)
    {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>( ( a, b) -> nums[a] -nums[b]) ;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>( ( a, b) -> nums[b] - nums[a]) ;

        int ans = 0 ;
        int left = 0 ;
        for(int index = 0 ; index < nums.length ; index ++){
            minQueue.offer(index);
            maxQueue.offer(index);

            while(nums[maxQueue.peek()] - nums[minQueue.peek()] > limit){

                while(left  >= minQueue.peek()){
                    minQueue.poll();
                }
                while(left >= maxQueue.peek()){
                    maxQueue.poll();
                }
                left ++ ;
            }
            ans = Math.max( ans , index - left+1);
        }

        return ans ;
    }
    public int queue(int[] nums, int limit)
    {

        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        int left = 0 ;
        int ans = 0;
        for(int index = 0 ; index < nums.length ; index++){
            while(!minQueue.isEmpty() && nums[index] < minQueue.peekLast()) minQueue.pollLast();
            while(!maxQueue.isEmpty() && nums[index] > maxQueue.peekLast()) maxQueue.pollLast();

            minQueue.offerLast(nums[index]);
            maxQueue.offerLast(nums[index]);

            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if(maxQueue.peekFirst() == nums[left]) maxQueue.pollFirst();
                if(minQueue.peekFirst() == nums[left]) minQueue.pollFirst();
                left ++ ;
            }

            ans = Math.max(ans , index - left+1);
            if(index - left+1 == 19){
                System.out.println(left);
                System.out.println(index);

            }
        }


        return ans ;
    }

    public static void main(String args[]){
        int nums[] ;

        LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit limit = new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();

        nums = new int[] {10,1,2,4,7,2};
        //System.out.println(limit.longestSubarray(nums , 5));

        nums = new int[] {4,2,2,2,4,4,2,2};
       // System.out.println(limit.longestSubarray(nums , 0));

        nums = new int[] {24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39};
        //System.out.println(limit.longestSubarray(nums , 87));

        nums = new int[] {71,45,88,69,63,99,69,31,9,93,6,11,18,22,22,69,28,35,98,43,77,65,33,48,44,44,15,38,31,78,100,92,63,18,75,71,99,14,42,6,53,10,49,19,17,44,15,79,76,49,10,74,71,29,73,11};
        System.out.println(limit.longestSubarray(nums , 74));
    }
}
