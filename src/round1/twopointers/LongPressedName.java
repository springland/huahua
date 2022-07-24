package round1.twopointers;

import java.nio.charset.StandardCharsets;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {

        int nameIndex = 0 ;
        int typedIndex = 0 ;

        while(nameIndex  < name.length()  && typedIndex < typed.length()){

            if(name.charAt(nameIndex) == typed.charAt(typedIndex)){
                nameIndex++;
                typedIndex++;
            }
            else{
                if(typedIndex > 0 && typed.charAt(typedIndex) == typed.charAt(typedIndex-1)){
                    while(typedIndex < typed.length() && typed.charAt(typedIndex) == typed.charAt(typedIndex-1)){
                        typedIndex ++ ;
                    }
                    if(typedIndex == typed.length()){
                        return false ;
                    }
                }
                else{
                    return false ;
                }
            }
        }

        if(nameIndex < name.length()){
            return false ;
        }
        while(typedIndex < typed.length()){
            if(typed.charAt(typedIndex)!= typed.charAt(typedIndex-1) ){
                return false ;
            }
            typedIndex++;
        }
        return true ;

    }

    public static void main(String args[]){
        LongPressedName  longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex",  "aaleexa"));
        System.out.println(longPressedName.isLongPressedName("vtkgn",  "vttkgnn"));


    }
}
