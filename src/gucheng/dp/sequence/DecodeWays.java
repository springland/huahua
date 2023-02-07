package gucheng.dp.sequence;

// https://leetcode.com/problems/decode-ways/description/
public class DecodeWays {
    public int numDecodings(String s) {

        //return recursive(s);
        return iterative(s);
    }

    public int recursive(String s){

        Integer memo[] = new Integer[s.length()];

        if(s.length() == 0 || s.charAt(0) == '0')return 0 ;
        return recursive(s , 0 , memo);
    }

    public int recursive(String s , int beginIndex , Integer[] memo)
    {
        if(beginIndex == s.length()){
            return 1 ;
        }
        if(memo[beginIndex] != null){
            return memo[beginIndex];
        }

        int ans = 0;

        if(s.charAt(beginIndex) != '0'){
            ans = recursive(s , beginIndex+1 , memo);
            if(beginIndex < s.length()-1){
                String twoChars =s.substring(beginIndex , beginIndex+2);
                if(Integer.valueOf(twoChars) <= 26 && Integer.valueOf(twoChars) >= 10){
                    ans +=  recursive(s , beginIndex+2 , memo);
                }
            }
        }

        memo[beginIndex] = ans ;
        return ans ;
    }

    public int iterative(String s){

        int[] ans = new int[s.length()+1];

        if(s.length() == 0 || s.charAt(0) == '0') return 0 ;

        ans[0] = 1 ;
        ans[1] = 1;

        for(int index = 2 ; index <= s.length() ; index++){

            int twoDigits = Integer.valueOf(s.substring(index-2 , index));

            if(twoDigits >= 10 && twoDigits <= 26){
                ans[index] += ans[index-2];
            }
            if(s.charAt(index-1) != '0'){
                ans[index ] += ans[index-1];
            }
        }


        return ans[s.length()];

    }

    public static void main(String args[]){
        DecodeWays  decodeWays = new DecodeWays();
        System.out.println(decodeWays.iterative("12"));
        System.out.println(decodeWays.iterative("226"));
        System.out.println(decodeWays.iterative("06"));
        System.out.println(decodeWays.iterative("11106"));
    }
}
