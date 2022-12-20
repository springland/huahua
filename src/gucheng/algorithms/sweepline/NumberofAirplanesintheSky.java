package gucheng.algorithms.sweepline;

import java.util.List;
import java.util.stream.Collectors;

// https://www.lintcode.com/problem/391/
public class NumberofAirplanesintheSky {



    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here

        int max = 0 ;
        int count = 0;
        List<Interval> intervals = airplanes.stream()
                .flatMap( a -> List.of( new Interval(a.start , 1) , new Interval(a.end , -1)).stream())
                .sorted( (a , b) -> a.start - b.start).collect(Collectors.toList());

        for(Interval interval : intervals)
        {
            count += interval.end ;
            if(count > max){
                max = count ;
            }
        }
        return max ;
    }


    public static void main(String[] args){
        List<Interval>  airplanes ;

        airplanes = List.of ( new Interval(1, 10), new Interval (2, 3), new Interval(5, 8), new Interval(4, 7));

        NumberofAirplanesintheSky countOfAirplanes  = new NumberofAirplanesintheSky();
        System.out.println(countOfAirplanes.countOfAirplanes(airplanes));

        airplanes = List.of ( new Interval(1, 2), new Interval (2, 3), new Interval(3, 4));
        System.out.println(countOfAirplanes.countOfAirplanes(airplanes));
    }
}



  class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }