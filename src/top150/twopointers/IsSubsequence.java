package top150.twopointers;
//https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int sIndex = 0;
        int tIndex = 0;

        while(sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                tIndex++;
                sIndex ++;
            }
            else{
                tIndex++;
            }
        }

        return sIndex == s.length();
    }

    public static void main(String[] args){
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc" , "ahbgdc"));
    }
}
