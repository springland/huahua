package gucheng.algorithms.greedy;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsonaTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int ans = 0 ;

        Arrays.sort(boxTypes , (b1 , b2) -> b2[1] - b1[1]);
        for(int index = 0 ; index < boxTypes.length && truckSize > 0; index++){

            if(truckSize >= boxTypes[index][0]){
                ans += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
            }
            else{
                ans += truckSize * boxTypes[index][1];
                truckSize = 0 ;
            }
        }

        return ans ;
    }
}
