package gucheng.algorithms.bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = wordList.stream().collect(Collectors.toSet());

        if(!wordSet.contains(endWord)){
            return 0 ;
        }
        Set<String>  beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String>  endSet = new HashSet<>();
        endSet.add(endWord);

        wordSet.remove(endWord);

        int length = ladderLength(beginSet ,1 ,  endSet , 1 ,wordSet);

        return length ;
    }


    public int ladderLength(Set<String> beginSet , int beginDepth , Set<String> endSet , int endDepth  , Set<String> wordSet){
        // find the one-step words


        for(String beginWord : beginSet){
            for(String endWord: endSet){
                if(diff(beginWord , endWord) == 1){
                    return beginDepth + endDepth;
                }
            }
        }

        if(wordSet.isEmpty()){
            return 0 ;
        }

        if(beginSet.size() > endSet.size()){
            Set<String> tempSet = beginSet;
            beginSet = endSet ;
            endSet = tempSet ;

            int temp = beginDepth ;
            beginDepth = endDepth;
            endDepth = temp ;
        }

        Set<String>  oneStepSet = new HashSet<>();
        for(String word : beginSet){
            oneStepSet.addAll(getOneStepWords(word , wordSet));
        }
        Set<String> candidateSet = new HashSet<>(wordSet);
        if(!candidateSet.removeAll(oneStepSet)){
            return 0 ;
        }

        int length = ladderLength(oneStepSet , beginDepth+1 , endSet , endDepth , candidateSet);

        return length ;
    }

    public Set<String>  getOneStepWords(String beginWord , Set<String> words)
    {
        Set<String> wordSet = new HashSet<>();

        for(String word : words){
            if(diff(beginWord , word) == 1){
                wordSet.add(word) ;
            }
        }

        return wordSet ;
    }
    public int diff(String word1 ,String word2){

        int diff = 0;
        for(int index = 0 ; index < word1.length() ; index++){
            if(word1.charAt(index) != word2.charAt(index)){
                diff ++;
            }
        }

        return diff ;
    }

    public static void main(String args[]){

        WordLadder wordLadder = new WordLadder();

        int distance = wordLadder.ladderLength("hit" , "cig" , List.of("hot","dot","dog","lot","log","bog"));
        System.out.println(distance);

    }
}
