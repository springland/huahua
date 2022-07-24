package round1.twopointers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        if (height == null || height.length == 1) {
            return 0;
        }
        int i = 0;
        int j = 1;

        int total = 0;

        Deque<Integer> peaks = new LinkedList<>();

        peaks.push(0);
        int prevMax = height[0];
        while( j < height.length){

            if(j >= 2 && height[j-1] > height[j-2] && height[j-1] >= height[j] )
            {
                // this is a peak

                // want to remove the peaks between this one and the previous heights
                // for example we have  8 , 6 , 6 , 9 , when 9 is coming the two 6 between 8 and 9 can be removed
                // however we want to avoid if it the heighest peak so far , for example  we have 2  0 3 0 4 0 5 , when 5 is coming
                // 3  and 4 should not be removed


                while(!peaks.isEmpty() && height[peaks.peek()] < prevMax && height[peaks.peek()] < height[j-1]){
                    peaks.pop();
                }
                if(prevMax < height[j-1]){
                    prevMax = height[j-1];
                }
                peaks.push(j-1);
            }
            j++ ;
        }



        j = height.length-1 ;

        if(height[j] > height[j-1]){
            // do last merge
            while(!peaks.isEmpty() && height[peaks.peek()] < prevMax && height[peaks.peek()] < height[j]){
                peaks.pop();
            }
        }
        while(!peaks.isEmpty()){
            i = peaks.pop();
            int minHeight = Math.min(height[i] , height[j]);
            for(int index = i+1 ; index < j ; index++) {
                total += Math.max(0, minHeight - height[index]);
            }
            j = i ;
        }
        return total ;
    }

    public int trap2(int[] height) {
        if (height.length == 0)
            return 0;
        int n = height.length;
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        int res = 0;
        l_max[0] = height[0];
        r_max[n-1] = height[n-1];
        for (int i=1; i<n; i++) {
            l_max[i] = Math.max(l_max[i-1], height[i]);
        }
        for (int i=n-2; i>=0; i--) {
            r_max[i] = Math.max(r_max[i+1], height[i]);
        }
        for (int i=1; i<n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    public static void main(String args[]){
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        height = new int[] {4,2,0,3,2,5};
        height = new int[] {4,9,4,5,3,2};


        height = new int [] {4,3,3,9,3,0,9,2,8,3};
        height = new int[] {9,6,8,8,5,6,3};
        height = new int[]{4,2,0,3,2,4,3,4};
        TrappingRainWater trap = new TrappingRainWater();
        System.out.println(trap.trap(height));
    }



}
