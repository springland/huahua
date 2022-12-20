package gucheng.algorithms.binary;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// https://www.youtube.com/watch?v=5hNWtR2EcrU&t=2078s
public class MedianofTwoSortedArrays {
    /*
        Slow solution , use find kth element in n sorted array
        Heap , this does not satisfy the requirement. And 2 array heap does not help much

        So find the median of nums1 and nums1 -> mark as m1 and m2  , the median of nums1 and nums2 is m = m1 + m2

        assign the arrays with less elements to nums1

        X0 and Y0 are kth/2
        XXXX X0 X
        YYYY Y0 YYY

        if X0 < Y0 then the number of elements less than Y0 is [XXXX X0] , [YYYY] , k-1 elements , so Kth element must not be X0 , the number of elements less than Y0 is at least k-1

        find the m
        if m1 < m2
            m1 is not be the median
            m = m - m1
            remove [0 , m1] from nums1
        continue until m = 1?

     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0.0 ;

        if((nums1.length + nums2.length) %2 == 0){
            double left = findKthElementOfSortedArrays( nums1 , 0 , nums2 , 0  ,(nums1.length + nums2.length) /2 );
            double right = findKthElementOfSortedArrays( nums1 , 0 , nums2 , 0  ,(nums1.length + nums2.length) /2+1 );
            median = (left + right)/2;
        }
        else{
            median = findKthElementOfSortedArrays( nums1 , 0 , nums2 , 0  ,(nums1.length + nums2.length) /2+1 );
        }

        return median ;

    }

    public double findKthElementOfSortedArrays(int[] nums1 , int beginIndex1 ,  int[] nums2 , int beginIndex2  , int k){
        if( k == 1){

            if(beginIndex1 == nums1.length ){
                return nums2[beginIndex2];
            }else if(beginIndex2 == nums2.length){
                return nums1[beginIndex1];
            }
            else{
                return nums1[beginIndex1] < nums2[beginIndex2] ? nums1[beginIndex1] : nums2[beginIndex2];
            }
        }


        int k1 , k2 ;
        if(beginIndex1 + k/2 > nums1.length){
            k1 = nums1.length - beginIndex1  ;
            k2 = k - k1 ;
        }
        else if (beginIndex2 + k/2 > nums2.length){
            k2 = nums2.length - beginIndex2  ;
            k1 = k -k2 ;
        }
        else{
            if(nums1.length - beginIndex1 < nums2.length - beginIndex2){
                k1 = k/2 ;
                k2 = k - k1;
            }
            else{
                k2 = k/2 ;
                k1 = k - k2 ;
            }
        }

        if(k1 == 0){
            return nums2[beginIndex2 + k2-1];
        }
        else if(k2 == 0){
            return nums1[beginIndex1+k1 -1];
        }
        if(nums1[beginIndex1 + k1-1] < nums2[beginIndex2 + k2 -1]){
            beginIndex1  += k1  ;
            k -= k1 ;
        }
        else{
            beginIndex2 += k2  ;
            k -= k2 ;
        }

        return findKthElementOfSortedArrays(nums1 , beginIndex1 , nums2 , beginIndex2 , k);
    }

    public static void main(String[] args){
        int[] nums1 = new int[] { 1 , 3};
        int[] nums2 = new int[]{2};

        MedianofTwoSortedArrays median = new MedianofTwoSortedArrays() ;
        System.out.println(median.findMedianSortedArrays(nums1 , nums2));

    }
}
