package gucheng.algorithms.recurison;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/concatenated-words/
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String>  ans = new ArrayList<>();
        Arrays.sort(words , (s1 , s2) -> s2.length() - s1.length());

        for(int index = 0 ; index < words.length ; index++){
            if(canBeConcatenated(words[index] , words , index+1)){
                ans.add(words[index]);
            }
        }
        return ans ;
    }
    public boolean canBeConcatenated(String target , String[] words , int beginIndex){
        if(target.isEmpty()){
            return true ;
        }
        for(int index = beginIndex ; index < words.length ; index++){
            String word = words[index];

            if(target.startsWith(word) && canBeConcatenated(target.substring(word.length()) , words , beginIndex )){
                return true ;
            }
        }
        return false ;
    }
}
