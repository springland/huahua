package gucheng.dp.gametheory;

import java.util.stream.IntStream;

// https://leetcode.com/problems/stone-game-ii/
public class StoneGameII {

    public int stoneGameII(int[] piles) {


        return recursive(piles);
    }

    public int iterative(int[] piles){

        int total = IntStream.of(piles).sum();

        int[][] ans = new int[piles.length][piles.length+1];



        return 0 ;
    }
    public int recursive(int[] piles){

        Integer[][] memo = new Integer[piles.length][piles.length+1];


        int diff =  recursive(piles , 0 , 1 , memo);
        int total = IntStream.of(piles).sum();
        // x+y = total;
        // x-y = diff


        return (total+diff)/2;

    }

    public int recursive(int[] piles , int beginIndex ,  int m , Integer[][] memo){


        int total = 0 ;
        int ans = Integer.MIN_VALUE;

        if(beginIndex >= piles.length){
            return 0 ;
        }
        if(memo[beginIndex][m] != null) return memo[beginIndex][m] ;

        for(int x = 1 ; x <= Math.min(piles.length - beginIndex , 2*m) ; x++){
            total += piles[beginIndex+x-1];

            ans = Math.max(ans , total -  recursive(piles , beginIndex + x , Math.max(m , x) , memo ));
        }
        memo[beginIndex][m] = ans ;
        return ans ;
    }

    public static void main(String args[] ){
        StoneGameII stoneGameII = new StoneGameII();

        //System.out.println(stoneGameII.stoneGameII(new int[] { 2,7,9,4,4}));
        System.out.println(stoneGameII.stoneGameII(new int[] { 1}));
    }
}
