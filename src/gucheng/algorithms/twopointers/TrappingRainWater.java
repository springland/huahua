package gucheng.algorithms.twopointers;

import java.util.Stack;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height){


        return trapSolution1(height);

    }


    public int trapSolution1(int[] height){

        int ans = 0;


        Stack<Integer>  stack = new Stack<>();

        stack.push(height[0]);

        for(int index = 1 ; index < height.length ; index++){
            if(height[index] > height[index-1]){

                if(!stack.isEmpty()){
                    int bottom = stack.pop() ;
                    if(stack.isEmpty()) continue;


                }
            }
            else{
                stack.push(index);
            }

        }
        return ans ;

    }
}
