package top150.array;
// https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        String[] words = s.split(" ");
        if(words.length > 0){
            return words[words.length-1].length();
        }
        return 0 ;

    }


}
