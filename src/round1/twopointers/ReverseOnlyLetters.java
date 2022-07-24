package round1.twopointers;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {

        int i = 0 ;
        int j = s.length()-1;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        while(i < j){
            while(i < j && !Character.isLetter(s.charAt(i))){
                left.append(s.charAt(i++));
            }
            while(i < j && !Character.isLetter(s.charAt(j))){
                right.append(s.charAt(j--));
            }
            if(i < j){
                left.append(s.charAt(j--));
                right.append(s.charAt(i++));
            }
        }

        if(i == j){
            left.append(s.charAt(i));
        }

        return left.toString() + right.reverse().toString();
    }


    public static void main(String args[]){
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));

        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("abc"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("abcd"));
    }


}
