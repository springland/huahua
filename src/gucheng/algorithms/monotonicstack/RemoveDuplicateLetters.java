package gucheng.algorithms.monotonicstack;

import java.util.*;

// https://leetcode.com/problems/remove-duplicate-letters/
// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {


        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        Map<Character , Integer> availableCharacterMap = new HashMap<>();

        for(int index = 0 ; index < s.length() ; index ++){

            char ch = s.charAt(index);
            availableCharacterMap.put(ch , availableCharacterMap.getOrDefault(ch , 0)+1);
        }

        // build a decreasing stack
        // scan from front to end
        // if the char is the last one and has not been added , add it in


        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index);

            if(stack.contains(ch)){
                int count = availableCharacterMap.get(ch);
                availableCharacterMap.put(ch , count -1);
                continue ;
            }
            while( !stack.isEmpty()  &&stack.peek() > ch  && availableCharacterMap.get(stack.peek()) > 1)
            {

                char top = stack.pop();
                int count = availableCharacterMap.get(top);
                availableCharacterMap.put(top , count -1);
            }
            stack.push(ch);
        }

        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString() ;
    }


    public String removeDuplicateLettersBetter(String s) {

        StringBuilder builder = new StringBuilder();

        Stack<Character>  stack = new Stack<>();
        int[] charLastIndex = new int[128];

        for(int index = 0 ; index < s.length() ; index++){
            charLastIndex[s.charAt(index)] = index ;
        }

        // build a decreasing stack
        // scan from front to end
        // if the char is the last one and has not been added , add it in

        Set<Character> visited = new HashSet<>();

        for(int index = 0 ; index < s.length() ; index ++){
            char ch = s.charAt(index);
            if(visited.contains(ch))continue; ;

            while(!stack.isEmpty() && ch < stack.peek() && index < charLastIndex[stack.peek()]){
                visited.remove(stack.pop());
            }
            visited.add(ch);
            stack.push(ch);
        }

        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString() ;

    }
    public static void main(String args[]){
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLettersBetter("bcabc"));
        System.out.println(removeDuplicateLetters.removeDuplicateLettersBetter("cbacdcbc"));
       System.out.println(removeDuplicateLetters.removeDuplicateLettersBetter("bbcaac"));
    }
}
