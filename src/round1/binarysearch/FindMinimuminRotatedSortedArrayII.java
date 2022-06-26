package round1.binarysearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {

        return findMin(nums , 0  ,nums.length-1);

    }

    public int findMin(int nums[] , int beginIndex , int endIndex)
    {
        if(beginIndex == endIndex)
        {
            return nums[beginIndex];
        }

        int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;
        return Math.min(findMin(nums , beginIndex , middleIndex) , findMin(nums ,middleIndex+1 , endIndex));
    }

    public static void main(String args[])
    {
        int[] nums = new int[] {2,2,2,0,1};
        FindMinimuminRotatedSortedArrayII search = new FindMinimuminRotatedSortedArrayII();
        System.out.println(search.findMin(nums));
    }
}
