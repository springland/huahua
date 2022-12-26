package leetcodedaily;

// https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public boolean canJump(int[] nums) {

        boolean[] canJump = new boolean[nums.length];



        int tail = nums[0];
        for(int index= 0 ; index < nums.length ; index++){
            if(index <= tail){
                canJump[index] = true ;
            }
            if(canJump[index]){
                tail = Math.max(tail , nums[index] + index);
            }

        }

        return canJump[nums.length-1];

    }

    public static void main(String args[]){
        int nums[] = new int[] {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
      //  System.out.println(jumpGame.canJump(nums));

        nums = new int[] {3,2,1,0,4};
       // System.out.println(jumpGame.canJump(nums));

        nums = new int[] { 0 , 2 , 3};
        System.out.println(jumpGame.canJump(nums));

    }
}
