package top150.hashmap;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character , Integer>  magazineCharMap = new HashMap<>();

        for(char ch : magazine.toCharArray()){

            magazineCharMap.put( ch , magazineCharMap.getOrDefault(ch , 0)+1  );

        }

        boolean canConstruct = true ;
        for ( char ch : ransomNote.toCharArray()){
            if(magazineCharMap.getOrDefault(ch , -1) <= 0){
                canConstruct = false ;
                break;
            }
            else{
                magazineCharMap.put(ch , magazineCharMap.get(ch)-1);
            }
        }

        return canConstruct;
    }
}
