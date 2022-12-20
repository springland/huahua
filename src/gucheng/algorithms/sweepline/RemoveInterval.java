package gucheng.algorithms.sweepline;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-interval/
public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>>  result = new ArrayList<>();

        for(int index = 0 ; index < intervals.length ; index++){

            int[] interval = intervals[index];
            if(interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1] ){

                result.add(List.of(interval[0] , interval[1]));
            }
            else if ( toBeRemoved[0] <= interval[0] && toBeRemoved[1] >= interval[0] && interval[1] > toBeRemoved[1] )
            {
                result.add(List.of(toBeRemoved[1] , interval[1]));
            }
            else if ( interval[0] < toBeRemoved[0] && interval[1] >= toBeRemoved[0] && interval[1] <= toBeRemoved[1] ){
                result.add(List.of(interval[0] , toBeRemoved[0]));
            }
            else if ( interval[0] < toBeRemoved[0] && interval[1] > toBeRemoved[1]){
                result.add(List.of(interval[0] , toBeRemoved[0]));
                result.add(List.of(toBeRemoved[1] , interval[1] ));
            }


        }
        return result ;
    }
}
