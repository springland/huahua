package gucheng.sweepline;

import java.util.Arrays;

// https://leetcode.com/problems/remove-covered-intervals/
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        int count = 0;
        Arrays.sort(intervals , ( a , b) -> a[0] - b[0] == 0 ? b[1]- a[1] : a[0]- b[0]);

        if(intervals.length == 0){
            return 0;
        }

        int[] cur = intervals[0];

        for(int index = 1 ; index < intervals.length ; index++){

            int[] interval = intervals[index];
            if(interval[1] <= cur[1])
            {
                count ++ ;
            }
            else{
                cur = interval ;
            }
        }


        return intervals.length -count ;
    }

    public static void main(String args[]){

        int[][] intervals = new int[][] {{1 , 2} , {1 , 4} , {3 , 4}};
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(intervals));
    }
}
