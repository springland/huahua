package top150.twopointers;

// https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase().trim();
        int left = 0 ;
        int right = s.length()-1;

        if(s.isEmpty()) return true ;

        while(!isValidChar(s.charAt(left)) && left < s.length()-1)left++;
        while(!isValidChar(s.charAt(right)) && right >0)right--;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false ;

            left++;
            right--;
            while(!isValidChar(s.charAt(left)) && left < s.length()-1)left++;
            while(!isValidChar(s.charAt(right)) && right >0)right--;
        }

        return true ;
    }

    public boolean isValidChar(char ch){

        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }
    public static void main(String[] args){

        ValidPalindrome p = new ValidPalindrome();
        System.out.println(p.isPalindrome(" "));
    }
}
