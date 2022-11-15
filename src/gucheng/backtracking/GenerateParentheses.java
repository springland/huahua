package gucheng.backtracking;


import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


//https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

    public static void main(String args[]){

        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(6));
    }
    // This is a combination
    public List<String> generateParenthesis(int n) {
        if(n == 1)
        {
            return List.of("()");
        }

        List<String>  result ;
        List<String>  answers = generateParenthesis(n-1);

        HashSet<String> visited = new HashSet<>();
        for(String ans : answers)
        {
            visited.add("()" + ans);

            visited.add(ans + "()");
            visited.add("(" + ans + ")");

            int count = 0 ;
            int beginIndex = 0;
            int endIndex = 0;
            while(endIndex < ans.length())
            {
                if(ans.charAt(endIndex) == '(')
                {
                    count ++;
                }
                else{
                    count --;
                }
                if(count == 0)
                {
                    String solution = null;

                    solution = ans.substring(0 , beginIndex);
                    solution += "(" + ans.substring(beginIndex , endIndex+1) + ")";
                    if(endIndex < ans.length()-1)
                    {
                        solution += ans.substring(endIndex+1 , ans.length());
                    }
                    visited.add(solution);

                    beginIndex = endIndex+1;
                }
                endIndex++ ;
            }


        }

        result = visited.stream().collect(Collectors.toList());
        return result ;

    }
}
