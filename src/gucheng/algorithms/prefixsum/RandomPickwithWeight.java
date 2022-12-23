package gucheng.algorithms.prefixsum;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomPickwithWeight {

    int[] sums ;
    Random rand = new Random();

    public RandomPickwithWeight(int[] w) {

        sums = new int[w.length+1];

        for(int index = 1 ; index < sums.length ; index++){
            sums[index] = w[index-1] + sums[index-1];

        }

    }

    public int pickIndex() {

        int value = rand.nextInt(sums[sums.length-1])+1;
        for(int index = 1 ; index < sums.length ; index++ ){

            if(value > sums[index-1] && value <= sums[index]){
                return index-1 ;
            }
        }
        return  -1;
    }
}
