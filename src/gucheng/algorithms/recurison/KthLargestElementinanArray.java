package gucheng.algorithms.recurison;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {

        return findKthLargest(nums , k , 0 , nums.length-1);
    }

    public int findKthLargest(int nums[] , int k , int beginIndex , int endIndex){

        if(beginIndex >= endIndex) return nums[beginIndex];

        int wallIndex = beginIndex ;

        for(int index = beginIndex ; index < endIndex ; index++){
            if(nums[index] > nums[endIndex]){
                swap(nums , index , wallIndex);
                wallIndex++;
            }
        }


        swap(nums , wallIndex , endIndex);
        if(k == wallIndex - beginIndex+1){
            return nums[wallIndex];
        }else if ( k < wallIndex - beginIndex+1){
            return findKthLargest(nums , k , beginIndex , wallIndex-1);
        }else{
            return findKthLargest(nums , k - (wallIndex - beginIndex+1) , wallIndex+1  , endIndex);
        }
    }

    protected void swap(int nums[] , int leftIndex , int rightIndex){
        int temp = nums[leftIndex];
        nums[leftIndex] = nums[rightIndex];
        nums[rightIndex] = temp ;

    }

    public static void main(String args[]){
        KthLargestElementinanArray kth = new KthLargestElementinanArray();

        System.out.println(kth.findKthLargest(new int[] {3 , 2  , 1 , 5 , 6 , 4} , 2));
    }
}
