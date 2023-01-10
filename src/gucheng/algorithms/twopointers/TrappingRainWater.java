package gucheng.algorithms.twopointers;

import java.util.Stack;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height){


        return solution2(height);

    }

    public int solution1(int[] height)
    {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0 ;
        for(int index = 0 ; index < height.length ; index++){
            max = Math.max(max , height[index]);
            left[index] = max ;
        }

        max = 0 ;
        for(int index = height.length-1 ; index >= 0 ; index--){
            max = Math.max(max , height[index]);
            right[index] = max ;
        }

        int ans = 0 ;
        for(int index = 0 ;index < height.length ; index++){
            ans += Math.min(left[index] , right[index]) - height[index];
        }
        return ans ;
    }

    public int solution2(int[] height){

        int ans = 0;

        Stack<Integer>  stack = new Stack<>();
        for(int index = 0 ; index < height.length ; index++){
            while(!stack.isEmpty() && height[index] > height[stack.peek()]){
                int pre = stack.pop();
                if(stack.isEmpty()) break;
                int minHeight = Math.min(height[index] , height[stack.peek()]);
                ans += ( minHeight - height[pre]) * ( index - stack.peek()-1);
            }
            stack.push(index);

        }
        return ans ;
    }

    public static void main(String args[]){

        int heights[] ;

        heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1} ;

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(heights));

        heights = new int [] {4,2,0,3,2,5};
        System.out.println(trappingRainWater.trap(heights));

    }
}
