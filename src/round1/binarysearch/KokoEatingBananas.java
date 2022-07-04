package round1.binarysearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);


        int min = 1;
        int max = piles[piles.length-1];

        while(min < max)
        {
            int speed = min + (max-min)/2 ;
            int time = eatTime(piles , speed);
            if(time <= h)
            {
                max = speed ;
            }
            else{
                min = speed+1;
            }
        }

        return min ;

    }


    public int eatTime(int[] piles , int eatSpeed)
    {
        int time = 0 ;

        for(int index = 0 ; index < piles.length ; index++)
        {
            time = time + (int) Math.ceil(piles[index]*1.0/eatSpeed);
        }
        return time ;

    }

    public static void main(String args[])
    {
        KokoEatingBananas eatingBananas = new KokoEatingBananas();
        int piles[] = new int[] {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184        };
        System.out.println(eatingBananas.minEatingSpeed(piles , 823855818));

      //  piles = new int[] {5};
      //  System.out.println(eatingBananas.minEatingSpeed(piles , 4));
    }
}

