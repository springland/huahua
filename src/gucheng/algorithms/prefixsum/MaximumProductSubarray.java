package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        return brutalForce(nums);
    }

    public int brutalForce(int[] nums){

        int ans = Integer.MIN_VALUE ;

        if(nums.length == 0){
            return 0 ;
        }
        for(int left = 0 ; left < nums.length ; left ++){
            int product = 1;
            for(int right = left ; right < nums.length ; right++){
                if(product == 0) {
                    product = 1;
                }
                product = product * nums[right];
                ans = Math.max(ans , product);
            }
        }

        return ans ;
    }
}
