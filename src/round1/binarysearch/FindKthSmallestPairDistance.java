package round1.binarysearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {


        Arrays.sort(nums);

        int min = 0 ;
        int max = nums[nums.length-1] - nums[0];
        while(min < max) {

            int middle = min + (max - min)/2 ;

            int lessThanCount = lessThan(nums , middle);
            if( lessThanCount >= k){

                max = middle ;
            }
            else{
                min = middle+1 ;
            }
        }


        return max ;
    }

    public int lessThan(int[] nums , int target ){



        int total = 0;


        for ( int i = 0 ; i < nums.length-1 ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j] - nums[i] <= target){
                    total ++;
                }
            }

        }
        return total;
    }

    public int binarySearchFindLast(int[] nums , int beginIndex , int target )
    {
        int endIndex = nums.length-1 ;
        while(beginIndex < endIndex)
        {
            int middleIndex = beginIndex + (endIndex- beginIndex+1)/2;

            if(nums[middleIndex] <= target)
            {
                beginIndex = middleIndex;
            }
            else{

                endIndex = middleIndex-1;

            }
        }
        return beginIndex ;
    }

    public int binarySearchFindFirst(int[] nums , int beginIndex , int target )
    {
        int endIndex = nums.length-1 ;
        while(beginIndex < endIndex)
        {
            int middleIndex = beginIndex + (endIndex- beginIndex)/2;

            if(nums[middleIndex] >= target)
            {
                endIndex = middleIndex;
            }
            else{

                beginIndex = middleIndex+1;

            }
        }
        return beginIndex ;
    }



    public static void main(String args[]){
        int nums [] ;
        FindKthSmallestPairDistance kth = new FindKthSmallestPairDistance();
        nums = new int[] { 9,10,7,10,6,1,5,4,9,8  };

        Arrays.sort(nums);
        System.out.println(kth.smallestDistancePair(nums , 18));

        //nums = new int[] { 2 , 4, 4, 4, 6};
        //System.out.println(kth.binarySearchFindLast(nums , 0,4));
        //System.out.println(kth.binarySearchFindFirst(nums , 0 , 4));

        List<Integer>  pairDistances = new ArrayList<>();

        for(int index = 0 ; index < nums.length-1 ; index++)
        {
            for(int j = index+1; j < nums.length ; j++)
            {
                pairDistances.add(nums[j] - nums[index]);
            }
        }

        Collections.sort(pairDistances);
        System.out.println(pairDistances.stream().map( t-> String.valueOf(t)).collect(Collectors.joining(",")));


    }
}
