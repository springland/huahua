package gucheng.dp.gametheory;

// https://leetcode.com/problems/divisor-game/
public class DivisorGame {
    public boolean divisorGame(int n) {

        //return recursive(n);
        return iterative(n);
    }


    public boolean recursive(int n){

        Boolean[] memo = new Boolean[n+1];
        return recursive(n , memo) ;
    }

    public boolean recursive(int n  , Boolean[] memo){
        if (n ==1 ){
            return false ;
        }
        if(memo[n] != null)return memo[n];
        boolean ans = false ;
        for( int x = 1 ; x <= n/2 ; x++){
            if(n%x == 0){
                ans |= !recursive(n-x , memo);
            }
        }
        memo[n] = ans ;
        return memo[n];
    }

    public boolean iterative(int n){
        boolean[] ans = new boolean[n+1];

        ans[0] = false ;
        ans[1] = false ;
        for(int index = 2 ; index <= n ; index++){

            ans[index] |= !ans[index-1];

            for(int x = 2 ; x <= index/2 ; x++){
                if(index%x == 0) ans[index] |= !ans[index-x];
            }
        }

        return ans[n];
    }
}
