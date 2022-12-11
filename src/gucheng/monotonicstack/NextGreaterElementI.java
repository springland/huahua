package gucheng.monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/submissions/856376363/
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer , Integer>  nextGreaterElementMap = new HashMap<>();

        Stack<Integer>  stack = new Stack<>();
        for(int index = nums2.length-1 ; index >= 0 ; index --){
            while(!stack.isEmpty() && stack.peek() < nums2[index]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreaterElementMap.put(nums2[index] , -1);
            }
            else{
                nextGreaterElementMap.put(nums2[index] , stack.peek());
            }
            stack.push(nums2[index]);
        }

        int[] result = new int[nums1.length];
        for(int index = 0 ;  index < nums1.length ; index++){

            result[index] = nextGreaterElementMap.get(nums1[index]);
        }

        return result ;

    }


}
