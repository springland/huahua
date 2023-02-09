package gucheng.dp.sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-break-ii/description/
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {


        return recursive(s , wordDict);
    }

    public List<String> recursive(String s, List<String> wordDict){
        List<String> [] memo = new List[s.length()];

        return recursive(s , wordDict ,0 , memo);

    }

    public List<String> recursive(String s , List<String> wordDict , int index , List<String>[] memo){
        if(index == s.length()){
            return new ArrayList<String>() ;
        }

        if(memo[index] != null){
            return  memo[index];
        }

        List<String>  ans = new ArrayList<>();
        for(String word : wordDict){

            if(s.startsWith(word , index)){

                if(s.length() == index + word.length())
                {
                    ans.add(word);
                }
                else{
                    List<String>  next = recursive(s , wordDict ,  index + word.length() , memo ) ;
                    ans.addAll(next.stream().map( t -> word + " " + t).collect(Collectors.toList()));
                }
            }
        }
        memo[index] = ans ;

        return ans ;
    }


    public List<String> iterative(String s , List<String> wordDict){
        List<String>[] ans = new List[s.length()+1];



        return ans[s.length()+1];

    }
    public static void main(String args[]){
        WordBreakII wordBreakII = new WordBreakII();

    }
}
