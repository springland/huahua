package top150.array;

// https://leetcode.com/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {
    public boolean canJump(int[] nums) {


        return iterative(nums);
    }

    public boolean iterative(int[] nums){

        boolean[] canJump = new boolean[nums.length];

        canJump[0] = true ;

        for(int index = 0  ; index < nums.length ; index++){
            if(canJump[index]) {
                for (int step = 1; step <= nums[index] && step + index <nums.length; step++) {
                    canJump[index+step] = true ;
                }
            }
        }

        return canJump[nums.length-1];
    }
}
