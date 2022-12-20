package gucheng.algorithms.monotonicstack;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {


        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for(int index = temperatures.length -1 ; index >= 0 ; index--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[index]){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[index] = 0;
            }
            else{
                answer[index] = stack.peek() - index;
            }
            stack.push(index);
        }


        return answer ;

    }
}
