package gucheng.algorithms.greedy;
// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {


        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true ;
        for(int index = 0 ; index  < canJump.length ; index++){
            if(!canJump[index])break;

            for(int step = 1  ; step <= nums[index] && step + index < nums.length; step ++){
                canJump[index + step] = true ;
            }
        }

        return canJump[nums.length-1] ;

    }
}
