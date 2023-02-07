package gucheng.dp.sequence;

// https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    public int climbStairs(int n) {

        //return recursive(n);
        return iterative(n);
    }

    public int recursive(int n){
        Integer memo[] = new Integer[n+1];

        return recursive(n , memo);
    }

    public int recursive(int n , Integer[] memo){

        if(n <= 2){
            return n ;
        }

        if(memo[n] != null){
            return memo[n];
        }

        int ans = recursive(n-1 , memo) + recursive(n-2 , memo);

        memo[n] = ans ;
        return ans ;
    }

    public int iterative(int n){

        if(n == 1){
            return 1 ;
        }
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;

        for(int index = 3 ; index <= n ; index++){
            ans[index] = ans[index-1] + ans[index-2];
        }

        return ans[n];
    }
}
