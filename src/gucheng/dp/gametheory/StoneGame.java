package gucheng.dp.gametheory;

// https://leetcode.com/problems/stone-game/
public class StoneGame {
    public boolean stoneGame(int[] piles) {


        return iterative(piles);
        //return recrusive(piles);
    }

    public boolean recrusive(int[] piles){
        Integer[][] memo = new Integer[piles.length][piles.length];

        int ans = recursive(piles , 0 , piles.length-1 ,memo);

        return ans > 0 ;
    }

    public int recursive(int[] piles , int beginIndex , int endIndex , Integer[][] memo){
        if(beginIndex == endIndex){
            return piles[beginIndex];
        }

        if(memo[beginIndex][endIndex] != null) return memo[beginIndex][endIndex];

        int ans = Math.max(
                piles[beginIndex] -  recursive(piles , beginIndex+1 , endIndex , memo),
                piles[endIndex] -  recursive(piles , beginIndex , endIndex-1 , memo)
        );

        memo[beginIndex][endIndex] = ans ;
        return ans ;
    }


    public boolean iterative(int[] piles){
        int[][]  ans = new int[piles.length][piles.length];

        for(int index = 0 ; index < piles.length ; index++){
            ans[index][index] = piles[index];
        }

        for(int len = 1 ; len <= piles.length ; len++){
            for(int beginIndex = 0 ; beginIndex < piles.length-len ; beginIndex++){
                int endIndex = beginIndex + len ;

                ans[beginIndex][endIndex]= Math.max(piles[beginIndex] - ans[beginIndex+1][endIndex],
                        piles[endIndex] - ans[beginIndex][endIndex-1]);

            }
        }
        return ans[0][piles.length-1] > 0 ;
    }
}
