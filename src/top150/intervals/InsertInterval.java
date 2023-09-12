package top150.intervals;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort( intervals , (a , b) -> a[0] - b[0] );

        ArrayList<int[]> merged = new ArrayList<>();

        if(intervals == null || intervals.length == 0){
            return new int[][] {newInterval} ;
        }

        boolean inserted = false ;
        for(int index = 0 ; index < intervals.length ; index++){

            if(!inserted ){

                if(intervals[index][0] <= newInterval[0] && intervals[index][1] >= newInterval[0] || newInterval[0] <= intervals[index][0] && newInterval[1] >= intervals[index][0]){
                    newInterval[0] = Math.min(newInterval[0] , intervals[index][0]);
                    newInterval[1] = Math.max(newInterval[1] , intervals[index][1]);

                    merged.add(newInterval);
                    inserted = true ;
                }
                else{
                    if(newInterval[1] < intervals[index][0]){

                        merged.add(newInterval);
                        inserted = true ;
                    }
                    merged.add(intervals[index]);
                }
            }
            else {

                if(intervals[index][0] >= newInterval[0] && intervals[index][0] <=  newInterval[1] || intervals[index][0] <= newInterval[0] &&  intervals[index][1] >= newInterval[0]){

                    newInterval[0] = Math.min(newInterval[0] , intervals[index][0]);
                    newInterval[1] = Math.max(newInterval[1] , intervals[index][1]);
                }
                else{
                    merged.add(intervals[index]);
                }
            }
        }

        if(!inserted){
                merged.add(newInterval);
        }

        return merged.toArray(new int[0][0]);
    }

    public static void main(String[] args){

    }
}
