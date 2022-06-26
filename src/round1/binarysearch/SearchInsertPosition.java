package round1.binarysearch;

/**
 *
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int beginIndex = 0 ;
        int endIndex = nums.length -1;

        if(endIndex < 0)
        {
            return 0;
        }


        return searchInsert(nums , target , beginIndex , endIndex);
    }

    public int searchInsert(int nums[] , int target , int beginIndex , int endIndex)
    {

        if(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + ( endIndex - beginIndex)/2 ;
            if(nums[middleIndex] == target)
            {
                return middleIndex ;
            }
            else if( nums[middleIndex] < target)
            {
                beginIndex = middleIndex+1;
            }
            else {
                endIndex = middleIndex -1 ;

            }
            return searchInsert(nums , target , beginIndex , endIndex);
        }
        else {
            return endIndex+1 ;
        }
    }

    public static void main(String args[])
    {
        SearchInsertPosition  search = new SearchInsertPosition();
        int[] nums = new int[] {1 , 3 , 5};
        System.out.println( search.searchInsert(nums , 3) );
        System.out.println( search.searchInsert(nums , 2) );
        System.out.println( search.searchInsert(nums , 6) );
        System.out.println( search.searchInsert(nums , 0) );

    }
}
