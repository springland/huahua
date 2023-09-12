package top150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<int[]>  merged = new ArrayList<>();
        if(intervals == null || intervals.length == 0){
            return merged.toArray(new int[0][0]) ;
        }

        Arrays.sort( intervals , ( a , b) -> a[0] - b[0]);

        int[]  cur = intervals[0];

        for(int index = 1  ; index < intervals.length ; index++){
            if(intervals[index][0] >= cur[0] && intervals[index][0] <= cur[1]){
                cur[1] = Math.max(cur[1] , intervals[index][1]);
            }
            else{
                merged.add(cur);
                cur = intervals[index];
            }
        }

        merged.add(cur);
        return merged.toArray(new int[0][0]);


    }
}
