package round1.binarysearch;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return findMedianSortedArraysSolution2(nums1 , nums2);
        //return findMedianSortedArraysSolution1(nums1 , nums2);
    }


    public double findMedianSortedArraysSolution2(int[] nums1 , int nums2[] )
    {


        if((nums1.length + nums2.length) %2 == 1)
        {
            int k = (nums1.length + nums2.length)/2 +1;
            return findKthElementedInSortedArray(nums1 ,0 ,  nums2 ,0, k);
        }
        else {
            int k = (nums1.length + nums2.length)/2+1;

            int left = findKthElementedInSortedArray(nums1 ,0 ,  nums2 ,0 ,  k-1);
            int right =findKthElementedInSortedArray(nums1 , 0 , nums2 ,0 ,  k);

            return (left + right)/2.0 ;
        }


    }

    public int findKthElementedInSortedArray(int nums1[] , int beginIndex1  ,  int nums2[] , int beginIndex2 ,  int k)
    {


        if(k == 1)
        {
            if(beginIndex1 == nums1.length)
            {
                return nums2[beginIndex2 ];
            }

            if(beginIndex2 == nums2.length)
            {
                return nums1[beginIndex1];
            }

            return nums1[beginIndex1] < nums2[beginIndex2] ? nums1[beginIndex1]: nums2[beginIndex2];
        }


        int k1 , k2 ;
        if(beginIndex1 + k/2 > nums1.length )
        {
            k1 = nums1.length - beginIndex1;
            k2 = k - k1 ;


        }
        else if( beginIndex2 + k/2 > nums2.length){
            k2 = nums2.length - beginIndex2;
            k1 = k-k2 ;
        }
        else{
            if(nums1.length < nums2.length) {
                k1 = k / 2;
                k2 = k - k1;
            }
            else{
                k2 = k/2 ;
                k1 = k - k2 ;
            }

        }

        if(k1 == 0)
        {
            return nums2[beginIndex2+k2-1];
        }
        else if (k2 == 0)
        {
            return nums1[beginIndex1+k1-1];
        }
        else {
            if (nums1[beginIndex1 + k1 - 1] < nums2[k2 + beginIndex2 - 1]) {
                beginIndex1 = beginIndex1 + k1;
                k -= k1;
            } else {
                beginIndex2 = beginIndex2 + k2;
                k -= k2;

            }
        }
        return findKthElementedInSortedArray(nums1 ,beginIndex1 ,  nums2 , beginIndex2 ,  k);

    }

    public double findMedianSortedArraysSolution1(int[] nums1, int[] nums2) {

        int medianLeftIndex ;
        int medianRightIndex ;

        if((nums1.length + nums2.length) %2  == 1)
        {
            medianLeftIndex = (nums1.length + nums2.length)/2 ;
            medianRightIndex = medianLeftIndex;
        }
        else{
            medianLeftIndex = (nums1.length + nums2.length)/2 -1;
            medianRightIndex = (nums1.length + nums2.length)/2 ;
        }

        int nums1Index = 0 ;
        int nums2Index = 0 ;
        int medianIndex = 0;

        int medianLeft = 0;
        int medianRight = 0 ;
        while(medianIndex <= medianRightIndex && nums1Index < nums1.length && nums2Index < nums2.length)
        {

            if(nums1[nums1Index] < nums2[nums2Index])
            {
                if(medianIndex == medianLeftIndex)
                {
                    medianLeft = nums1[nums1Index];
                }
                if(medianIndex == medianRightIndex)
                {
                    medianRight = nums1[nums1Index];
                }
                nums1Index ++;

            }
            else{
                if(medianIndex == medianLeftIndex)
                {
                    medianLeft = nums2[nums2Index];
                }

                if(medianIndex == medianRightIndex)
                {
                    medianRight = nums2[nums2Index];
                }
                nums2Index++;

            }
            medianIndex ++;

        }

        while(medianIndex <= medianRightIndex && nums1Index < nums1.length)
        {
            if(medianIndex == medianLeftIndex)
            {
                medianLeft = nums1[nums1Index];
            }
            if(medianIndex == medianRightIndex)
            {
                medianRight = nums1[nums1Index];
            }
            nums1Index ++;

            medianIndex ++;

        }

        while(medianIndex <= medianRightIndex && nums2Index < nums2.length)
        {
            if(medianIndex == medianLeftIndex)
            {
                medianLeft = nums2[nums2Index];
            }
            if(medianIndex == medianRightIndex)
            {
                medianRight = nums2[nums2Index];
            }
            nums2Index ++;

            medianIndex ++;

        }

        return (medianLeft + medianRight)/2.0 ;
    }


    public static void main(String args[])
    {
        int nums1[] = new int[] { 1 };
        int nums2[] = new int[] { 2 ,3, 4};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(nums2 , nums1));

    }
}
