package gucheng.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {


        Set<Character> charSet = new HashSet<>();
        Map<Character , Integer> charCountMap = null;

        int ans = 0 ;

        for(int index = 0 ; index < s.length() ; index++){
            charSet.add(s.charAt(index));
        }
        for( int unique = 1 ; unique <= charSet.size() ; unique ++)
        {

            charCountMap = new HashMap<>();
            int leftIndex = 0 ;
            int validCount = 0 ;
            for(int rightIndex = 0 ; rightIndex < s.length() ; rightIndex++) {

                char rightChar = s.charAt(rightIndex);
                charCountMap.put(rightChar , charCountMap.getOrDefault(rightChar , 0)+1);
                if(charCountMap.get(rightChar) == k) validCount ++ ;
                while(charCountMap.size() > unique)
                {
                    char leftChar = s.charAt(leftIndex);

                    if(charCountMap.get(leftChar) == k) validCount -- ;
                    charCountMap.put(leftChar , charCountMap.get(leftChar  )-1);
                    if(charCountMap.get(leftChar) == 0){
                        charCountMap.remove(leftChar);
                    }
                    leftIndex ++;
                }

                if(validCount == unique && charCountMap.size() == unique ){
                    ans = Math.max(ans , rightIndex - leftIndex+1);
                }
            }
        }

        return ans ;

    }

    public static void main(String args[]){
        LongestSubstringwithAtLeastKRepeatingCharacters longest = new LongestSubstringwithAtLeastKRepeatingCharacters();
     //   System.out.println(longest.longestSubstring("aaabb" , 3));
     //   System.out.println(longest.longestSubstring("aaabb" , 2));
        System.out.println(longest.longestSubstring("ababbc" , 2));
    }
}
