package round1.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {


        List<int[]> ans ;


        ans = intervalIntersection(firstList , 0 , secondList , 0);


        return ans.toArray(new int[ans.size()][2]);
    }


    public List<int[]> intervalIntersection(int[][] firstList, int firstIndex, int[][] secondList, int secondIndex){

        List<int[]> ans = new ArrayList<>();
        if(firstIndex == firstList.length || secondIndex == secondList.length){
            return ans;
        }



        while(firstIndex < firstList.length && secondIndex < secondList.length){
            int[] first = firstList[firstIndex];
            int[] second = secondList[secondIndex];

            if(first[0] > second[0]){
                ans.addAll(
                        intervalIntersection(secondList , secondIndex , firstList , firstIndex)
                );

                return ans ;
            }
            if(first[1] < second[0]){
                firstIndex ++ ;
            }else if ( first[1] > second[1] ){
                ans.add(second);
                secondIndex ++;
            }else {

                int[] temp = new int[2];
                temp[0] = second[0];
                temp[1] = first[1];
                ans.add(temp);
                firstIndex++;
            }
        }

        return ans;
    }

    public static void main(String args[]){
        int[][] firstList = null;
        int[][] secondList = null;

        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}};
        secondList = new int[][] {{1,5},{8,12},{15,24},{25,26}};
        int[][] ans = intervalListIntersections.intervalIntersection(firstList , secondList);
        Stream.of(ans).forEach( t-> System.out.println( t[0] + "  " + t[1]));

        System.out.println("Break");
        firstList = new int[][] {{1, 3}, {5 , 9}} ;
        secondList = new int[][]{};
        ans = intervalListIntersections.intervalIntersection(firstList , secondList);
        Stream.of(ans).forEach( t-> System.out.println( t[0] + "  " + t[1]));



    }
}
