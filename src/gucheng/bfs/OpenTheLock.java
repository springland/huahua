package gucheng.bfs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/problems/open-the-lock/
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> deadendsSet = Stream.of(deadends).collect(Collectors.toSet());

        String   start = "0000";
        Map<String , Integer> minStepsMap = new HashMap<>();
        minStepsMap.put(start , 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int size = queue.size() ;

            for( int index = 0 ; index < size ; index++){
                String current = queue.poll();
                if(deadendsSet.contains(current)){
                    continue ;
                }
                for(int wheelIndex = 0 ; wheelIndex < current.length() ; wheelIndex++){
                    String nextCombination =  getNextCombination(current , wheelIndex , true);
                    if(minStepsMap.get(current) + 1 < minStepsMap.getOrDefault(nextCombination , Integer.MAX_VALUE)){
                        minStepsMap.put(nextCombination ,minStepsMap.get(current) + 1 );
                        queue.offer(nextCombination);
                    }
                    nextCombination  = getNextCombination(current , wheelIndex , false);
                    if(minStepsMap.get(current) + 1 < minStepsMap.getOrDefault(nextCombination , Integer.MAX_VALUE)){
                        minStepsMap.put(nextCombination ,minStepsMap.get(current) + 1 );
                        queue.offer(nextCombination);
                    }
                }
            }
        }

        return minStepsMap.getOrDefault(target , -1);

    }

    public String getNextCombination(String src , int wheelIndex , boolean up){

        StringBuilder builder = new StringBuilder();
        builder.append(src.substring(0 , wheelIndex));
        char ch = src.charAt(wheelIndex);
        if(up){
            if ( ch == '0'){
                ch = '9';
            }
            else{
                ch = (char)(ch -1) ;
            }
        }
        else{
            if ( ch == '9'){
                ch = '0';
            }
            else{
                ch = (char)(ch +1) ;
            }
        }

        builder.append(ch);
        if( wheelIndex != src.length()-1){
            builder.append(src.substring(wheelIndex+1 ));
        }

        return builder.toString();
    }
}
