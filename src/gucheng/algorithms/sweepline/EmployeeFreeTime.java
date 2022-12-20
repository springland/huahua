package gucheng.algorithms.sweepline;



import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/employee-free-time/
public class EmployeeFreeTime {


    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        public String toString()
        {
            return "(" + start + ", " + end + ")";
        }
    };


    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {

        PriorityQueue<Interval> pq = new PriorityQueue<>((a , b) -> a.start - b.start);

        for(List<Interval> schedule: schedules){
            for(Interval interval : schedule){
                pq.add(interval);
            }
        }

        List<Interval>  result = new ArrayList<>();
        Interval cur = pq.poll();
        while(!pq.isEmpty()){
            if(cur.end >= pq.peek().start){
                cur.end = Math.max(cur.end , pq.poll().end);
            }
            else{
                result.add( new Interval(cur.end , pq.peek().start ));
                cur = pq.poll();
            }
        }

        return result ;

    }


    public static void main(String args[]){

        List<List<Interval>> schedules = List.of(
                List.of(new Interval(1 , 2) , new Interval(5 , 6)),
                List.of(new Interval(1 , 3 ), new Interval(4 , 10))
        );

        EmployeeFreeTime  employeeFreeTime = new EmployeeFreeTime();
        List<Interval> freeTimes = null;

 //       freeTimes = employeeFreeTime.employeeFreeTime(schedules);
 //       System.out.println(freeTimes);

        schedules = List.of(

                List.of( new Interval(1 , 3) ,
                         new Interval(6 , 7)

                ) ,
                List.of( new Interval( 2 , 4)),

                List.of( new Interval(2 , 5) , new Interval(9 , 12))

        );
        freeTimes = employeeFreeTime.employeeFreeTime(schedules);
        System.out.println(freeTimes);

    }
}
