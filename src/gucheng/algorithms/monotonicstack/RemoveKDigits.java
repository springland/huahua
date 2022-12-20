package gucheng.algorithms.monotonicstack;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {


        StringBuilder builder = new StringBuilder();

        Stack<Character> stack = new Stack<>();


        for(int index = 0 ; index < num.length() ; index++){
            char ch = num.charAt(index);

            while(k > 0 && ! stack.isEmpty() && ch < stack.peek()){
                k -- ;
                stack.pop();
            }
            stack.push(ch);
        }

        while(k > 0){
            k -- ;
            stack.pop();
        }

        boolean leadingZero = true ;
        for(char ch : stack){
            if(ch != '0' ){
                leadingZero = false ;
            }
            else if (leadingZero) continue ;
            builder.append(ch);
        }


        return builder.toString().isEmpty() ? "0": builder.toString();
    }

    public static void main(String args[] ){

        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("1432219" , 3));
        System.out.println(removeKDigits.removeKdigits("10200" , 1));
        System.out.println(removeKDigits.removeKdigits("10" , 2));
    }

}
