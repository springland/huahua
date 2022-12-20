package gucheng.algorithms.sweepline;

import java.util.Arrays;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        int[][] weights = new int[intervals.length*2][2];

        for( int index = 0; index < intervals.length; index++){
            weights[2*index][0] = intervals[index][0];
            weights[2*index][1] = 1;
            weights[2*index+1][0] = intervals[index][1];
            weights[2*index+1][1] = -1;
        }

        Arrays.sort(weights , (a , b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int count = 0;
        int max = 0;

        for( int index = 0 ; index < weights.length ; index++){
            count += weights[index][1];
            if(count > max){
                max = count ;
            }

        }

        return max ;
    }
}
