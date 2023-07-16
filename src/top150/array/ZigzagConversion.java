package top150.array;

// https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
public class ZigzagConversion {
    public String convert(String s, int numRows) {

        int numCols = 0 ;
        int length = s.length();
        if(numRows == 1) return s;

        if(numRows == 2){
            numCols = length/2 + (length%2 == 0 ?  0:1);
        }
        else {
            while (length > 0) {
                numCols++;
                if ((numCols-1) % (numRows-1) == 0) {
                    length -= numRows;
                } else {
                    length--;
                }
            }
        }
        char[][] matrix = new char[numRows][numCols];

        int rowIndex = 0;
        int colIndex = 0;
        for(int index = 0 ; index < s.length() ; index++){
            char ch = s.charAt(index);
            matrix[rowIndex][colIndex] = ch ;
            if(colIndex % (numRows-1) == 0 ){

                rowIndex ++;
                if(rowIndex == numRows){
                    colIndex++;
                    rowIndex-=2;
                }
            }
            else{
                rowIndex--;
                colIndex++;
            }
        }


        StringBuilder sb = new StringBuilder();

        for(rowIndex = 0 ; rowIndex < numRows ; rowIndex++){
            for(colIndex = 0 ; colIndex < numCols ; colIndex++){
                if(matrix[rowIndex][colIndex] != 0){
                    sb.append(matrix[rowIndex][colIndex]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]){
        ZigzagConversion  zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers." , 3));
    }
}
