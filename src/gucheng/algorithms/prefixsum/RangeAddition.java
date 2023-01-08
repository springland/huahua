package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/range-addition/
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {

        int[] attr = new int[length];

        int[] increments = new int[length];

        for(int index = 0 ; index < updates.length ; index++){

            increments[updates[index][0]] += updates[index][2];
            if(updates[index][1] < length-1){
                increments[updates[index][1]+1] -= updates[index][2];
            }
        }

        attr[0] = increments[0];
        for(int index = 1 ; index < length ; index++){
            attr[index] = attr[index-1] + increments[index];
        }

        return attr ;
    }


}
