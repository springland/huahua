package gucheng.algorithms.twopointers;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        //return minMeetingRoomsPQ(intervals);
        return minMeetingRoomsSweepLine(intervals);
    }

    public int minMeetingRoomsSweepLine(int[][] intervals){
        int ans = 0;

        int[][] weights = new int[intervals.length*2][2];

        for(int index = 0 ; index < intervals.length ; index++){
            weights[2*index][0] = intervals[index][0];
            weights[2*index][1] = 1;
            weights[2*index+1][0] = intervals[index][1];
            weights[2*index+1][1] = -1;
        }

        Arrays.sort(weights , (a , b) -> a[0] == b[0] ?  a[1] - b[1] : a[0] - b[0]);

        int sum = 0 ;
        for(int index = 0 ; index < weights.length ; index++){
            sum += weights[index][1];
            ans = Math.max(ans , sum);
        }
        return ans ;

    }
    public int minMeetingRoomsPQ(int[][] intervals)
    {
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);

        PriorityQueue<Integer>  pq = new PriorityQueue<>();

        for(int index = 0 ; index < intervals.length ; index++){
            int[] interval = intervals[index];
            if(!pq.isEmpty() && pq.peek() <= interval[0]){
                pq.poll();
            }
            pq.offer(interval[1]);
        }

        return pq.size();
    }

    public static void main(String[] args){

        int[][] intervals  ;

        intervals = new int[][] {{2,15}, {36,45}, {9,29}, {16,23}, {4,9}};
        MeetingRoomsII  meetingRoomsII = new MeetingRoomsII() ;
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }
}
