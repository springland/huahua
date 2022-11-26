package gucheng.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/the-skyline-problem/
public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> skylines = new ArrayList<>();



        int[][]  boundries = new int[buildings.length*2][2];
        for(int index = 0 ; index < buildings.length ; index++){
            boundries[2*index][0] = buildings[index][0];
            boundries[2*index][1] = buildings[index][2];
            boundries[2*index+1][0] = buildings[index][1];
            boundries[2*index+1][1] = -buildings[index][2];
        }

        Arrays.sort(boundries , (a , b)-> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);

        int prevTop = 0 ;
        PriorityQueue<Integer> tops = new PriorityQueue<>(( a , b) -> b-a);

        tops.offer(prevTop);
        for(int index = 0 ; index < boundries.length ; index++){


            if(boundries[index][1] > 0){
                tops.offer(boundries[index][1]);
            }
            else{
                tops.remove(-boundries[index][1]);
            }

            int curTop = tops.peek() ;
            if(curTop != prevTop){
                skylines.add( List.of(boundries[index][0] , curTop));
                prevTop = curTop ;
            }
        }

        return skylines ;
    }

    public static void main(String args[]){
        SkylineProblem skyline = new SkylineProblem();
//        int[][] buildings = new int[][] {
//                {2 , 9 , 10} , {3 , 7 , 15} , {5 , 12 , 12} ,  {15,20,10} , {19,24,8}};

        int[][] buildings = new int[][] {
                {0 , 2 ,3} , {2 , 5 , 3}};

        List<List<Integer>> outline = skyline.getSkyline(buildings);
        System.out.println(outline);

    }
}
