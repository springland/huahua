package leetcodedaily;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        //return brutalForce(nums);
        return kadane(nums);
    }

    public int kadane(int nums[]){

        int ans = Integer.MIN_VALUE;

        int sum = 0;
        for(int index = 0 ; index < nums.length ; index++){
            if(sum < 0){
                sum = 0 ;
            }
            sum += nums[index];
            ans = Math.max(sum , ans);
        }

        return ans ;

    }
    public int brutalForce(int[] nums){

        int ans = Integer.MIN_VALUE ;
        for(int left = 0 ; left < nums.length ; left++){
            int sum = 0 ;
            for(int right = left ; right< nums.length ; right ++){
                sum += nums[right];
                ans = Math.max(ans , sum);
            }
        }
        return ans ;
    }
}
