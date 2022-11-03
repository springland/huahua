package round1.divideandconquer;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {


        return findMin(nums , 0 , nums.length-1);
    }

    public int findMin(int[] nums , int beginIndex , int endIndex)
    {
        if(beginIndex == endIndex){
            return nums[beginIndex];
        }

        if(nums[beginIndex] < nums[endIndex]){
            return nums[beginIndex];
        }

        int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;
        int left = findMin(nums , beginIndex , middleIndex);
        int right = findMin(nums , middleIndex+1 , endIndex);

        return left < right ? left : right ;
    }

    public static void main(String args[]){

        int nums[] = null;

        nums = new int[] {3,4,5,1,2};

        FindMinimuminRotatedSortedArray find = new FindMinimuminRotatedSortedArray();
        System.out.println(find.findMin(nums));

        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(find.findMin(nums));

        nums = new int[] {11,13,15,17};
        System.out.println(find.findMin(nums));
    }
}
