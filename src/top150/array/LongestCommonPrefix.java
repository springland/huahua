package top150.array;

// https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        for(int charIndex = 0 ; charIndex < strs[0].length() ; charIndex++){
            for(int wordIndex = 1 ; wordIndex < strs.length ; wordIndex++){
                if(strs[wordIndex].length() < charIndex+1 || strs[wordIndex].charAt(charIndex) != strs[0].charAt(charIndex)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(charIndex));
        }

        return sb.toString();
    }
}
