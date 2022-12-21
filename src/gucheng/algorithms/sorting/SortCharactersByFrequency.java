package gucheng.algorithms.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character , Integer> charCountMap = new HashMap<>();

        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index);

            charCountMap.put(ch , charCountMap.getOrDefault(ch , 0)+1);
        }


        PriorityQueue<Map.Entry<Character , Integer>>  pq = new PriorityQueue<>( (a , b) -> b.getValue() - a.getValue());
        for( Map.Entry<Character , Integer>  entry : charCountMap.entrySet()){
            pq.offer(entry);
        }
        StringBuilder builder = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character , Integer> node = pq.poll();
            for(int index = 0 ; index < node.getValue() ; index++){
                builder.append(node.getKey());
            }
        }

        return builder.toString() ;
    }
}
