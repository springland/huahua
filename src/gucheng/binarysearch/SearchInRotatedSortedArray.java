package gucheng.binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/

import static org.junit.jupiter.api.Assertions.assertEquals;

// This one only contains distinct values
public class SearchInRotatedSortedArray {

    public static void main(String args[])
    {
        SearchInRotatedSortedArray  search = new SearchInRotatedSortedArray();

        int nums[] = new int[] { 9 , 1 , 2 , 3};
        int minIndex = search.serchMinimalIndex(nums , 0 , nums.length-1);
        assertEquals(minIndex , 1);

        nums = new int[] { 3 , 9 , 1 , 2 };
        minIndex = search.serchMinimalIndex(nums , 0 , nums.length-1);
        assertEquals(minIndex , 2);

        nums = new int[] {1 , 2 ,  3 , 9 };
        minIndex = search.serchMinimalIndex(nums , 0 , nums.length-1);
        assertEquals(minIndex , 0);

        int targetIndex = 0;
        nums = new int[] {4,5,6,7,0,1,2};
        targetIndex = search.search(nums, 0);
        assertEquals(targetIndex , 4);

        nums = new int[] {4,5,6,7,0,1,2};
        targetIndex = search.search(nums, 3);
        assertEquals(targetIndex , -1);

        nums = new int[] {1};
        targetIndex = search.search(nums, 0);
        assertEquals(targetIndex , -1);

        nums = new int[] {1};
        targetIndex = search.search(nums, 1);
        assertEquals(targetIndex , 0);

    }

    public int search(int[] nums, int target) {

        int minIndex = serchMinimalIndex(nums , 0 , nums.length-1);

        if(minIndex == 0)
        {
            return binarySearch(nums, 0 , nums.length-1 , target);
        }
        else{
            if(nums[0] <= target && nums[minIndex-1] >= target)
            {
                return binarySearch(nums , 0 , minIndex-1 , target);
            }
            if(nums[minIndex] <= target && nums[nums.length-1] >= target)
            {
                return binarySearch(nums , minIndex , nums.length-1 , target);
            }

            return -1 ;
        }

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
    public int serchMinimalIndex(int nums[] , int beginIndex , int endIndex)
    {
            if(nums[beginIndex] <= nums[endIndex] )
            {
                return beginIndex ;
            }
            else {
                int middle = beginIndex + (endIndex - beginIndex) / 2;
                if (nums[middle] < nums[beginIndex]) {
                    return serchMinimalIndex(nums, beginIndex, middle);
                } else {
                    return serchMinimalIndex(nums, middle + 1, endIndex);
                }
            }
    }
}
