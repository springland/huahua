package leetcodedaily;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int index = temperatures.length-1 ; index >= 0 ; index --){

            while(!stack.isEmpty() && temperatures[index] >= temperatures[stack.peek()]){
                stack.pop();
            }

            answer[index] = stack.isEmpty() ?  0 : stack.peek() - index ;
            stack.push(index);
        }
        return answer ;
    }
}
