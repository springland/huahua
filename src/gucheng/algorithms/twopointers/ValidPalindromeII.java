package gucheng.algorithms.twopointers;

// https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {

        return validPalindrome(s , 0 , s.length()-1 , 1);
    }

    public boolean validPalindrome(String s, int beginIndex , int endIndex , int k){

        while(beginIndex < endIndex){
            if(s.charAt(beginIndex) == s.charAt(endIndex)){
                beginIndex ++ ;
                endIndex --;
            }
            else{
                if(k > 0){
                    return validPalindrome( s , beginIndex+1 , endIndex , k-1) || validPalindrome(s , beginIndex , endIndex-1 , k-1);
                }else{
                    return false ;
                }

            }
        }
        return true ;

    }
}
