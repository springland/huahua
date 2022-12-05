package gucheng.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

public class MinimumNumberofWorkSessionstoFinishtheTasks {


    int minSessions = Integer.MAX_VALUE;
    public int minSessions(int[] tasks, int sessionTime) {




        int[] sessionTimes = new int[tasks.length];

        minSessions(tasks , 0 , sessionTime , sessionTimes , 0);

        return minSessions ;
    }

    public void minSessions( int[] tasks , int taskIndex ,int sessionTime ,  int sessionTimes[] , int sessions){

        if(taskIndex == tasks.length){

            if(sessions < minSessions){
                minSessions = sessions ;
            }

            return ;
        }

        if(sessions > minSessions) return ;

        // try exising sessions
        for(int index = 0 ; index < sessions ; index++){
            if(sessionTimes[index] + tasks[taskIndex] <= sessionTime){
                sessionTimes[index] += tasks[taskIndex];
                minSessions(tasks , taskIndex+1 , sessionTime , sessionTimes , sessions);
                sessionTimes[index] -= tasks[taskIndex];
            }
        }
        // put it in new session
        sessions ++;
        sessionTimes[sessions-1] = tasks[taskIndex];
        minSessions(tasks , taskIndex+1 , sessionTime , sessionTimes , sessions);

    }

    public static void main(String args[]){

        int tasks[] = new int[] {2,3,3,4,4,4,5,6,7,10};

        MinimumNumberofWorkSessionstoFinishtheTasks minSessions = new MinimumNumberofWorkSessionstoFinishtheTasks();

        System.out.println(minSessions.minSessions(tasks , 12));
    }
}
