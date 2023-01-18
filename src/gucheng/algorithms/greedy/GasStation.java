package gucheng.algorithms.greedy;

// https://leetcode.com/problems/gas-station/
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int startIndex = -1 ;

        int totalGas = 0 ;
        int totalCost = 0 ;
        for(int index = 0 ; index < gas.length ; index++){
            totalCost += cost[index];
            totalGas += gas[index];
        }

        if(totalGas < totalCost){
            return startIndex ;
        }

        startIndex = -1 ;
        int index = 0 ;
        int remainder = 0 ;
        while(index != startIndex){

            remainder += gas[index] - cost[index];
            if(remainder < 0){
                remainder = 0 ;
                startIndex = -1 ;
            }
            else if(startIndex == -1){
                startIndex = index ;
            }
            index = (index+1)%gas.length ;

        }


        return startIndex ;

    }
}
