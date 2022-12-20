package gucheng.algorithms.monotonicstack;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];



        Stack<Integer> stack = new Stack<>();

        for(int index = nums.length-1  ; index >= 0 ; index --)
        {
            while(!stack.isEmpty() && stack.peek() <= nums[index]){
                stack.pop();
            }
            stack.push(nums[index]);
        }

        for(int index = nums.length-1 ; index >= 0 ; index--){
            while(!stack.isEmpty() && stack.peek() <= nums[index]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[index] = -1;
            }
            else {
                result[index] = stack.peek();
            }
            stack.push(nums[index]);
        }

        return result ;


    }

    public static void main(String args[]){
        int[] nums = new int[] {1,2,1};

        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] answer = nextGreaterElementII.nextGreaterElements(nums);
        System.out.println(IntStream.of(answer).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        nums = new int[] {1,2,3,4,3};
        answer = nextGreaterElementII.nextGreaterElements(nums);
        System.out.println(IntStream.of(answer).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }



}
