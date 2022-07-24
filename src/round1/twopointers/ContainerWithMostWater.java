package round1.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int i = 0 ; int j = height.length-1;
        int max = 0;
        while(i <= j){
            int size = (j-i)*Math.min(height[i] , height[j]);
            if(size > max){
                max = size ;
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max ;
    }
}
