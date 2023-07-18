package top150.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;

        int sum = 0;

        int head = 0;
        int tail = 0 ;

        while(head <=nums.length && tail <= nums.length){
            if (sum < target){
                if (tail < nums.length) {
                    sum += nums[tail++];
                }
                else{
                    break;
                }
            }
            if ( sum >= target){
                if( head < nums.length) {
                    minLength = minLength < tail - head ? minLength : tail - head;
                    sum -= nums[head++];
                }
                else{
                    break;
                }
            }

        }

        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }

    public static void main(String args[] ){

        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = new int[]{5,1,3,5,10,7,4,9,2,8};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(15 , nums));
    }
}
