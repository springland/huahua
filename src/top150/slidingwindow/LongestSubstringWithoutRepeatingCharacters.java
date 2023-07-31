package top150.slidingwindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {


        int beginIndex = 0;

        int longest = 0;

        HashSet<Character>  set = new HashSet<>();

        for(int index = 0 ; index < s.length() ; index++){
            if(set.add(s.charAt(index))){
                longest = longest > index - beginIndex+1 ? longest : index - beginIndex+1;
            }
            else{
                while(s.charAt(beginIndex) != s.charAt(index)){
                    set.remove(s.charAt(beginIndex++));
                }
                beginIndex++;
            }
        }

        return longest ;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters  longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}
