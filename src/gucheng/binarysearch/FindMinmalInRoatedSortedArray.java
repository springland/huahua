package gucheng.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinmalInRoatedSortedArray {


    public static void main(String args[]){
        FindMinmalInRoatedSortedArray  find = new FindMinmalInRoatedSortedArray();

        int nums [] = new int[] {3,4,5,1,2} ;

        assertEquals(find.findMin(nums ) , 1);

        nums = new int[] {4,5,6,7,0,1,2};
        assertEquals(find.findMin(nums ) , 0);

        nums = new int[] {11,13,15,17};
        assertEquals(find.findMin(nums ) , 11);

    }

    public int findMin(int[] nums) {

        return findMin(nums , 0 , nums.length-1);
    }

    public int findMin(int[] nums , int beginIndex , int endIndex)
    {
        if(nums[beginIndex] <= nums[endIndex])
        {
            return nums[beginIndex] ;
        }
        else{
            int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;

            if(nums[beginIndex] <= nums[middleIndex])
            {
                return findMin(nums , middleIndex+1 , endIndex);
            }
            else{
                return findMin(nums , 0 , middleIndex );
            }
        }
    }
}
