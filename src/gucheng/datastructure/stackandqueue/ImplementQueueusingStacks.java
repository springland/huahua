package gucheng.datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
public class ImplementQueueusingStacks {

    Deque<Integer> stack1 = new ArrayDeque<>();

    Deque<Integer> stack2 = new ArrayDeque<>();

    public void push(int x) {


        stack2.offerLast(x);
    }

    public int pop() {

        if(stack1.isEmpty())
        {
            transfer();
        }
        return stack1.pollLast();

    }

    public int peek() {
        if(stack1.isEmpty())
        {
            transfer();
        }
        return stack1.peekLast();
    }

    protected void transfer()
    {
        while(!stack2.isEmpty())
        {
            stack1.offerLast(stack2.pollLast());
        }
    }
    public boolean empty() {

        return stack1.isEmpty() && stack2.isEmpty();
    }
}
