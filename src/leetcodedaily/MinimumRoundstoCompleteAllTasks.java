package leetcodedaily;


// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

import java.util.Arrays;

public class MinimumRoundstoCompleteAllTasks {
    public int minimumRounds(int[] tasks) {

        Arrays.sort(tasks);

        int[] minRounds = new int[tasks.length];

        if(tasks.length < 2){
            return -1 ;
        }

        minRounds[0] = 1 ;
        minRounds[1] = 1;

        for(int index = 2 ; index < minRounds.length ; index++){


            minRounds[index] = Math.min(1 , 1);
        }

        return minRounds[tasks.length-1];
    }

}
