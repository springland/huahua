package gucheng.algorithms.binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
public class FindMinInRotatedSortedArrayII {

    public int findMin(int nums[])
    {

        return findMinScan(nums);
    }

    public int findMinScan(int[] nums) {


        int min = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if(num < min)
            {
                min = num ;
            }
        }
        return min;
    }

    public int findMinBinary(int nums[] )
    {
        int begin = 0;
        int end = nums.length-1;

        while(begin <= end)
        {
            int middle = begin + ( end - begin)/2 ;

        }


        return -1 ;
    }
}
