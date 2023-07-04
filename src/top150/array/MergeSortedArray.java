package top150.array;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tailIndex = m+n-1;
        int nums1Index = m-1 ;
        int nums2Index = n-1 ;

        while(nums1Index >= 0 && nums2Index >= 0){
            if(nums1[nums1Index] >= nums2[nums2Index]){
                nums1[tailIndex--] = nums1[nums1Index--];
            }
            else{
                nums1[tailIndex--] = nums2[nums2Index--];
            }
        }

        while(nums1Index >= 0){
            nums1[tailIndex--] = nums1[nums1Index--];
        }

        while(nums2Index >= 0 ){
            nums1[tailIndex--] = nums2[nums2Index--];
        }
    }
}
