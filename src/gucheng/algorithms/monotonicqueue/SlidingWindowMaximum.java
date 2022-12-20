package gucheng.algorithms.monotonicqueue;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {


        //return brutalForce(nums , k);
        //return heap( nums , k);
        //return monotonicqueue(nums , k);

        return monotonicqueue2(nums , k);
    }

    public int[]  monotonicqueue2(int nums[] , int k){

        Deque<Integer>  queue = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for(int index = 0 ; index < nums.length ; index++){
            while(!queue.isEmpty() &&  index - queue.peekFirst() +1> k ) queue.pollFirst() ;  // make the window size k -1 ;
            while(!queue.isEmpty() && nums[index] > nums[queue.peekLast()]) queue.pollLast() ; //  keep the queue decreasing
            queue.offerLast(index);
            ans[index] = nums[queue.peekFirst()];
        }
        return Arrays.copyOfRange(ans , k-1 , nums.length);
    }
    public int[] brutalForce(int nums[] , int k)
    {
        int[] res = new int[nums.length -k+1];

        for(int index = 0 ; index < nums.length - k+1 ; index++){
            int max = nums[index];

            for(int windowIndex = 0 ; windowIndex < k ; windowIndex ++){
                if(nums[index + windowIndex] > max) max = nums[index + windowIndex];
            }
            res[index]= max ;
        }

        return  res ;
    }

    public int[] heap(int nums[] , int k){

        int[] res = new int[nums.length -k+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>( (a , b) -> b-a );
        for(int index = 0 ; index < k-1 ; index++){
            pq.offer(nums[index]);
        }

        for(int index = k-1 ; index < nums.length ; index++){

            pq.offer(nums[index]);

            res[index-k+1] = pq.peek();
            if(pq.peek() == nums[index -k+1]){
                pq.poll();
            }
            else{
                // o(n) operation
                pq.remove(nums[index-k+1]);
            }
        }

        return  res ;
    }

    public int[] monotonicqueue(int nums[] , int k) {
        int[] res = new int[nums.length -k+1];
        Deque<Integer>  queue = new ArrayDeque<>() ;

        // put in the index  , make a decreasing queue

        for(int index = 0 ; index < k-1 ; index++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[index]){
                queue.pollLast();
            }
            queue.offerLast(index);
        }

        for(int index = k-1 ; index < nums.length ; index++){
            while(!queue.isEmpty() && index - queue.peekFirst() +1 > k) queue.pollFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[index]) queue.pollLast();
            queue.offerLast(index);
            res[index -k +1] = nums[queue.peekFirst()];


        }
        return res ;

    }
    public static void main(String args[]){

        int[] nums ;

        nums = new int[] {1,3,-1,-3,5,3,6,7};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(IntStream.of(slidingWindowMaximum.maxSlidingWindow(nums , 3)).mapToObj(String::valueOf).collect(Collectors.toList()));

        nums = new int[]{1};
     //   System.out.println(IntStream.of(slidingWindowMaximum.maxSlidingWindow(nums , 1)).mapToObj(String::valueOf).collect(Collectors.toList()));

    }
}
