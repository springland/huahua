package gucheng.dp.gametheory;

// https://leetcode.com/problems/stone-game-v/
public class StoneGameV {
    public int stoneGameV(int[] stoneValue) {

        return recursive(stoneValue);
    }

    public int recursive(int[] stoneValue){
        int[][] memo = new int[stoneValue.length][stoneValue.length];

        return recursive(stoneValue , 0 , stoneValue.length-1 , memo);
    }

    public int recursive(int[] stoneValue , int left , int right , int[][] memo){
        if(left >= right){
            return 0 ;
        }

        if(memo[left][right] != 0) return memo[left][right];


        int ans= 0 ;

        int total = 0 ;
        for(int index = left ; index <= right ; index++){
            total += stoneValue[index];
        }

        int leftTotal = 0 ;
        for(int index = left ; index < right ; index++){

            leftTotal += stoneValue[index];
            int rightTotal = total - leftTotal ;

            if(leftTotal < rightTotal) {
                ans = Math.max(ans, leftTotal + recursive(stoneValue, left, index, memo));
            }else if(leftTotal == rightTotal){
                ans = Math.max(ans, leftTotal + recursive(stoneValue, left, index, memo));
                ans = Math.max(ans, rightTotal + recursive(stoneValue, index+1, right, memo));
            }else{
                ans = Math.max(ans, rightTotal + recursive(stoneValue, index+1, right, memo));
            }

        }

        memo[left][right] = ans ;

        return ans ;
    }
}
