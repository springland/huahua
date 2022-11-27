package gucheng.bfs;

import java.util.*;
import java.util.stream.IntStream;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {



        int[]  dependencyCounts = new int[numCourses];

        Map<Integer , List<Integer>>  depdencyMap = new HashMap<>();
        for(int index = 0 ; index < prerequisites.length ; index ++){
            dependencyCounts[prerequisites[index][0]]++ ;
            depdencyMap.computeIfAbsent( prerequisites[index][1] , x -> new ArrayList<>()).add(prerequisites[index][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int countsId = 0 ; countsId < numCourses ; countsId++){
            if(dependencyCounts[countsId] == 0){
                queue.add(countsId);
            }
        }

        while(!queue.isEmpty()){
            int courseId = queue.poll();

            List<Integer> dependencies = depdencyMap.getOrDefault(courseId , Collections.emptyList());
            for(int index = 0 ; index < dependencies.size() ; index++){
                int dependencyCourseId = dependencies.get(index);
                dependencyCounts[dependencyCourseId]--;
                if(dependencyCounts[dependencyCourseId] == 0){
                    queue.add(dependencyCourseId);
                }
            }
        }

        for(int index = 0 ; index < numCourses ; index++){
            if(dependencyCounts[index] > 0){
                return false ;
            }
        }
        return true ;
    }


    public static void main(String[] args){

        CourseSchedule  schedule  = new CourseSchedule();

        int[][] prerequisites = new int[][] {{1 , 0}};
        System.out.print(schedule.canFinish( 2 , prerequisites));

    }

}
