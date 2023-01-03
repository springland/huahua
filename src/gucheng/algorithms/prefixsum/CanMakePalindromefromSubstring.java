package gucheng.algorithms.prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/can-make-palindrome-from-substring/
public class CanMakePalindromefromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean>  ans = new ArrayList<>();

        int[][] charCountsPrefixSum = new int[s.length()][26];

        int[] charCounts = new int[26];
        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index);
            charCounts[ch -'a'] ++;
            charCountsPrefixSum[index] = charCounts.clone();
        }

        for(int index = 0 ; index < queries.length ; index++){
            int[] query = queries[index];
            if(query[0] == query[1]){
                ans.add( true );
            }
            else {
                int[] charCounts1 =   charCountsPrefixSum[query[0]];
                int[] charCounts2 =   charCountsPrefixSum[query[1]];

                int sum = 0 ;
                for(int charIndex = 0 ; charIndex < charCounts1.length ; charIndex++){


                    if(s.charAt(query[0])-'a' == charIndex){
                        // to include query[0] result. an example is [0 , 3 , 1]   abcda , there are 4 chars , if
                        sum += (charCounts2[charIndex] - charCounts1[charIndex]+1)%2 ;
                    }
                    else{
                        sum += (charCounts2[charIndex] - charCounts1[charIndex])%2 ;
                    }
                }
                if(query[2] == 0){
                    ans.add(sum == 0);
                }
                else {
                    ans.add(sum  / 2 <= query[2]);
                }

            }
        }

        return ans ;
    }



    public static void main(String[] args){
        CanMakePalindromefromSubstring canMakePalindromefromSubstring = new CanMakePalindromefromSubstring();

        int[][] queries = new int[][] {{0,3,1}} ;

        canMakePalindromefromSubstring.canMakePaliQueries("abcda" , queries);
    }
}
