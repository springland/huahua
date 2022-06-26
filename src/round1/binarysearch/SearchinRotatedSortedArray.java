package round1.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0)
        {
            return -1 ;
        }

        if(nums.length == 1)
        {
            if (nums[0] == target)
            {
                return 0 ;
            }
            return -1 ;
        }
        int index = 1;

        while(index <= nums.length-1 && nums[index] >= nums[index-1])
        {
            index++;
        }

        int targetIndex = 0;
        if(index == nums.length)
        {
            targetIndex =  binarySearch(nums , 0 , nums.length-1 , target);
        }
        else {
            targetIndex = binarySearch(nums , 0 , index-1 , target);
            if(targetIndex < 0)
            {
                targetIndex = binarySearch(nums , index , nums.length-1 , target);
            }

        }
        return targetIndex;

    }


    public int binarySearch(int nums[] , int beginIndex , int endIndex , int target)
    {
        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex- beginIndex)/2;
            if(nums[middleIndex] == target)
            {
                return middleIndex;
            }

            if(nums[middleIndex] < target)
            {
                beginIndex = middleIndex+1;
            }
            else {
                endIndex = middleIndex-1;
            }
        }
        return -1;
    }
}
