package gucheng.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringwithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {


        int leftIndex = 0 ;
        int rightIndex = 0 ;
        int ans = 0 ;
        if (k == 0) return ans ;
        Map<Character , Integer> charCountMap = new HashMap<>();
        while(rightIndex < s.length()){
            char rightChar = s.charAt(rightIndex);

            if(charCountMap.size() == k){
                if(!charCountMap.containsKey(rightChar))
                {
                    while(charCountMap.size() == k){
                        char leftChar = s.charAt(leftIndex);
                        if(charCountMap.get(leftChar) == 1){
                            charCountMap.remove(leftChar);
                        }else{
                            charCountMap.put(leftChar , charCountMap.get(leftChar)-1);
                        }
                        leftIndex++;
                    }
                }
            }
            charCountMap.put(rightChar , charCountMap.getOrDefault(rightChar , 0) +1);
            ans = Math.max(ans , rightIndex - leftIndex+1);
            rightIndex++;
        }

        return ans ;
    }

    public static void main(String args[]){
        LongestSubstringwithAtMostKDistinctCharacters longest = new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(longest.lengthOfLongestSubstringKDistinct("eceba" , 2));
        System.out.println(longest.lengthOfLongestSubstringKDistinct("aa" , 1));
    }
}
