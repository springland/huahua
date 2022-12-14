package gucheng.dp;

//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {

    public int climbStairs(int n) {


        if(n == 1) return 1 ;
        if( n == 2) return 2 ;
        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2 ;
        for(int index = 2 ; index < n ; index++)
        {
            ans[index] = ans[index-1] + ans[index-2];
        }
        return ans[n-1];
    }
}
