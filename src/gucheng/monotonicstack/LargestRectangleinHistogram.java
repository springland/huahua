package gucheng.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {

        //return divideAndConquer(heights , 0 , heights.length-1);
        return montonicStack(heights);
    }

    public int montonicStack(int[] heights)
    {
        /*
        当图形处在上升期时(height[i] < height[i + 1])，其实是不用计算面积的，
        因为在这种情况下再往前移动一格(i -> i + 1)所能得到的面积必然更大；
        当图形处在下降期时（height[i] > height[i + 1]），
        就要开始计算当前矩形的面积了，这个时候暴力穷举所有stack里面的高度，
        因为stack是递增的，从最高的高度开始不断下降，随着高度的下降，
        更多的竖条可以加入到大长方形中的面积来，保持所有可以生成的大长方形的最大面积

        最后从最边界处理所有留在stack中
         */


        int largest = 0 ;

        Stack<Integer> stack = new Stack<>();

        for(int index = 0 ; index < heights.length ; index++){
            while(!stack.isEmpty() && heights[index] < heights[stack.peek()]){

                int curIndex = stack.pop();
                int curHeight = heights[curIndex];
                int leftIndex = stack.isEmpty() ? 0 : stack.peek()+1;
                int width = index - leftIndex ;
                largest = Math.max(largest , width * curHeight);

            }
            stack.push(index);
        }

        while(!stack.isEmpty()){
            int curIndex = stack.pop();
            int curHeight = heights[curIndex];
            int leftIndex = stack.isEmpty() ? 0: stack.peek()+1 ;
            // if it is the smallest , go to the begin of the histogram , otherwise stack.peek() +1 is the begin
            int width = heights.length - leftIndex ;
            largest = Math.max(largest , width * curHeight);

        }


        return largest ;

    }

    public int divideAndConquer(int[] heights , int beginIndex , int endIndex){

        // does not work for a very large flat histogram , time exceed
        if(beginIndex > endIndex){
            return 0 ;
        }

        int minHeightIndex = beginIndex ;

        for(int index = beginIndex ; index <= endIndex ; index++){
            if(heights[index] < heights[minHeightIndex]) minHeightIndex = index ;
        }

        int cur = (endIndex - beginIndex +1)* heights[minHeightIndex];
        int left = divideAndConquer(heights , beginIndex , minHeightIndex-1);
        int right =divideAndConquer(heights , minHeightIndex+1 , endIndex);

        return Math.max(Math.max(cur , left) , right);
    }


    public int official(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int heights[] ;

        LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();
        heights = new int[] { 2,1,5,6,2,3};

       // System.out.println(largestRectangleinHistogram.largestRectangleArea(heights));

        heights = new int[] {2,1,4,5,1,3,3};
        // 4 , 5
    //    System.out.println(largestRectangleinHistogram.largestRectangleArea(heights));

        heights = new int[] {2 , 1 , 2};

      //  System.out.println(largestRectangleinHistogram.largestRectangleArea(heights));

        heights = new int[] {4,2,0,3,2,5};
        System.out.println(largestRectangleinHistogram.largestRectangleArea(heights));
    }
}
