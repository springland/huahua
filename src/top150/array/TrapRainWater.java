package top150.array;

// https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
public class TrapRainWater {

    public int trap(int[] height){


        return solution1(height);

    }

    public int solution1(int[] height)
    {

        int[] left2right = new int[height.length];
        int[] right2left = new int[height.length];

        int max = Integer.MIN_VALUE;
        for(int index = 0 ; index < height.length ; index++){

            max = max < height[index]? height[index]:max ;
            left2right[index] = max ;
        }

        max = Integer.MIN_VALUE;
        for(int index = height.length-1 ; index >= 0 ; index--){
            max = max < height[index]? height[index]:max ;
            right2left[index] = max ;

        }

        int volume = 0 ;
        for(int index = 0 ; index < height.length ; index++){
            int top = Integer.min(left2right[index] , right2left[index]);
            volume += top - height[index];
        }
        return volume ;
    }
}
