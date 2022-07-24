package round1.twopointers;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        int i = 0 ;
        int j = s.length()-1 ;
        s = s.toLowerCase();
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++ ;
            }

            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j-- ;
            }
            if(i < j){
                if(s.charAt(i) != s.charAt(j)){
                    return false ;
                }
            }
            i++;
            j-- ;
        }
        return true ;
    }


    public static void main(String args[]){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
        System.out.println(validPalindrome.isPalindrome(" "));
    }
}
