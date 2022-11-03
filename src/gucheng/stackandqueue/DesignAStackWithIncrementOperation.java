package gucheng.stackandqueue;

// https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class DesignAStackWithIncrementOperation {

    int  stack[];
    int stackTop = -1;

    public DesignAStackWithIncrementOperation(int maxSize) {
        stack = new int[maxSize];
        stackTop = -1;


    }

    public void push(int x) {

        if(stackTop < stack.length-1)
        {
            stack[++stackTop] = x ;
        }
    }

    public int pop() {

        if(stackTop == -1)
        {
            return -1;
        }

        int val = stack[stackTop];
        stackTop--;
        return val ;
    }

    public void increment(int k, int val) {

        for(int stackIndex = 0 ; stackIndex <= stackTop && stackIndex < k ; stackIndex++)
        {
            stack[stackIndex]+= val ;
        }
    }
}
