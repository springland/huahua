package top150.array;

import java.util.stream.Collectors;

public class ReverseWordsinaString {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        int count = (int)java.util.stream.Stream.of(words).filter(w -> !w.isEmpty()).count();
        for(int index = words.length-1 ; index >= 0 ; index--){

            if(!words[index].isEmpty()) {
                sb.append(words[index]);
                if (count > 1) {
                    sb.append(' ');
                }
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ReverseWordsinaString reverseWordsinaString = new ReverseWordsinaString();
        String s = "  hello world  ";
        System.out.println(reverseWordsinaString.reverseWords(s));
    }
}
