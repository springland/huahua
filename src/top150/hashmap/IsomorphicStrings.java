package top150.hashmap;

import java.util.*;

// https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()){
            return false ;
        }


        Set<List<Integer>>  sSet = getCharOccuranceListSet(s);
        Set<List<Integer>>  tSet = getCharOccuranceListSet(t);

        return sSet.equals(tSet) ;
    }

    protected Set<List<Integer>> getCharOccuranceListSet(String s){

        Map<Character , List<Integer>>  charIndexMap = new HashMap<>();

        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index);

            List<Integer>  charIndexList = charIndexMap.getOrDefault(ch , new ArrayList<>());
            charIndexList.add(index);
            charIndexMap.put(ch , charIndexList);
        }

        Set<List<Integer>>  charOccurListSet = new HashSet<>();

        for(Map.Entry<Character, List<Integer>> entry : charIndexMap.entrySet()){

            charOccurListSet.add(entry.getValue());
        }

        return charOccurListSet;


    }

    public static void main(String args[]){

        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

        System.out.println(isomorphicStrings.isIsomorphic("foo" , "too"));
    }
}
