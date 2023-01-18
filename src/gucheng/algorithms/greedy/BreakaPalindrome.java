package gucheng.algorithms.greedy;

// https://leetcode.com/problems/break-a-palindrome/
public class BreakaPalindrome {
    public String breakPalindrome(String palindrome) {

        int left = 0 ;
        int right = palindrome.length()-1 ;

        if(palindrome.length() == 1) {
            return "";
        }

        while( left < right){
            if(palindrome.charAt(left) == 'a'){
                left++;
                right--;
            }else {
                return palindrome.substring(0, left) + "a" + palindrome.substring(left + 1);
            }
        }

        // all of the chars are a
        return palindrome.substring(0, palindrome.length()-1) + "b";
    }

    public static void main(String[] args){
        BreakaPalindrome  breakaPalindrome = new BreakaPalindrome();

        //System.out.println(breakaPalindrome.breakPalindrome("abccba"));
        System.out.println(breakaPalindrome.breakPalindrome("aa"));
    }
}
