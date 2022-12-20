package gucheng.datastructure.stackandqueue;

import java.util.*;

// https://leetcode.com/problems/maximum-frequency-stack/
public class MaximumFrequencyStack {

    // This is almost the same as minmal stack
    // but use a different stack for each frequency

    int maxfreq ;

    Map<Integer , Integer>  valueFreqMap = new HashMap<>();
    Map<Integer , Stack<Integer>>  freqStackMap = new HashMap<>();

    public MaximumFrequencyStack() {


    }

    public void push(int value) {

        valueFreqMap.put(value , valueFreqMap.getOrDefault(value , 0)+1);

        int freq =valueFreqMap.get(value) ;

        freqStackMap.computeIfAbsent( freq , x -> new Stack<Integer>()).push(value);
        if(freq > maxfreq){

            maxfreq ++ ;
        }

    }

    public int pop() {

        int value = freqStackMap.get(maxfreq).pop();
        valueFreqMap.put(value ,  valueFreqMap.get(value)-1);

        if(freqStackMap.get(maxfreq).isEmpty()){
            maxfreq -- ;
        }

        return value ;
    }

    public static void main(String args[]){

        MaximumFrequencyStack  stack = new MaximumFrequencyStack();
//        stack.push(5);
//        stack.push(1);
//        stack.push(2);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(1);
//        stack.push(6);
//        stack.push(1);
//        stack.push(5);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
