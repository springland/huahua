package gucheng.algorithms.twopointers;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;

        Map<Character , Integer> charCountMap = new HashMap<>();

        int left = 0;
        int right = 0;
        while(right < s.length()){

            Character ch = s.charAt(right);
            charCountMap.put(ch , charCountMap.getOrDefault(ch , 0)+1);
            while(charCountMap.size() > k){
                Character leftChar = s.charAt(left);
                int count = charCountMap.get(leftChar);
                if(count == 1){
                    charCountMap.remove(leftChar);
                }
                else{
                    charCountMap.put(leftChar , charCountMap.get(leftChar) -1);
                }

                left ++;
            }
            ans = Math.max(ans , right - left+1);
            right ++ ;
        }
        return ans ;

    }

    public static void main(String args[]){

    }
}
