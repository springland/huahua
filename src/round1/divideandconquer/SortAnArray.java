package round1.divideandconquer;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/sort-an-array/
 */
public class SortAnArray {

    public int[] sortArray(int[] nums) {

        //return mergeSort(nums);
        return quickSort(nums);
    }

    public int[] mergeSort(int[] nums){


        mergeSort(nums , 0 , nums.length-1);
        return nums ;

    }

    public void mergeSort(int[] nums , int beginIndex , int endIndex){
        if(beginIndex == endIndex){
            return ;
        }

        if(endIndex == beginIndex +1){
            if(nums[endIndex] < nums[beginIndex]){
                int temp = nums[beginIndex];
                nums[beginIndex]= nums[endIndex];
                nums[endIndex]= temp;
            }
            return ;
        }

        int middleIndex = beginIndex + (endIndex - beginIndex)/2;

        mergeSort(nums , beginIndex , middleIndex);
        mergeSort(nums , middleIndex+1 , endIndex);

        int l = beginIndex ; int r = middleIndex+1 ;
        while( l < middleIndex+1 && r <= endIndex){
            if(nums[l ] < nums[r]){
                l++;
            }else if ( nums[r] < nums[l]){
                int temp = nums[r];
                int index = r;
                while( index > l){
                    nums[index]= nums[index-1];
                    index--;
                }
                nums[l] = temp;
                l++;
                r++;
                middleIndex++;
            }
            else{
                l++;
            }
        }

        return ;
    }

    public int[] quickSort(int nums[]){



        quickSort(nums  , 0 , nums.length-1);
        return nums ;
    }

    public void quickSort(int nums[] , int beginIndex , int endIndex){

        if(beginIndex >= endIndex ){
            return ;
        }
        int pivotal = nums[endIndex];
        int i = beginIndex-1 ;
        for(int j = beginIndex ; j < endIndex ; j++)
        {
            if(nums[j] < pivotal){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp ;
            }
        }

        i++;
        int temp = nums[endIndex];
        nums[endIndex] = nums[i] ;
        nums[i] = temp;

        quickSort(nums , beginIndex , i-1);
        quickSort(nums , i+1 , endIndex);

    }
    public static void main(String args[]){

        int nums[] = null;

        SortAnArray sort = new SortAnArray();

        nums = new int[] {5,2,3,1};
        sort.sortArray(nums);
        System.out.println(IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        nums = new int[] {6 , 5 ,4 , 3 , 2 , 1};
        sort.sortArray(nums);
        System.out.println(IntStream.of(nums).mapToObj(String::valueOf).collect(Collectors.joining(",")));

    }
}
