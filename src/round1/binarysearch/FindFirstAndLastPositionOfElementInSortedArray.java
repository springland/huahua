package round1.binarysearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int beginIndex = 0 ;
        int endIndex = nums.length-1;
        if(endIndex < 0) {
            return new int[] {-1 , -1};
        }

        int middleIndex = -1 ;
        while(beginIndex <= endIndex)
        {
            middleIndex = beginIndex + ( endIndex - beginIndex)/2 ;
            if(nums[middleIndex] == target)
            {
                break;
            }
            else if(nums[middleIndex] < target)
            {
                beginIndex = middleIndex+1 ;
            }
            else {
                endIndex = middleIndex-1;
            }
        }

        if( nums[middleIndex] != target)
        {
            return new int[] {-1 , -1};
        }

        beginIndex = searchBeginIndex(nums , 0 , middleIndex , target);

        endIndex = searchEndIndex(nums , middleIndex  , nums.length-1, target);

        return new int[] {beginIndex , endIndex};
    }

    public int searchBeginIndex(int nums[] ,int beginIndex ,  int endIndex ,int target)
    {

        int lastIndex = endIndex ;
        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + ( endIndex - beginIndex)/2 ;
            if(nums[middleIndex] == target)
            {
                lastIndex = middleIndex ;
                endIndex = middleIndex -1 ;
            }
            else
            {
                beginIndex = middleIndex +1 ;
            }
        }
        return lastIndex ;
    }

    public int searchEndIndex(int nums[] , int beginIndex , int endIndex , int target)
    {
        int lastIndex = beginIndex ;
        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex-beginIndex)/2 ;
            if(nums[middleIndex] == target)
            {
                lastIndex = middleIndex ;
                beginIndex = middleIndex+1;
            }
            else {
                endIndex = middleIndex-1;
            }
        }
        return lastIndex ;
    }

    public static void main(String args[])
    {
        int nums[] = new int[] { 5,7,7,8,8,10};

        FindFirstAndLastPositionOfElementInSortedArray searcher = new FindFirstAndLastPositionOfElementInSortedArray();
        int ans[] = searcher.searchRange(nums , 6);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
