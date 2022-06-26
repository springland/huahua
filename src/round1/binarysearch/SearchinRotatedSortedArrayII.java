package round1.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        if(nums == null || nums.length == 0)
        {
            return false ;
        }

        int pivotalIndex = findPivotalIndex(nums);
        int targetIndex = -1 ;
        if(pivotalIndex == -1)
        {
            targetIndex = binarySearch(nums , 0 , nums.length-1 , target);
        }
        else {
            targetIndex = binarySearch(nums , 0 , pivotalIndex-1 , target);
            if(targetIndex < 0)
            {
                targetIndex = binarySearch(nums , pivotalIndex , nums.length-1 , target);
            }
        }

        return targetIndex >= 0 ;

    }

    public int findPivotalIndex(int nums[])
    {
        if(nums == null || nums.length == 0 || nums.length == 1)
        {
            return -1 ;
        }

        for(int index = 1 ; index < nums.length ; index++)
        {
            if(nums[index] < nums[index-1])
            {
                return index ;
            }
        }
        return -1 ;
    }


    public int binarySearch(int nums[] , int beginIndex , int endIndex , int target)
    {
        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;
            if(nums[middleIndex] == target)
            {
                return middleIndex;
            }
            if(nums[middleIndex] < target)
            {
                beginIndex = middleIndex +1 ;
            }
            else{
                endIndex = middleIndex-1 ;
            }
        }
        return -1 ;
    }

    public static void main(String args[])
    {
        int nums[] = new int[] { 1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1 };
        SearchinRotatedSortedArrayII search = new SearchinRotatedSortedArrayII();
        System.out.println(search.search(nums , 0));
        System.out.println(search.search(nums , 3));
        System.out.println(search.search(nums , 2));
        System.out.println(search.search(nums , 13));

    }

    /*
    public int findPivotalIndex(int nums[])
    {

        int beginIndex =  0 ;
        int endIndex = nums.length-1 ;


        while(nums[beginIndex] >= nums[endIndex] && beginIndex < endIndex)
        {
            int middleIndex = beginIndex + ( endIndex - beginIndex)/2 ;

            if(middleIndex == beginIndex)
            {
                if( nums[endIndex] <= nums[beginIndex])
                {
                    return endIndex ;
                }
                else {
                    return -1 ;
                }
            }
            else {
                if (nums[middleIndex] >= nums[beginIndex]) {

                    beginIndex = middleIndex;
                } else {
                    endIndex = middleIndex;
                }

            }
        }

        return -1 ;
    }


     */
}
