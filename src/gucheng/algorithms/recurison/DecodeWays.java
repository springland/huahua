package gucheng.algorithms.recurison;

import java.nio.charset.StandardCharsets;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    public int numDecodings(String s) {

        int[] memo = new int[s.length()];
        return numDecodings(s , 0 , memo);
    }

    public int numDecodings(String s , int beginIndex , int memo[]){



        if(beginIndex == s.length()){
            return 1 ;
        }

        if(memo[beginIndex] != 0)return memo[beginIndex];

        int ans ;
        if(s.charAt(beginIndex) == '0'){

            ans = 0;
        }
        else {
            ans = numDecodings(s , beginIndex+1 , memo);

            if(beginIndex < s.length()-1 && Integer.valueOf(s.substring(beginIndex , beginIndex+2)) <= 26)
            {
                ans += numDecodings(s , beginIndex+2 ,memo);
            }

        }
        memo[beginIndex] = ans ;
        return ans ;

    }

    public static void main(String args[]){
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("111111111111111111111111111111111111111111111"));
    }
}
