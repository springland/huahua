package gucheng.dp.gametheory;

// https://leetcode.com/problems/stone-game-iv/
public class StoneGameIV {
    public boolean winnerSquareGame(int n) {

        return recursive(n);

    }

    public boolean recursive(int n){
        Boolean memo[] = new Boolean[n+1];

        return recursive(n , memo);
    }

    public boolean recursive(int n , Boolean[] memo){

        if(n == 0){
            return false ;
        }
        if(n == 1) {
            return true ;
        }
        if(n == 2){
            return false ;
        }

        if(memo[n] != null){
            return memo[n];
        }

        boolean ans = false ;

        int index = 1;
        while(index*index <= n)
        {
            ans |= !recursive(n-index*index , memo);
            index++;
        }

        memo[n] = ans ;
        return ans ;
    }
}
