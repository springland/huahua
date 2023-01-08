package gucheng.algorithms.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {


        return queue(nums , k);
       // return pq(nums , k);
    }

    public int[] queue(int[] nums, int k){

        Deque<Integer>  queue = new ArrayDeque<>();
        int ans[] = new int[nums.length-k+1];

        for(int index = 0 ; index < k-1 ; index++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[index]) queue.pollLast();
            queue.offerLast(index);
        }

        for(int index = k-1 ; index < nums.length ; index++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[index])queue.pollLast();
            queue.offerLast(index);

            while( queue.peekFirst() < index -k+1) queue.pollFirst() ;
            ans[index-k+1] = nums[queue.peekFirst()];
        }

        return ans ;
    }
    public int[] pq(int[] nums, int k){
        // timed out
        int[] ans =  new int[nums.length-k+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(( a , b) -> b -a);

        for(int index = 0 ; index < k ; index++){
            pq.offer(nums[index]);
        }
        for(int index = k ; index < nums.length   ; index++){
            ans[index-k] = pq.peek() ;
            if(nums[index-k] == pq.peek()){
                pq.poll();
            }else{
                pq.remove(nums[index-k]);
            }
            pq.offer(nums[index]);

        }
        ans[nums.length-k] = pq.poll();
        return ans ;

    }

    public static void main(String args[]){
            int[] nums ;
            nums = new int[]{9,10,9,-7,-4,-8,2,-6};
            SlidingWindowMaximum  slidingWindowMaximum = new SlidingWindowMaximum();
         //   slidingWindowMaximum.maxSlidingWindow(nums ,5);
            slidingWindowMaximum.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7} , 3);
    }
}
