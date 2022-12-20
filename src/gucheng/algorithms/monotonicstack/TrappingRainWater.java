package gucheng.algorithms.monotonicstack;


import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {

        //return solution1(height);
        //return solution2(height);
        return solution2Enhanced(height);
    }

    public int solution1(int[] height) {

        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        int max = 0;
        for(int index = 0 ; index < height.length ; index++){
            if(height[index] > max) max = height[index];
            lmax[index] = max ;
        }

        max = 0;
        for(int index = height.length -1 ; index >= 0 ; index --){
            if(height[index] > max) max = height[index];
            rmax[index] = max ;
        }

        int total = 0;

        for(int index = 0 ; index < height.length ; index++){
            total += Math.min(lmax[index] , rmax[index]) - height[index];
        }
        return total ;
    }

    public int solution2(int[] height){
        // montonic stack

        // build a descreasing stack for the left side
        // once the height turns to increasing
        // pop the stack  to find the height on the left side which is equal or greater than the current one
        // then calculate the total

        int total = 0 ;

        Stack<Integer>  stack = new Stack<>();
        int preHeight = -1 ;
        for(int right = 1 ; right < height.length ; right++){
            if(height[right] > height[right-1]){
                // up

                /*

                    The height of D makes difference

                    Case 1
                    [5,4,2,3,2,1 , 5]   : 13


                    #                    #
                    #  #                 #
                    #  #     #           #
                    #  #  #  #   #       #
                    #  #  #  #   #   #   #
                    A  B  C  D   E   F   G



                    1)  B - C -D  is calculated  @ marker
                    2)  when A -B -C-D-E-F-G is calculated B-C-D is calculated again ( $  and @ marker ), it only needs the area not calculated in #1  $ marker


                    Case  2
                    [5,4,2,5,2,1 , 5]   : 11

                    #        #           #
                    #  #     #           #
                    #  #     #           #
                    #  #  #  #   #       #
                    #  #  #  #   #   #   #
                    A  B  C  D   E   F   G

                 */

                // still need to record the previous height
                while(!stack.isEmpty() && height[stack.peek()] <= height[right]){

                    int left = stack.pop() ;

                    int rangeheight = Math.min(height[left] , height[right]);

                    for(int index = left ; index <= right ; index ++){
                        total += height[index] >= rangeheight ? 0 :  rangeheight- preHeight;
                    }
                    preHeight = rangeheight ;
                }

                if(!stack.isEmpty()){
                    int left = stack.peek() ;

                    int rangeheight = Math.min(height[left] , height[right]);

                    for(int index = left ; index <= right ; index ++){
                        total += height[index] >= rangeheight ? 0 :  rangeheight- preHeight;
                    }
                    preHeight = rangeheight ;

                }
            }
            else{
                preHeight = height[right];
                if(stack.isEmpty()){
                    stack.push(right-1);
                }
                else if( stack.peek() != right -1){
                    stack.push(right -1);
                }
                stack.push(right);
            }

        }
        return total ;
    }


    public int solution2Enhanced(int[] height){
        Stack<Integer>  stack = new Stack<>();

        int size = 0;
        for(int rightIndex = 0; rightIndex < height.length ; rightIndex++  ){

            while(!stack.isEmpty() && height[rightIndex] > height[stack.peek()]){

                int bottomIndex = stack.pop();  // bottom
                if(stack.isEmpty()) break;
                int leftIndex = stack.peek();
                int minHeight = Math.min(height[leftIndex] , height[rightIndex]);
                int width = rightIndex - leftIndex -1 ; // exclude leftIndex and rightIndex
                size +=  (minHeight - height[bottomIndex]) * width ;
            }

            stack.push(rightIndex);
        }
        return size ;

    }


        public static void main(String args[] ){
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        height = new int[] { 1 , 2 , 3};
        TrappingRainWater trap = new TrappingRainWater();
        System.out.println(trap.trap(height));

        height = new int[] {4,2,0,3,2,5};
        System.out.println(trap.trap(height));


        // case 1
        height = new int[] {5,4,2,3,2,1 , 5};
        System.out.println(trap.trap(height));

        // case 2
        height = new int[] {5,4,2,5,2,1 , 5};
        System.out.println(trap.trap(height));


        height = new int[] {5,2,3};
        System.out.println(trap.trap(height));

        height = new int[] { 1 , 2 , 3};
    }
}
