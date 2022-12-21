package gucheng.algorithms.sorting;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        return findKthLargest(nums , k , 0 , nums.length-1);
    }

    public int findKthLargest(int[] nums , int k , int beginIndex , int endIndex){

        if( k == 0) return nums[beginIndex];
        int pivotalIndex = beginIndex ;

        for(int index = beginIndex ; index < endIndex ; index++){
            if(nums[index] > nums[endIndex]){
                swap(nums , pivotalIndex , index);
                pivotalIndex ++;
            }
        }
        swap(nums , pivotalIndex , endIndex);
        if(pivotalIndex - beginIndex +1 == k){
            return nums[pivotalIndex];
        }else if ( pivotalIndex - beginIndex +1 > k){

            return findKthLargest(nums , k , beginIndex , pivotalIndex -1);
        }
        else {
          return findKthLargest(nums ,  k - ( pivotalIndex - beginIndex+1) , pivotalIndex+1 , endIndex);
        }

    }
    public void swap(int nums[] , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        KthLargestElementInAnArray  kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[] {3,2,1,5,6,4} , 2));
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6} , 4));
    }


}
