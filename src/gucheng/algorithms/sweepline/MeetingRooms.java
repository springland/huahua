package gucheng.algorithms.sweepline;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms/
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals == null || intervals.length == 0 ||  intervals.length == 1)
        {
            return true ;
        }


        Arrays.sort( intervals , ( a , b) -> a[0] - b[0]);

        int[] prev = intervals[0];
        for(int index = 1 ; index < intervals.length ; index++){
            int[] cur = intervals[index];
            if(prev[1] > cur[0]){
                return false ;
            }
            prev = cur ;
        }

        return true ;
    }
}
