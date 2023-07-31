package top150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
public class MinimumWindowSubstring {

    public  String minWindow(String s, String t){


        String ans = "";


        int beginIndex = 0;
        Map<Character ,Integer > charCountMap = new HashMap<>();
        for(int index = 0 ; index < t.length() ; index++){
            Character ch = t.charAt(index);
            charCountMap.put(ch , charCountMap.getOrDefault(ch , 0)+1);
        }

        for( int endIndex = 0 ; endIndex < s.length() ; endIndex++){

            Character endChar = s.charAt(endIndex);
            if(charCountMap.containsKey(endChar)){

                charCountMap.put(endChar , charCountMap.get(endChar)-1);
            }

            while(isValid(charCountMap)){
                if(ans.isEmpty()){
                    ans = s.substring(beginIndex , endIndex+1);
                }
                else{
                    ans = ans.length() > endIndex+1 - beginIndex ? s.substring(beginIndex , endIndex+1): ans;
                }
                if(beginIndex < endIndex){
                    Character beginChar = s.charAt(beginIndex);
                    if(charCountMap.containsKey(beginChar)){
                        charCountMap.put(beginChar , charCountMap.get(beginChar)+1);
                    }
                    beginIndex++;
                }
                else{
                    break;
                }
            }

        }

        return ans ;
    }

    public boolean isValid(Map<Character ,Integer > charCountMap){

        boolean isValid = true ;
        for(Map.Entry<Character , Integer> entry : charCountMap.entrySet()){
            if(entry.getValue() > 0){
                isValid = false;
                break;
            }
        }
        return isValid ;
    }


    public static void main(String args[]){
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("a" , "a"));
       // System.out.println(minimumWindowSubstring.minWindow("a" , "aa"));
       // System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC" , "ABC") );
    }
}
