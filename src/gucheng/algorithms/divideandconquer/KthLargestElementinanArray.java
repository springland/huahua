package gucheng.algorithms.divideandconquer;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {

        return findKthLargest(nums , 0 , nums.length-1 , k);
    }

    public int findKthLargest(int nums[] , int beginIndex , int endIndex , int k){

        int left = beginIndex-1 ;
        int pivotal = nums[endIndex];

        for(int index = beginIndex ; index < endIndex ; index++)
        {
            if(nums[index] > pivotal){
                left ++;
                swap(nums , left , index);
            }
        }

        swap(nums , left +1 , endIndex);
        if( left +1 - beginIndex+1 == k){
            return nums[left+1];
        }
        else if ( left +1 - beginIndex+1 < k){
            return findKthLargest( nums , left+2 , endIndex , k -(left+2 - beginIndex));
        }
        else{
            return findKthLargest( nums , beginIndex , left , k);
        }
    }

    public void swap(int[] nums , int left , int right){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String args[] ){
        int nums[] = new int[] {3,2,1,5,6,4};

        //nums = new int[]{ 5 , 6 , 4};
        KthLargestElementinanArray kth = new KthLargestElementinanArray();
        System.out.println(kth.findKthLargest(nums , 2));
    }
}
