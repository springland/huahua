package top150.array;

// https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
public class JumpGameII {
    public int jump(int[] nums) {

        //return recursive(nums);
        return iterative(nums);
    }

    public int iterative(int[] nums){

        int[] minJumps = new int[nums.length];

        for(int index = 1 ; index < nums.length ; index++){
            minJumps[index] = Integer.MAX_VALUE;
        }
        for(int index = 0 ; index < nums.length-1 ; index++){

            for(int step = 1 ; step <= nums[index] && index + step < nums.length ; step++){
                if(minJumps[index] + 1 < minJumps[index + step]){
                    minJumps[index + step] =minJumps[index] + 1;
                }
            }
        }

        return minJumps[nums.length-1] ;
    }
}
