package gucheng.algorithms.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/data-stream-as-disjoint-intervals/
public class DataStreamAsDisjointIntervals {

    private List<int[]>  intervals ;

    public DataStreamAsDisjointIntervals() {
        intervals = new ArrayList<>();

    }

    public void addNum(int value) {

        int[] cur = new int[2];
        cur[0] = value ;
        cur[1] = value ;

        if(intervals.isEmpty()){
            intervals.add(cur);
            return ;
        }

        int index = Collections.binarySearch(
                intervals , cur ,  ( a , b) -> a[0] - b[0]
        );

        if(index < 0)
        {
            int insertIndex = -index-1;

            if(insertIndex == 0){
                if(cur[0]+1  == intervals.get(0)[0])
                {
                    intervals.get(0)[0] = cur[0];
                }
                else{
                    intervals.add(0 , cur);
                }
            }
            else if ( insertIndex == intervals.size()){

                int prevIndex = insertIndex-1;
                if(intervals.get(prevIndex)[1] +1 == cur[0] )
                {
                    intervals.get(prevIndex)[1] = cur[0];
                }
                else{
                    if(intervals.get(prevIndex)[1] < cur[0]) {
                        intervals.add(cur);
                    }
                }
            }
            else{
                int prevIndex = insertIndex-1;
                int nextIndex = insertIndex ;

                if(intervals.get(prevIndex)[1] < cur[0]) {

                    if (intervals.get(prevIndex)[1] + 1 == cur[0]) {
                        if (intervals.get(nextIndex)[0] == cur[0] + 1) {
                            intervals.get(prevIndex)[1] = intervals.get(nextIndex)[1];
                            intervals.remove(nextIndex);
                        } else {
                            intervals.get(prevIndex)[1] = cur[0];
                        }

                    } else if (intervals.get(nextIndex)[0] == cur[0] + 1) {
                        intervals.get(nextIndex)[0] = cur[0];
                    } else {
                        intervals.add(insertIndex, cur);
                    }
                }

            }
        }



    }

    public int[][] getIntervals() {

        return intervals.toArray(new int[0][2]);

    }

    public static void main(String args[]){

        DataStreamAsDisjointIntervals  dataStreamAsDisjointIntervals = new DataStreamAsDisjointIntervals();
        dataStreamAsDisjointIntervals.addNum(6);
        dataStreamAsDisjointIntervals.addNum(6);
        dataStreamAsDisjointIntervals.addNum(0);
        dataStreamAsDisjointIntervals.addNum(4);
        dataStreamAsDisjointIntervals.addNum(8);
        dataStreamAsDisjointIntervals.addNum(7);
        dataStreamAsDisjointIntervals.addNum(6);
        dataStreamAsDisjointIntervals.addNum(4);
        dataStreamAsDisjointIntervals.addNum(7);
        dataStreamAsDisjointIntervals.addNum(5);
    }
}
