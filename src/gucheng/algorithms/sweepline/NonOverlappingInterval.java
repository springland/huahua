package gucheng.algorithms.sweepline;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingInterval {

    public static void main(String args[]){

        int[][] intervals = new int[][] {{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}};
        NonOverlappingInterval nonOverlappingInterval = new NonOverlappingInterval() ;
        System.out.println(nonOverlappingInterval.eraseOverlapIntervals(intervals));


    }
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 0){
            return 0 ;
        }
        Arrays.sort( intervals , (a , b) -> a[0] - b[0]);

        for(int index = 0 ; index < intervals.length ; index++){
            System.out.print("(" + intervals[index][0] + "," + intervals[index][1] + ")" );
        }
        System.out.println("");
        int[] cur = intervals[0];
        int count = 0 ;
        for(int index = 1; index < intervals.length ; index++ )
        {
            if(isOverlap(cur , intervals[index]))
            {
                //if(cur[1] - cur[0] > intervals[index][1] - intervals[index][0]){
                if(cur[1]  > intervals[index][1] ){
                    cur = intervals[index];
                    System.out.println( " " + cur[0] + "  " + cur[1]);
                }
                else{
                    System.out.println( " " + intervals[index][0] + "  " + intervals[index][1]);
                }
                count++ ;
            }
            else{
                cur = intervals[index];
            }
        }

        return count ;
    }

    protected boolean isOverlap(int[] interval1 , int[] interval2){

        // Per [[1,2],[2,3],[3,4],[1,3]] ,[1 ,2 ] , [2 , 3] are not overlap
        // [1 , 2] ,[1 , 2] are overlap
        if(interval1[0] > interval2[0]){
            swap(interval1 , interval2);
        }

        return interval1[1] > interval2[0];
    }

    protected void swap(int[] interval1 , int[] interval2){
        int[] temp = new int[interval1.length];
        for(int index = 0 ; index < temp.length ; index++){
            temp[index] = interval1[index];
        }
        for(int index = 0 ; index < temp.length ; index++){
            interval1[index] = interval2[index];
        }
        for(int index = 0 ; index < temp.length ; index++){
            interval2[index] = temp[index];
        }

    }
}
