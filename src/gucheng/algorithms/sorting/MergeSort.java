package gucheng.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSort {

    public static void main(String args[]){

        int[] nums  = new int[] { 3 , 7 , 9 , 2 ,4 , 10 , 6 , 5};
        int[] expected = Arrays.copyOf(nums , nums.length);
        Arrays.sort(expected);

        sort(nums);
        IntStream.of(nums).forEach(System.out::println);
        assertArrayEquals(nums , expected);


    }

    public static void sort(int[] nums){

        sort(nums , 0 , nums.length-1);
    }

    public static void sort(int[] nums , int beginIndex , int endIndex){

        if(beginIndex >= endIndex){
            return ;
        }

        if(beginIndex == endIndex -1)
        {
            if(nums[beginIndex] > nums[endIndex])
            {
                int temp = nums[beginIndex];
                nums[beginIndex] = nums[endIndex];
                nums[endIndex]= temp ;

            }
            return ;
        }
        int middleIndex = beginIndex + ( endIndex - beginIndex)/2;

        sort(nums , beginIndex , middleIndex);
        sort(nums , middleIndex+1 , endIndex);
        merge(nums, beginIndex , middleIndex , endIndex);

    }

    public static void merge(int nums[] , int beginIndex , int middleIndex ,  int endIndex){
        int leftIndex = 0 ;
        int rightIndex = 0 ;

        int left[] = Arrays.copyOfRange(nums , beginIndex , middleIndex+1);
        int right[] = Arrays.copyOfRange(nums , middleIndex+1 , endIndex+1);



        int index = beginIndex ;
        while(leftIndex < left.length && rightIndex <right.length){
            if(left[leftIndex] < right[rightIndex]){
                nums[index++] = left[leftIndex++];
            }
            else{
                nums[index++] = right[rightIndex++];
            }
        }
        while(leftIndex < left.length){

            nums[index ++] = left[leftIndex++];
        }

        while(rightIndex < right.length){
            nums[index ++] = right[rightIndex++];
        }

    }
}
