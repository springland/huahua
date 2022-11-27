package gucheng.bfs;

import java.util.*;
import java.util.stream.IntStream;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[]  schedule = new int[numCourses];

        int[]  dependencyCount = new int[numCourses];
        Map<Integer , List<Integer>>  depdencyMap = new HashMap<>();


        for(int index = 0 ; index < prerequisites.length ; index++){

            dependencyCount[prerequisites[index][0]] ++;
            depdencyMap.computeIfAbsent(prerequisites[index][1] , x-> new ArrayList<>()).add(prerequisites[index][0]);
        }

        int count = 0 ;
        Queue<Integer> queue = new LinkedList() ;
        for(int index = 0 ; index < numCourses ; index++){
            if(dependencyCount[index] == 0){
                queue.offer(index);
            }
        }


        while(!queue.isEmpty()){
            int courseId = queue.poll() ;
            schedule[count++] = courseId ;

            List<Integer> dependencies = depdencyMap.getOrDefault(courseId , Collections.emptyList());
            for(int index = 0 ; index < dependencies.size() ; index++){
                int dependencyCourseId = dependencies.get(index);
                dependencyCount[dependencyCourseId] -- ;
                if(dependencyCount[dependencyCourseId] == 0){
                    queue.offer(dependencyCourseId);
                }
            }
        }

        return count == numCourses? schedule : new int[0];

    }

    public static void main(String args[]){
        CourseScheduleII scheduleII = new CourseScheduleII();
        scheduleII.findOrder(2 , new int[0][2]);
    }
}
