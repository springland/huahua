package gucheng.sweepline;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/meeting-scheduler/
public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        int index1 = 0 ;
        int index2 = 0 ;

        Arrays.sort(slots1 , ( a, b) -> a[0] - b[0]);
        Arrays.sort(slots2 , ( a, b) -> a[0] - b[0]);

        List<Integer> meeting = Collections.EMPTY_LIST;

        while(index1 < slots1.length && index2 < slots2.length)
        {

            int[] intersect = intersect(slots1[index1] , slots2[index2]);
            if(intersect == null)
            {
                if(slots1[index1][0] < slots2[index2][0])
                {
                    index1++;
                }
                else{
                    index2++;
                }
            }
            else{
                if(intersect[1] - intersect[0] >= duration){
                    meeting = List.of(intersect[0] , intersect[0] + duration);
                    break;

                }
                else{
                    if(slots1[index1][1] < slots2[index2][1]){
                        index1++;
                    }
                    else{
                        index2++;
                    }
                }
            }

        }

        return meeting;

    }

    public int[]  intersect(int[]  slot1 , int[] slot2)
    {
        int[] intersect = null;
        if((slot1[1] >= slot2[0] && slot1[1] <= slot2[1]) || ((slot2[1] >= slot1[0] && slot2[1] <= slot1[1])))
        {
            int start = Math.max(slot1[0] , slot2[0]);
            int end = Math.min(slot1[1] , slot2[1]);

            intersect = new int[]{start ,end};

        }

        return intersect;

    }

    public static void main(String args[]){
        MeetingScheduler scheduler = new MeetingScheduler() ;
        int[][] slots1 = new int[][] {{10 , 50} , {60  , 120} , {140 , 210}};
        int[][] slots2 = new int[][] {{0 , 15} , {60  , 70} };

        List<Integer> schedule = scheduler.minAvailableDuration(slots1 ,slots2 , 8);
        System.out.println(schedule);
    }
}
