package gucheng.algorithms.sweepline;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int index1 = 0 ;
        int index2 = 0;

        List<int[]> intersections = new ArrayList<>();

        while(index1 < firstList.length && index2 < secondList.length) {

            int[] first = firstList[index1];
            int[] second = secondList[index2];


            int[] intersect = intersect( first , second);
            if(intersect != null){
                intersections.add(intersect);
            }
            if(first[1] < second[1]){
                index1++;
            }
            else{
                index2++;
            }



        }

        return intersections.toArray(new int[0][2]);


    }

    public int[] intersect(int[] first , int[] second){

        int[] intersect = null;
        if(first[0] <= second[0] && first[1] >= second[0])
        {

            int start = second[0];
            int end = Math.min(first[1] , second[1]);

            intersect = new int[]{ start , end};

        }else if ( second[0] <= first[0] && second[1] >= first[0]){
            int start = first[0];
            int end = Math.min(first[1] , second[1]);

            intersect = new int[]{ start , end};
        }

        return intersect ;
    }

    public static void main(String args[]){
        int[][] firstList = new int[][] {{0 , 2} , {5 , 10} , {13 , 23}  , {24 , 25}};
        int[][] secondList = new int[][] {{1 , 5} , {8 , 12} , {15 , 24} , {25 , 26}};

        IntervalListIntersections intervalIntersection = new IntervalListIntersections();
        int[][]  intersections =  intervalIntersection.intervalIntersection(firstList , secondList) ;

        for(int index = 0 ; index < intersections.length ; index++){
            System.out.println("[" + intersections[index][0] + ", " + intersections[index][1] + "]");
        }
    }
}
