package top150.twopointers;

// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0 ;

        int left = 0 ;
        int right = height.length-1;

        while(left < right){

            int area = Math.min(height[left] , height[right])* (right - left);
            maxArea = maxArea < area ? area : maxArea;
            if(height[left] < height[right]){
                left ++ ;
            }else if (height[left] > height[right]){
                right --;
            }
            else{
                left ++;
            }
        }
        return maxArea ;
    }
}
