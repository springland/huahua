package gucheng.binarysearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

// with duplicates

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchInRotatedSortedArrayII {

    public static void main(String args[])
    {
        int[] nums ;
        SearchInRotatedSortedArrayII search = new SearchInRotatedSortedArrayII();

        nums = new int[] {2,5,6,0,0,1,2};
        assertTrue(search.search(nums , 0));
        assertFalse(search.search(nums , 3));

        nums = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};

        assertTrue(search.search(nums , 2));
    }


    public boolean search(int[] nums, int target) {

        if(nums == null || nums.length == 0)
        {
            return false ;
        }

        int pivotalIndex = findPivotalIndex(nums) ;

        int targetIndex ;
        if(pivotalIndex == -1)
        {
            targetIndex = binarySearch(nums, 0  , nums.length-1 , target);
        }
        else{
            if(nums[0] <= target && nums[pivotalIndex-1] >= target)
            {
                targetIndex = binarySearch(nums , 0 , pivotalIndex-1 , target);
            }
            else{
                targetIndex = binarySearch(nums , pivotalIndex , nums.length-1 , target);
            }
        }

        return targetIndex >= 0 ;

    }


    public int findPivotalIndex(int nums[])
    {
        int pivotalIndex = -1 ;

        for(int index = 1 ; index < nums.length ; index++)
        {
            if(nums[index] < nums[index-1])
            {
                pivotalIndex = index ;
                break;
            }
        }
        return pivotalIndex ;
    }
    public int binarySearch(int[] nums , int beginIndex , int endIndex , int target)
    {
        while(beginIndex <= endIndex)
        {
            int middle = beginIndex + (endIndex - beginIndex)/2 ;
            if(nums[middle] == target){
                return middle ;
            }
            else if ( nums[middle] < target)
            {
                beginIndex = middle+1 ;
            }
            else{
                endIndex = middle-1 ;
            }
        }

        return -1 ;
    }

}
