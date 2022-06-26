package round1.binarysearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        if(nums.length == 1)
        {
            return nums[0];
        }

        if(nums[0] < nums[nums.length-1])
        {
            return nums[0];
        }

        return findMin(nums , 0 , nums.length-1);
    }


    public int findMin(int[] nums , int beginIndex , int endIndex)
    {
        while(beginIndex <= endIndex )
        {
            int middleIndex = beginIndex + (endIndex-beginIndex)/2;

            if(nums[middleIndex] == nums[beginIndex])
            {
                return Math.min(nums[beginIndex] , nums[endIndex]);
            }
            else if (nums[middleIndex] < nums[beginIndex])
            {
                if(nums[middleIndex-1] > nums[middleIndex])
                {
                    return nums[middleIndex];
                }
                else {
                    endIndex = middleIndex-1;
                }
            }
            else {

                if(nums[middleIndex+1] < nums[middleIndex])
                {
                    return nums[middleIndex+1];
                }
                else{
                    beginIndex = middleIndex+1;
                }
            }
        }
        return nums[endIndex+1] ;
    }
    public static void main(String args[])
    {
        FindMinimuminRotatedSortedArray search = new FindMinimuminRotatedSortedArray();
        int[] nums = new int[] {  2 , 1};
        System.out.println(search.findMin(nums));
    }
}
