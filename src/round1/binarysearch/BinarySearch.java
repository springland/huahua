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

    public int findFirstOccurance(int nums[] , int target)
    {
        int beginIndex = 0 ;
        int endIndex = nums.length-1 ;

        while(beginIndex < endIndex)
        {
            int middleIndex = beginIndex + (endIndex - beginIndex)/2;
            if(nums[middleIndex] == target)
            {
                endIndex = middleIndex ;
            }else  if(nums[middleIndex] < target)
            {
                beginIndex = middleIndex+1;
            }
            else{
                endIndex = middleIndex-1;
            }
        }
        return endIndex ;
    }

    public int findLastOccurance(int nums[] , int target){
        int beginIndex = 0 ;
        int endIndex =  nums.length-1 ;
        while(beginIndex < endIndex){
            int middleIndex = beginIndex + (endIndex - beginIndex +1)/2;
            if(nums[middleIndex] == target){
                beginIndex = middleIndex ;
            }
            else if(nums[middleIndex] > target){
                endIndex = middleIndex-1;
            }else {
                beginIndex = middleIndex+1;
            }

        }
        return beginIndex ;
    }

    public int findClosest(int nums[] , int target){
        int beginIndex = 0 ;
        int endIndex = nums.length-1;

        while(beginIndex < endIndex-1){
            int middleIndex = beginIndex + (endIndex - beginIndex)/2;
            if(nums[middleIndex] < target)
            {
                beginIndex = middleIndex ;
            }
            else{
                endIndex = middleIndex ;
            }
        }

        if(nums[endIndex] < target)
        {
            return nums[endIndex];
        }else if(nums[beginIndex] > target)
        {
            return nums[beginIndex];
        }else{
            return Math.abs(target - nums[beginIndex]) < Math.abs(target - nums[endIndex]) ? nums[beginIndex] : nums[endIndex];
        }


    }

    public static void main(String args[])
    {

        int[] nums = new int[] { 1 , 2 , 2 , 2 , 4};
        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.findFirstOccurance(nums , 2));
        System.out.println(binarySearch.findFirstOccurance(nums , 4));
        System.out.println(binarySearch.findFirstOccurance(nums , 1));


        System.out.println(binarySearch.findLastOccurance(nums , 2));
        System.out.println(binarySearch.findLastOccurance(nums , 4));
        System.out.println(binarySearch.findLastOccurance(nums , 1));

        System.out.println();
        nums = new int[] { 1 , 2 , 2 ,  4};

        System.out.println(binarySearch.findFirstOccurance(nums , 2));
        System.out.println(binarySearch.findFirstOccurance(nums , 4));
        System.out.println(binarySearch.findFirstOccurance(nums , 1));


        System.out.println(binarySearch.findLastOccurance(nums , 2));
        System.out.println(binarySearch.findLastOccurance(nums , 4));
        System.out.println(binarySearch.findLastOccurance(nums , 1));

        System.out.println();
        nums = new int[] { 1 , 4 , 7};
        System.out.println(binarySearch.findClosest(nums , 0));


        System.out.println(binarySearch.findClosest(nums , 1));
        System.out.println(binarySearch.findClosest(nums , 2));
        System.out.println(binarySearch.findClosest(nums , 3));
        System.out.println(binarySearch.findClosest(nums , 4));
        System.out.println(binarySearch.findClosest(nums , 5));
        System.out.println(binarySearch.findClosest(nums , 6));
        System.out.println(binarySearch.findClosest(nums , 7));
        System.out.println(binarySearch.findClosest(nums , 8));

    }
}

