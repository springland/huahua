package gucheng.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {

    public static void main(String args[])
    {
        MinimumWindowSubstring  min = new MinimumWindowSubstring();

        String answer = min.minWindow("ADOBECODEBANC" , "ABC");
        assertEquals(answer , "BANC");

        answer = min.minWindow("a" , "a");
        assertEquals(answer , "a");

        answer = min.minWindow("a" , "aa");
        assertEquals(answer , "");

    }

    public  String minWindow(String s, String t)
    {
        Map<Character , Integer >  charMap = new HashMap<>();

        String result = "" ;

        for(char ch : t.toCharArray())
        {
            charMap.put(ch , charMap.getOrDefault(ch , 0)+1);
        }


        int left  = 0;
        int right = 0 ;

        while(right < s.length())
        {
            if(charMap.containsKey(s.charAt(right)))
            {
                charMap.put(s.charAt(right) , charMap.get(s.charAt(right))-1);
            }
            while(containsAllChars(charMap))
            {
                if(result.equals( ""))
                {
                    result = s.substring(left , right+1);
                }
                else{
                    if(right -left +1 < result.length())
                    {
                        result = s.substring(left , right+1);
                    }
                }
                if(charMap.containsKey(s.charAt(left)))
                {
                    charMap.put(s.charAt(left) , charMap.get(s.charAt(left))+1);
                }

                left ++;
            }
            right ++;
        }


        return result ;
    }

    public  boolean  containsAllChars(Map<Character , Integer> charMap  )
    {
        long total = charMap.values().stream().filter( t-> t.intValue() > 0).count();
        return total == 0;
    }
}
