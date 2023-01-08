package leetcodedaily;

//https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int[] gasRemainder = new int[gas.length];

        int sum = 0 ;
        int maxIndex = 0 ;
        for(int index = 0 ; index < gas.length ; index++){
            gasRemainder[index] = gas[index] - cost[index];
            sum += gasRemainder[index];
            if(gasRemainder[maxIndex] < gasRemainder[index]) maxIndex = index ;
        }
        if(sum < 0){
            return -1 ;
        }
        for(int index = maxIndex ; index < maxIndex + gas.length ; index++){

            int travelIndex = index%gas.length ;
            if(gasRemainder[travelIndex] < 0) continue ;


            sum = gasRemainder[travelIndex];

            travelIndex =(travelIndex+1)%gas.length;
            while(sum >= 0 && travelIndex != index % gas.length){
                sum += gasRemainder[travelIndex];
                travelIndex =(travelIndex+1)%gas.length;
            }
            if(sum >= 0 && travelIndex == index%gas.length) return travelIndex;
        }
        return -1 ;

    }

    public static void main(String[] args){
        int[] gas;
        int[] cost ;

        gas = new int[] {2,3,4};
        cost = new int[] {3 ,4 , 3};

        GasStation gasStation = new GasStation();

     //   System.out.println(gasStation.canCompleteCircuit(gas , cost));

        gas = new int[]{2,0,1,2,3,4,0};
        cost = new int[] {0,1,0,0,0,0,11};
        System.out.println(gasStation.canCompleteCircuit(gas , cost));
    }
}
