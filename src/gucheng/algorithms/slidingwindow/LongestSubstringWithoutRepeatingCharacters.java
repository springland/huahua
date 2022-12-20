package gucheng.algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int ans = 0 ;

        if(s.isEmpty()) return ans ;

        int left = 0 ;
        int right = 0 ;
        Set<Character>  visited = new HashSet<>();


        while(right < s.length()){

            char ch = s.charAt(right);
            if(visited.contains(ch)){

                while(s.length() > left &&  s.charAt(left )!= ch){
                    visited.remove(s.charAt(left));
                    left ++;
                }
                if(s.length() > left) {
                    visited.remove(s.charAt(left));
                    left++;
                }
            }
            visited.add(ch);
            ans = Math.max(ans , visited.size());
            right ++;
        }
        return ans ;
    }

    public static void main(String args[]){

        String s ;
        LongestSubstringWithoutRepeatingCharacters  longest = new LongestSubstringWithoutRepeatingCharacters();

        s = "abcabcbb";

        System.out.println(longest.lengthOfLongestSubstring(s));
        System.out.println(longest.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longest.lengthOfLongestSubstring("pwwkew"));
    }
}
