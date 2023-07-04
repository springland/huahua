package guchenground2.algorithms.sweepline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List ;
import java.util.stream.Collectors;

public class NumberOfAirplanesInTheSky {

    public static class Interval {
       int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here


        List<Integer> takingOffTime = airplanes.stream().map( a -> a.start).sorted(Integer::compare).collect(Collectors.toList());
        List<Integer>  landingTime = airplanes.stream().map( a -> a.end).sorted(Integer::compare).collect(Collectors.toList());


        int takingOffIndex = 0;
        int landingIndex = 0;
        int count = 0 ;
        int maxCount = 0;
        while(takingOffIndex < takingOffTime.size() && landingIndex < landingTime.size()){
            if(takingOffTime.get(takingOffIndex) < landingTime.get(landingIndex)){
                takingOffIndex++;
                count ++;
                maxCount = maxCount< count? count: maxCount ;
            }
            else if (takingOffTime.get(takingOffIndex) == landingTime.get(landingIndex) ){
                takingOffIndex++;
                landingIndex++;
            }
            else{
                count --;
                landingIndex++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args){

        List<Interval> airplanes = List.of(
                new Interval(1 , 10),
                new Interval( 2, 3),
                new Interval(5 , 8),
                new Interval(4 , 7)

        );
        NumberOfAirplanesInTheSky  numberOfAirplanesInTheSky = new NumberOfAirplanesInTheSky();
        System.out.println(numberOfAirplanesInTheSky.countOfAirplanes(airplanes));
    }
}
