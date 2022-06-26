package round1.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *
 *
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {


        return peakIndexInMountainArray(arr , 0 , arr.length-1);
    }
    public int peakIndexInMountainArray(int[] arr , int beginIndex , int endIndex)
    {
        while(beginIndex < endIndex)
        {

            int middleIndex = beginIndex + (endIndex - beginIndex)/2 ;

            if(arr[middleIndex] > arr[middleIndex+1])
            {
                endIndex = middleIndex ;

            }
            else {
                beginIndex = middleIndex+1 ;
            }


        }

        return endIndex ;
    }

    public static void main(String args[])
    {
        int nums[] = new int[] {0,2,1,0};
        PeakIndexinaMountainArray  peak = new PeakIndexinaMountainArray();
        System.out.println(peak.peakIndexInMountainArray(nums));


    }
}
