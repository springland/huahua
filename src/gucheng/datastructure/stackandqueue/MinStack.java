package gucheng.datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/min-stack/
public class MinStack {

    Deque<Integer> valueStack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {

    }

    public void push(int val) {

        if(valueStack.isEmpty())
        {
            valueStack.offerLast(val);
            minStack.offerLast(val);
        }
        else{
            if(minStack.peekLast() < val)
            {
                minStack.offerLast(minStack.peekLast());
            }
            else{
                minStack.offerLast(val);
            }
            valueStack.offerLast(val);
        }

    }

    public void pop() {
        minStack.pollLast();
        valueStack.pollLast();

    }

    public int top() {
        return valueStack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }

}
