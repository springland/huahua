package gucheng.dp.gametheory;

// https://leetcode.com/problems/nim-game/
public class NimGame {

    public boolean canWinNim(int n) {

        //return recursive(n);
        //return iterative(n);
        return simple(n);
    }

    public boolean simple(int n){
        return !(n%4 == 0) ;
    }
    public boolean iterative(int n){

        if(n <= 3) {
            return true ;
        }
        boolean ans[] = new boolean[4];

        ans[0] = true ;
        ans[1] = true ;
        ans[2] = true ;

        for(int index = 3 ; index < n ; index++){

            ans[index%4] = !ans[(index-1)%4] || !ans[(index-2)%4] || !ans[(index-3)%4];

        }
        return ans[(n-1)%4] ;

    }

    public boolean recursive(int n){

        Boolean memo[] = new Boolean[n+1];
        return recursive(n , memo);
    }
    public boolean recursive(int n , Boolean memo[]){

        if(n <= 3){
            return true ;
        }

        if(memo[n] != null)return memo[n] ;
        Boolean ans = !recursive(n-1) || !recursive(n-2) || !recursive(n-3);
        memo[n] = ans;
        return ans ;

    }


    public static void main(String[] args){
        NimGame  nimGame = new NimGame();
        System.out.println(nimGame.canWinNim(4));
        System.out.println(nimGame.canWinNim(1348820612));
    }
}
