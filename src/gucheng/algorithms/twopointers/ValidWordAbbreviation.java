package gucheng.algorithms.twopointers;


//https://leetcode.com/problems/valid-word-abbreviation/
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {

        int wordIndex = 0 ;
        int abbrIndex = 0 ;

        while(wordIndex < word.length() && abbrIndex < abbr.length()){

            if(word.charAt(wordIndex) == abbr.charAt(abbrIndex)){
                // for case like s1n s1n
                wordIndex++;
                abbrIndex++;
                continue ;
            }
            if(!Character.isDigit(abbr.charAt(abbrIndex)))
            {
                return false ;
            }

            if(abbr.charAt(abbrIndex) == '0'){
                // for invalid case s01n
                return false ;
            }
            int beginIndex = abbrIndex ;
            while(abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))){
                abbrIndex ++ ;
            };
            wordIndex += Integer.valueOf(abbr.substring(beginIndex , abbrIndex));
        }

        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    public static void main(String args[]){

        String word ;
        String abbr ;

        word = "internationalization";
        abbr = "i12iz4n" ;

        ValidWordAbbreviation validWordAbbreviation = new ValidWordAbbreviation();
        System.out.println(validWordAbbreviation.validWordAbbreviation(word , abbr));

    }
}
