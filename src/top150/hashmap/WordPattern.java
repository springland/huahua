package top150.hashmap;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false ;
        }

        boolean match = true ;

        Map<Character , String> charToWordMap = new HashMap<>();
        Map<String , Character> wordToCharMap = new HashMap<>();


        for(int index = 0 ; index < pattern.length() ; index++){
            char ch = pattern.charAt(index);
            String word = words[index];
            if(charToWordMap.containsKey(ch)){
                if(!word.equals(charToWordMap.get(ch))){
                    match = false ;
                    break;
                }
                else{
                    wordToCharMap.put(word , ch);
                }
            }
            else{

                if(wordToCharMap.containsKey(word)){
                        match = false ;
                        break;
                }
                else{
                    charToWordMap.put(ch , word);
                    wordToCharMap.put(word , ch);
                }
            }
        }

        return match ;
    }
}
