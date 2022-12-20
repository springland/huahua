package gucheng.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
// second round
public class MinimumWindowSubstring2 {
    public  String minWindow(String s, String t){



        Map<Character , Integer> charCountMap = new HashMap<>();
        for(int index = 0 ; index < t.length() ; index++){
            char ch = t.charAt(index);
            charCountMap.put(ch ,charCountMap.getOrDefault(ch , 0) +1);
        }

        int leftIndex = 0 ;
        String ans = "";
        for(int rightIndex = 0 ; rightIndex < s.length() ; rightIndex++){
            char rightChar = s.charAt(rightIndex);
            charCountMap.put(rightChar , charCountMap.getOrDefault(rightChar , 0)-1);
            while(isValid(charCountMap)){

                ans = ans.isEmpty() ? s.substring(leftIndex , rightIndex+1) :  ans.length() > rightIndex - leftIndex+1 ? s.substring(leftIndex , rightIndex+1) : ans ;

                char leftChar = s.charAt(leftIndex);
                charCountMap.put(leftChar , charCountMap.getOrDefault(leftChar , 0)+1);
                leftIndex ++ ;
            }

        }
        return ans;
    }

    protected boolean isValid(Map<Character , Integer> charCountMap){
        for( int val : charCountMap.values()){
            if(val > 0){
                return false ;
            }
        }
        return true ;
    }

    public static void main(String args[]){
        MinimumWindowSubstring2 minWindow = new MinimumWindowSubstring2();

        System.out.println(minWindow.minWindow("ADOBECODEBANC" , "ABC"));
        System.out.println(minWindow.minWindow("a" , "a"));
        System.out.println(minWindow.minWindow("a" , "aa"));
    }
}
