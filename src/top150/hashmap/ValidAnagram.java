package top150.hashmap;

// https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int charCount[] = new int[26];

        if(s.length() != t.length()){
            return false ;
        }

        for(char ch : s.toCharArray()){
            charCount[ch - 'a']++;
        }

        for(char ch : t.toCharArray()){
            charCount[ch - 'a']--;
        }

        for( int index = 0 ; index < charCount.length ; index++){
            if(charCount[index] != 0){
                return false ;
            }
        }

        return true ;
    }
}
