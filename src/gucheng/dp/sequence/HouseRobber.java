package gucheng.dp.sequence;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {

        //return recursive(nums);
        //return iterative(nums);
        return iterative2(nums);
    }

    public int recursive(int[] nums) {
        int memo[] = new int[nums.length];
        for( int index = 0 ; index < memo.length ; index++){
            memo[index] = -1;
        }
        return recursive(nums , 0 , memo);

    }

    public int recursive(int[] nums, int index, int[] memo)
    {
        if(index >= nums.length){
            return 0 ;
        }

        if(memo[index] >= 0){
            return memo[index];
        }

        int ans = 0 ;
        ans = Math.max(
                nums[index] + recursive(nums , index+2 , memo) ,
                recursive(nums , index+1 , memo)
        );
        memo[index] = ans ;

        return ans ;
    }

    public int iterative(int[] nums){

        int[] ans = new int[nums.length];

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0] , nums[1]);
        for(int index = 2 ; index < nums.length ; index++){

            ans[index] = Math.max(nums[index] + ans[index-2] , ans[index-1]);

        }
        return ans[nums.length-1] ;
    }

    public int iterative2(int[] nums){

        int[][] ans = new int[nums.length+1][2] ;

        // 0 is not rob , 1 is  rob

        ans[0][0] = 0 ;
        ans[0][1] = 0 ;

        for(int index = 1 ; index <= nums.length ; index++){

            // not rob
            ans[index][0] = Math.max(ans[index-1][1] , ans[index-1][0]);

            ans[index][1] = nums[index-1] + ans[index-1][0];
        }



        return Math.max(ans[nums.length][0] , ans[nums.length][1]);


    }
    public static void main(String args[]){

        int nums[] = {2,1,1,2};
        HouseRobber houseRobber = new HouseRobber();

        System.out.println(houseRobber.iterative(nums));
        //System.out.println(houseRobber.recursive(nums));
    }

}
