package gucheng.dp.gametheory;

import java.util.stream.IntStream;

// https://leetcode.com/problems/predict-the-winner/
public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {


        return iterative((nums));
        //return recursive(nums);
    }

    public boolean recursive(int[] nums){

        Integer[][] memo = new Integer[nums.length][nums.length];

        int ans = recursive(nums , 0 , nums.length-1 , memo);

        return ans >= 0 ;
    }

    public int recursive(int[] nums , int left , int right , Integer[][] memo){

        if(left == right){
            return nums[left];
        }

        if(memo[left][right] != null) return memo[left][right];

        int ans = Math.max(nums[left] - recursive(nums , left+1, right , memo) , nums[right]-recursive(nums , left , right-1 , memo));

        memo[left][right] = ans ;
        return ans ;

    }
    public boolean iterative( int[] nums)
    {

        int[][] ans = new int[nums.length][nums.length];

        for(int index = 0; index < nums.length ; index++){
            ans[index][index]= nums[index];
        }

        for(int len = 1 ; len <= nums.length ; len++) {
            for (int index = 0; index < nums.length - len; index++) {
                int j = index+len ;
                ans[index][j] = Math.max(nums[index] - ans[index + 1][j], nums[j] - ans[index][j - 1]);

            }
        }
        return ans[0][nums.length-1] >= 0 ;
    }

    public static void main(String[] args){
        PredicttheWinner predicttheWinner = new PredicttheWinner();

        System.out.println(predicttheWinner.PredictTheWinner(new int[] {1,5,2}));
        System.out.println(predicttheWinner.PredictTheWinner(new int[] {1,5,233,7}));
    }
}
