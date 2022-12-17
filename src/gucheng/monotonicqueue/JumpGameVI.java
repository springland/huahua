package gucheng.monotonicqueue;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/jump-game-vi/
public class JumpGameVI {
    public int maxResult(int[] nums, int k) {

        return queue(nums , k);
    }

    public int queue(int[] nums , int k){

        Deque<Integer> queue = new LinkedList<>();

        int[] sum = new int[nums.length];
        sum[0] = nums[0] ;

        queue.offerLast(0);
        for(int index = 1 ; index < nums.length ; index++){
            while(!queue.isEmpty() && index - queue.peekFirst() > k) queue.pollFirst();
            sum[index] = nums[index] + sum[queue.peekFirst()] ;
            while(!queue.isEmpty() && sum[queue.peekLast()] < sum[index])queue.pollLast();
            queue.offerLast(index);
        }

        return sum[nums.length-1];

    }

    public static void main(String args[]){
        JumpGameVI jumpgame = new JumpGameVI();
        int nums[] ;

        nums = new int[] {1,-1,-2,4,-7,3};
        System.out.println(jumpgame.maxResult(nums , 2));

        nums = new int[] {10,-5,-2,4,0,3};
        System.out.println(jumpgame.maxResult(nums , 3));

        nums = new int[] {1,-5,-20,4,-1,3,-6,-3};
        System.out.println(jumpgame.maxResult(nums , 2));

    }
}
