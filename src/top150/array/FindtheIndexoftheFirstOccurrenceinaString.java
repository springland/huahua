package top150.array;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150
public class FindtheIndexoftheFirstOccurrenceinaString {

    public int strStr(String haystack, String needle) {


        //return slow(haystack , needle);
        return fast(haystack , needle);
    }


    public int slow(String haystack, String needle)
    {

        int startIndex = -1;
        for( int haystackIndex = 0 ; haystackIndex <= haystack.length()- needle.length(); haystackIndex++){
            boolean mismatch = false ;
            for(int needleIndex = 0 ; needleIndex < needle.length() ; needleIndex++){
                if(haystack.charAt(haystackIndex+needleIndex) != needle.charAt(needleIndex)){
                    mismatch = true ;
                    break;
                }
            }
            if (!mismatch) {
                startIndex = haystackIndex ;
                break;
            }
        }

        return startIndex ;
    }

    public int fast(String haystack, String needle){
        int[]  firstOccurIndex = new int[26];

        for(int index = 0 ; index < firstOccurIndex.length ; index++){
            firstOccurIndex[index] = -1 ;
        }

        for(int index = 0 ; index < needle.length() ; index++){
            if(firstOccurIndex[needle.charAt(index) - 'a'] < 0){
                firstOccurIndex[needle.charAt(index) - 'a'] = index ;
            }
        }

        int haystackIndex = 0 ;
        while( haystackIndex  <= haystack.length()- needle.length()){
            boolean mismtach = false ;
            for(int index = 0 ; index < needle.length() ; index++ ){
                if(haystack.charAt(haystackIndex+index) != needle.charAt(index)){
                    mismtach= true ;
                    if(firstOccurIndex[haystack.charAt(haystackIndex+index)-'a'] < 0 ){
                        haystackIndex += index+1;
                        break;
                    }


                    haystackIndex += index ;
                    while(haystackIndex  < haystack.length()) {
                        int nextPosIndex = haystackIndex + 1;
                        while (nextPosIndex < haystack.length()  && haystack.charAt(nextPosIndex) != needle.charAt(index)) {
                            nextPosIndex++;
                        }

                        haystackIndex = nextPosIndex - firstOccurIndex[needle.charAt(index) - 'a'];
                        break;
                    }
                    break;
                }
            }

            if(!mismtach) break;

        }

        return haystackIndex <= haystack.length()- needle.length() ? haystackIndex: -1;
    }

    public static void main(String[] args){
        FindtheIndexoftheFirstOccurrenceinaString findtheIndexoftheFirstOccurrenceinaString = new FindtheIndexoftheFirstOccurrenceinaString();
        System.out.println(findtheIndexoftheFirstOccurrenceinaString.fast("mississippi" , "issip"));
        //System.out.println(findtheIndexoftheFirstOccurrenceinaString.strStr("leetcode" , "leeto"));

    }
}
