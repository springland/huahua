package top150.array;

//https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int remainder = 0 ;
        for(int index = 0 ; index < gas.length ; index++){
            remainder += gas[index] - cost[index];
        }

        if(remainder < 0){
            return -1 ;
        }

        int beginIndex = 0 ;

        remainder = 0 ;
        int index = 0;
        while(true){

            remainder += gas[index] - cost[index];
            if(remainder >= 0){
                index= (index+1)%gas.length;
                if(index == beginIndex) break;
            }
            else{
                beginIndex = ++index;
                remainder = 0;
            }
        }

        return beginIndex ;
    }

    public static void main(String[] args){
        int[] gas = new int[] {5 , 8 , 2 , 8};
        int[] cost = new int[] {6 , 5 , 6 , 6};
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas , cost));
    }
}
