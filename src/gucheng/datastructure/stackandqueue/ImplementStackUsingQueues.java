package gucheng.datastructure.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueues {

    Queue<Integer>  queue1 = new LinkedList<>();

    Queue<Integer>  queue2 = new LinkedList<>();


    public void push(int x) {

        if(queue1.isEmpty())
        {
            queue1.offer(x);
            transfer(queue2 , queue1);

        }
        else{
            queue2.offer(x);
            transfer(queue1 , queue2);
        }

    }

    public void transfer(Queue<Integer> source , Queue<Integer> target)
    {
        while(!source.isEmpty())
        {
            target.offer(source.poll());
        }

    }
    public int pop() {
        if(queue1.isEmpty())
        {
            return queue2.poll();
        }
        else{
            return queue1.poll();
        }


    }

    public int top() {
        if(queue1.isEmpty())
        {
            return queue2.peek();
        }
        else{
            return queue1.peek();
        }

    }

    public boolean empty() {

        return queue1.isEmpty() && queue2.isEmpty() ;
    }

}
