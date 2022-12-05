package gucheng.dfs;

import java.util.Arrays;

// https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
public class FindMinimumTimetoFinishAllJobs {

    protected  int miniumTime = Integer.MAX_VALUE ;
    public int minimumTimeRequired(int[] jobs, int k) {

        Arrays.sort(jobs);
        for(int index = 0 ; index < jobs.length/2  ; index++){
            int temp = jobs[jobs.length-1 - index];
            jobs[jobs.length-1 - index] = jobs[index];
            jobs[index] = temp ;
        }
        int[] workers = new int[k];
        minimumTimeRequired(jobs , workers , 0);

        return miniumTime;
    }

    public void minimumTimeRequired(int[] jobs , int workers[] , int jobIndex ){

        if(jobIndex == jobs.length){
            int maxWorkerTime = 0 ;
            for(int wokerIndex = 0 ; wokerIndex < workers.length ;wokerIndex++){
                if(maxWorkerTime < workers[wokerIndex]){
                    maxWorkerTime = workers[wokerIndex];
                }
            }
            if(maxWorkerTime < miniumTime){
                miniumTime = maxWorkerTime ;
            }
            return ;
        }

        for(int workerIndex = 0 ; workerIndex< workers.length ; workerIndex++){
            if(workers[workerIndex] + jobs[jobIndex] > miniumTime) continue ;
            if(workerIndex != 0 && workers[workerIndex] == workers[workerIndex-1]) continue ;

            workers[workerIndex] += jobs[jobIndex];
            minimumTimeRequired(jobs , workers , jobIndex+1);
            workers[workerIndex] -= jobs[jobIndex];
        }
    }

}
