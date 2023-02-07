package gucheng.dp.gametheory;

// https://leetcode.com/problems/stone-game-iii/
public class StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {

        int ans = recursive(stoneValue);

        if(ans > 0){
            return "Alice";
        }else if (ans == 0){
            return "Tie";
        }else{
            return "Bob";
        }
    }

    public int iterative(int[] stoneValue){

        int[] ans = new int[stoneValue.length];
        ans[0] = stoneValue[0];

        for(int index = 1 ; index < stoneValue.length ; index++){

        }
        return ans[stoneValue.length-1] ;
    }
    public int recursive(int[] stoneValue){

        Integer[] memo = new Integer[stoneValue.length];

        return recursive(stoneValue , 0 , memo);
    }

    public int recursive(int[] stoneValue , int beginIndex , Integer[] memo){
        if(beginIndex >= stoneValue.length){
            return 0 ;
        }

        if(memo[beginIndex] != null) return memo[beginIndex];

        int ans = Integer.MIN_VALUE;

        int total = 0 ;
        for(int x = 0 ; x <= 2 && beginIndex + x < stoneValue.length ; x++){
            total += stoneValue[beginIndex+x];

            ans = Math.max(ans , total -recursive(stoneValue , beginIndex+x+1 , memo));
        }
        memo[beginIndex] = ans ;

        return ans ;
    }
}
