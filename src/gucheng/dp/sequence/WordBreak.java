package gucheng.dp.sequence;

import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        //return recursive(s , wordDict);
        return iterative(s , wordDict);
    }

    public boolean recursive(String s , List<String> wordDict){
        Boolean  memo[] = new Boolean[s.length()];

        return recursive(s ,   wordDict , 0 ,  memo);

    }

    public boolean recursive(String s ,  List<String> wordDict , int index , Boolean[] memo){

        if(index == s.length()){
            return true ;
        }

        if(memo[index] != null){
            return memo[index];
        }

        boolean ans = false ;
        for(String word : wordDict){
            if(s.startsWith(word , index) &&  recursive(s , wordDict , index+word.length() , memo)){
                ans = true ;
                break;
            }
        }
        memo[index] = ans ;

        return ans ;

    }

    public boolean iterative(String s, List<String> wordDict){
        boolean[] ans = new boolean[s.length()+1];


        ans[0] = true;
        int index = 0 ;
        while(index < s.length()+1){
            while(index < s.length()+1 && ans[index] == false)index++ ;

            for(String word : wordDict){
                if(s.startsWith(word  , index)){
                    ans[index+ word.length()] = true ;
                }
            }

            index++ ;
        }
        return ans[s.length()];
    }

    public static void main(String[] args){

        WordBreak wordBreak = new WordBreak();

        System.out.println(wordBreak.wordBreak("leetcode" , List.of("leet","code")));
        System.out.println(wordBreak.wordBreak("applepenapple" , List.of("apple","pen")));
        System.out.println(wordBreak.wordBreak("catsandog" , List.of("cats","dog","sand","and","cat")));
    }
}
