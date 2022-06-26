package round1.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindPeakElement {

    /*
            After run a few test cases it was found the first and last element can be a peak ,

            For example
            [1] -> 1 is peak

            [2 , 1] -> 2 is peak

            [1 , 2] -> 2 is peak

            [ 6 , 5 , 4, 3, 2 , 7] -> 6 and 7 are peaks
            [ 6 ,3 , 5 , 4 , 3 , 2 , 7 ] => 6 , 5 , 7 are peaks





            it is not necessary to be a three element such as [1 , 3 , 2 ] which makes 3 the top

            Then it can be done with O(log(n)) , if it requires to have both left and right neighbour it got to be o(n)
     */


    public int findPeakElement(int[] nums) {

        if(nums.length == 1)
        {
            return 0 ;
        }

        if(nums[0] > nums[1])
        {
            return 0 ;
        }

        if(nums[nums.length-1] > nums[nums.length-2])
        {
            return nums.length-1;
        }
        return findPeakElement2(nums , 0 , nums.length-1);
    }


    public int findPeakElement2(int[] nums , int beginIndex ,int endIndex)
    {
        while(beginIndex < endIndex) {
            int middleIndex = beginIndex + (endIndex - beginIndex) / 2;

            // assume nums[middleIndex] != nums[middleIndex+1]
            if(nums[middleIndex] > nums[middleIndex+1])
            {
                // either middleIndex or somewhere on the left of middleIndex is peak

                endIndex = middleIndex ;
            }
            else {
                // then the middleIndex cannot be peak , either middleIndex+1 or somwehere on the right of middleIndex is peak
                beginIndex = middleIndex+1;
            }
        }
        return endIndex ;
    }
    public int findPeakElement(int[] nums , int beginIndex , int endIndex)
    {
        if(endIndex - beginIndex < 2)
        {
            return -1 ;
        }
        int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;
        if( nums[middleIndex] > nums[middleIndex-1] && nums[middleIndex] > nums[middleIndex+1])
        {
            return middleIndex ;
        }

        int leftIndex = findPeakElement(nums , beginIndex , middleIndex);

        if(leftIndex >= 0)
        {
            return leftIndex ;
        }
        return  findPeakElement(nums , middleIndex , endIndex);
    }

    public static void main(String args[])
    {
        FindPeakElement find = new FindPeakElement();

        int[] nums = new int[] {1,2,3,1};
        System.out.println(find.findPeakElement(nums));

    }
}
