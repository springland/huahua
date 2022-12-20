package gucheng.algorithms.dp;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public int rob(int[] nums) {

        //return robRecursive(nums);
        return robDp(nums);

    }

    public int robDp(int[] nums){

        int ans[] = new int[nums.length];
        ans[0] = nums[0];

        if(nums.length > 1){
            ans[1] = Math.max(nums[0], nums[1]);

            for (int index = 2; index < nums.length; index++) {

                ans[index] = Math.max(ans[index - 1], ans[index - 2] + nums[index]);
            }

        }
        return ans[nums.length-1];

    }

    public int robRecursive(int[] nums)
    {
        int[] cache = new int[nums.length];
        for(int index = 0 ; index < cache.length ; index ++){
            cache[index] = -1;
        }
        return rob(nums,  cache , nums.length-1);

    }
    public int rob( int[] nums , int[] cache ,  int index)
    {
        if(index == 0){

            return nums[0];
        }
        if(index == 1){
            return Math.max(nums[0] , nums[1]);
        }
        if(cache[index] >= 0){
            return cache[index];
        }
        cache[index] = Math.max(
                nums[index] + rob(nums , cache , index-2),
                rob(nums ,cache , index-1)
        );

        return cache[index];
    }


}
