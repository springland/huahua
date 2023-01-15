package leetcodedaily;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {


        boolean[][] matrix = new boolean[26][26] ;
        for(int index = 0 ; index < s1.length() ; index++){
            char ch1 = s1.charAt(index);
            char ch2 = s2.charAt(index);
            matrix[ch1-'a'][ch2-'a'] = true ;
            matrix[ch2-'a'][ch1-'a'] = true ;
            matrix[ch1-'a'][ch1-'a'] = true ;
            matrix[ch2-'a'][ch2-'a'] = true ;
        }


        char[] mappings = new char[128];
        for(char index = 'a' ; index <= 'z' ; index++){
            Set<Character> visited = new HashSet<>();
            Set<Character> mappingSet = getMappingChar(matrix , index , visited);

            mappings[index] = index ;
            for(char ch : mappingSet){
                mappings[index] = (char)Math.min(mappings[index] , ch);
            }


        }

        StringBuilder sb = new StringBuilder();
        for(int index = 0 ; index < baseStr.length() ; index++){
            sb.append(mappings[baseStr.charAt(index)]);
        }
        return sb.toString() ;

    }

    public Set<Character> getMappingChar(boolean[][] mappingMatrix , char ch , Set<Character> visited){

        boolean[] mappings = mappingMatrix[ch-'a'];
        Set<Character> mappingCharSet = new HashSet<>();



        for(char index = 'a' ; index <= 'z' ; index++){
            if(mappings[index-'a']){
                if(visited.contains(index)) continue ;
                mappingCharSet.add(index);
                visited.add(index);
                mappingCharSet.addAll(getMappingChar(mappingMatrix , index , visited));
            }
        }
        return mappingCharSet;
    }
    public static void main(String[] args){
        LexicographicallySmallestEquivalentString lexicographicallySmallestEquivalentString  = new LexicographicallySmallestEquivalentString();

//        System.out.println(lexicographicallySmallestEquivalentString.smallestEquivalentString(
//                "abc", "cde",
//                "eed"
//        ));
//
//        System.out.println(lexicographicallySmallestEquivalentString.smallestEquivalentString(
//                "parker", "morris",
//                "parser"
//        ));
//
//        System.out.println(lexicographicallySmallestEquivalentString.smallestEquivalentString(
//                "hello", "world",
//                "hold"
//        ));

        // sourcecode -> aauaaaaada
        System.out.println(lexicographicallySmallestEquivalentString.smallestEquivalentString(
                "leetcode", "programs",
                "sourcecode"
        ));

        System.out.println(lexicographicallySmallestEquivalentString.smallestEquivalentString(
                "leetcode", "programs",
                "rc"
        ));


    }
}
