package top150.hashmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {


        //return solution1(strs);
        return solution2(strs);
    }

    protected List<Integer> getWordCharCounts(String word){

        int[]  charCount = new int[26];

        for(char ch : word.toCharArray()){
            charCount[ch - 'a']++;
        }

        return IntStream.of(charCount).boxed().collect(Collectors.toList());

    }

    protected List<List<String>> solution1(String[] strs){
        Map<List<Integer> , List<String>>  anagramsMap = new HashMap<>();

        for(String word : strs){

            List<Integer> charCounts = getWordCharCounts(word);
            List<String> anagrams ;
            if(anagramsMap.containsKey(charCounts)){
                anagrams = anagramsMap.get(charCounts);
            }
            else{
                anagrams = new ArrayList<>();
                anagramsMap.put(charCounts , anagrams);
            }

            anagrams.add(word);

        }

        return anagramsMap.values().stream().toList();

    }
    protected List<List<String>> solution2(String[] strs){
        Map<String , List<String>>  anagramsMap = new HashMap<>();

        for(String word : strs){

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> anagrams ;
            if(anagramsMap.containsKey(key)){
                anagrams = anagramsMap.get(key);
            }
            else{
                anagrams = new ArrayList<>();
                anagramsMap.put(key , anagrams);
            }

            anagrams.add(word);

        }

        return anagramsMap.values().stream().toList();

    }

}
