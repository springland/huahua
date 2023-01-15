package gucheng.algorithms.recurison;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        dfs(ans , "" , n , n);

        return ans ;

    }

    public void dfs( List<String> ans , String cur , int left , int right ){
        if(left == 0 && right == 0){
            ans.add(cur);
            return ;
        }

        if(left > 0) dfs(ans , cur + "(" , left -1 , right);

        if(right > left) dfs(ans , cur + ")" , left , right-1);
    }
}
