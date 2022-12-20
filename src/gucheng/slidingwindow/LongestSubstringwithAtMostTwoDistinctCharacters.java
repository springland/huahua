package gucheng.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        Map<Character , Integer>  charMap = new HashMap<>();

        int ans = 0 ;
        int left = 0 ; int right = 0 ;

        while(right < s.length()){
            char rightChar = s.charAt(right);
            if(charMap.size() == 2){
                if(!charMap.containsKey(rightChar)){
                    while(charMap.size() == 2){
                        char leftChar = s.charAt(left);
                        int count = charMap.get(leftChar);
                        count -- ;
                        charMap.put(leftChar, count);
                        if(count == 0){
                            charMap.remove(leftChar);
                        }
                        left ++ ;
                    }
                }

            }
            charMap.put(rightChar , charMap.getOrDefault(rightChar , 0) +1);

            ans = Math.max(ans , right - left +1);
            right ++ ;
        }

        return ans ;
    }

    public static void main(String args[] ){

        LongestSubstringwithAtMostTwoDistinctCharacters longest = new LongestSubstringwithAtMostTwoDistinctCharacters() ;

        System.out.println(longest.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(longest.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(longest.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }


}
