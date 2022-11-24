package gucheng.sweepline;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {


        List<int[]>  res = new ArrayList<>();


        for(int[] interval : intervals) {
            if(newInterval == null || newInterval[0] > interval[1])
            {
                res.add(interval);
            }
            else if ( newInterval[1] < interval[0]){
                res.add(newInterval);
                res.add(interval);
                newInterval = null ;
            }
            else{
                int start = Math.min(interval[0] , newInterval[0]);
                int end = Math.max(interval[1] , newInterval[1]);

                newInterval[0] = start ;
                newInterval[1] = end ;
            }

        }

        if(newInterval != null){
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);

    }

    public static void main(String args[]){

        int[][] intervals = new int[][] {{2 , 5} , {6 , 7} , {8 , 9}};
        int[] newIntervals = new int[] { 0 , 1};
        InsertInterval  insert = new InsertInterval();
        int[][] merged = insert.insert(intervals , newIntervals);
        for(int index = 0 ; index < merged.length ; index++){
            System.out.println(" " + merged[index][0] + "  " + merged[index][1]);
        }
    }
}
