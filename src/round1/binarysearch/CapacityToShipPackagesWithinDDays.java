package round1.binarysearch;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {




        int  minCapacity = 1; ;
        int  maxCapacity  = IntStream.of(weights).sum();

        while(minCapacity < maxCapacity){

            int midCapacity = minCapacity + (maxCapacity - minCapacity)/2 ;



            int shippingDays = calculateShippingDays(weights , midCapacity );

            if(shippingDays <= days)
            {
                maxCapacity = midCapacity;
            }
            else {
                minCapacity = midCapacity+1;

            }
        }


        return minCapacity ;
    }

    protected int calculateShippingDays(int weights[] , int capacity)
    {
        int totalWeights = 0;
        int days = 0;
        for(int index = 0 ; index < weights.length ; index++)
        {
            if(weights[index] > capacity)
            {
                return Integer.MAX_VALUE;
            }
            if(totalWeights + weights[index] <= capacity)
            {
                totalWeights += weights[index];
            }
            else {
                totalWeights = weights[index] ;
                days ++;
            }
        }
        if(totalWeights > 0)
        {
            days ++;
        }
        return days ;
    }

    public static void main(String args[])
    {

        CapacityToShipPackagesWithinDDays shipping = new CapacityToShipPackagesWithinDDays();

        int[] weights ;

        weights = new int[] {1,2,3,4,5,6,7,8,9,10} ;
        System.out.println(shipping.shipWithinDays(weights ,5 ));

        weights = new int[] {3,2,2,4,1,4};
        System.out.println(shipping.shipWithinDays(weights ,3 ));

        weights = new int[] {1,2,3,1,1};
        System.out.println(shipping.shipWithinDays(weights ,4 ));

        weights = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipping.shipWithinDays(weights ,10 ));

    }
}
