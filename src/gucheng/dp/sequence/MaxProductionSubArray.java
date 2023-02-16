package gucheng.dp.sequence;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductionSubArray {

    public int maxProduct(int[] nums) {
        //return brutalForce(nums);
        return iterative(nums);
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

    public int iterative(int[] nums){

        int[] min = new int[nums.length+1];
        int[] max = new int[nums.length+1];

        min[0] = 1;
        max[0] = 1;
        for(int index = 1 ; index <= nums.length ; index++){
            if(nums[index-1] < 0){
                min[index] = Math.min(nums[index-1] , max[index-1] * nums[index-1]);
                max[index] = Math.max(nums[index-1] , min[index-1] * nums[index-1]);

            }
            else{
                min[index] = Math.min(nums[index-1] , min[index-1] * nums[index-1]);
                max[index] = Math.max(nums[index-1] , max[index-1] * nums[index-1]);
            }

        }

        int ans = Integer.MIN_VALUE ;
        for(int index = 1 ; index < max.length ; index++){
            ans = Math.max(ans , max[index]);
        }
        return ans;
    }

    public static void main(String[] args){
        MaxProductionSubArray maxProductionSubArray = new MaxProductionSubArray();
        int[] nums = new int[] {2,3,-2,4};
        System.out.println(maxProductionSubArray.maxProduct(nums));

    }

}
