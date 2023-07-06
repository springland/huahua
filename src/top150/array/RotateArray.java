package top150.array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
public class RotateArray {

    public void rotate(int[] nums, int k) {

        //solution1(nums , k);
        solution2(nums , k);
    }

    public void solution1(int nums[] , int k){
        int[] temp = new int[k];

        k = k % nums.length;
        int startIndex = nums.length-k;
        System.arraycopy(nums , startIndex , temp , 0 , k );
        System.arraycopy(nums , 0 , nums , k , nums.length-k);
        System.arraycopy(temp , 0  , nums , 0 , k);
    }

    public void solution2(int nums[] , int k){

        // [1 , 2 , 3 , 4 , 5] k = 2

        // [ 1 ,2 , 3, ,4] k = 2

        // [1  ,2 , 3 ,4]  k = 3

        int count = 0;
        for(int index = 0 ; index < k && count < nums.length   ; index++){
            int targetIndex = (index +k)%nums.length;
            int value = nums[index];

            while(targetIndex != index ){
                count ++;
                int temp = nums[targetIndex];
                nums[targetIndex] = value;
                value = temp ;
                targetIndex = (targetIndex+k)%nums.length;
            }
            nums[targetIndex] = value ;
            count++;
        }

    }
    public static void main(String args[]){

        //int[] nums = new int[] {1 , 2 , 3 ,4 , 5} ;
        int[] nums = new int[] {1 , 2 , 3 ,4 } ;

        RotateArray  rotateArray ;
        rotateArray = new RotateArray() ;
        rotateArray.rotate(nums , 3);
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
    }
}
