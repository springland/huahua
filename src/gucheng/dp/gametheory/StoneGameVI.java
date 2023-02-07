package gucheng.dp.gametheory;

//https://leetcode.com/problems/stone-game-vi/
public class StoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        // Is this  a dyanmic programming

        int[] diff = new int[aliceValues.length];
        for(int index = 0 ; index < aliceValues.length ; index++){
            diff[index] = aliceValues[index] - bobValues[index];
        }


        int ans = 0;

        return ans ;

    }

}
