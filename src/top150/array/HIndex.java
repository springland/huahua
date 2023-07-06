package top150.array;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/?envType=study-plan-v2&envId=top-interview-150
public class HIndex {
    public int hIndex(int[] citations) {

        return solution1(citations);
    }

    public int solution1(int[] citations){

        Arrays.sort(citations);

        int hIndex = 0 ;
        for(int index = citations.length-1 ; index >= 0 ; index--){
            if(citations[index] >= citations.length - index){
                hIndex ++;
            }
            else{
                break;
            }
        }

        return hIndex ;

    }
}
