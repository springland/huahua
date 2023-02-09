package gucheng.dp.sequence;

// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {

        //return recursive(nums);
        return iterative(nums);
    }
    public boolean iterative(int nums[]){

        boolean[] ans = new boolean[nums.length];

        ans[0] = true ;
        for(int index = 0 ; index < nums.length && !ans[nums.length-1] ; index++){
            if(ans[index] == false)continue ;
            for(int step = 1 ; step <= nums[index] && index + step < nums.length; step++){
                ans[index+step]= true ;
            }
        }
        return ans[nums.length-1] ;
    }

    public boolean recursive(int nums[]){

        Boolean[] memo = new Boolean[nums.length];
        return recursive(nums , 0 , memo);

    }

    public boolean recursive(int nums[] , int index , Boolean[] memo){

        if(index >= nums.length-1){
            return true ;
        }
        if(memo[index] != null){
            return memo[index];
        }

        boolean ans = false ;

        for(int step = 1 ; step <= nums[index] && !ans ; step ++){
            ans |= recursive(nums , index+step , memo);
        }
        memo[index] = ans ;
        return ans ;

    }



}
