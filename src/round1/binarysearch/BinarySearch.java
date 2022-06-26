package round1.binarysearch;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public int search(int[] nums, int target) {

        int  beginIndex = 0 ;
        int endIndex = nums.length-1;

        if(endIndex == -1)
        {
            return -1 ;
        }

        while(beginIndex <= endIndex)
        {
            int middleIndex = 0;

            middleIndex = beginIndex + (endIndex-beginIndex)/2;
            if(nums[middleIndex ] == target)
            {
                return middleIndex ;
            }

            if(nums[middleIndex] <  target)
            {
                beginIndex = middleIndex+1;
            }
            else {
                endIndex = middleIndex-1;
            }
        }

        return -1 ;
    }
}

