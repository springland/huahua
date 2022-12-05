package gucheng.divideandconquer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/majority-element/
public class MajorElements {
    public int majorityElement(int[] nums) {

        int[] result = majorityElement(nums , 0  , nums.length-1);
        return result[0];
    }

    public int[] majorityElement(int[] nums , int beginIndex , int endIndex){

        if(beginIndex == endIndex){
            return new int[] { nums[beginIndex] , 1 , 0 , 0};
        }
        else if ( beginIndex +1 == endIndex){
            if(nums[beginIndex] == nums[endIndex]){
                return new int[] { nums[beginIndex] , 2 , 0 , 0};
            }
            else{
                return new int[] { nums[beginIndex] , 1 , nums[endIndex] , 1};
            }
        }

        int middle =  (beginIndex + endIndex)/2;

        int[] left = majorityElement(nums , beginIndex , middle);
        int[] right = majorityElement(nums , middle+1 , endIndex);

        return merge(left , right);
    }

    protected int[] merge( int[] left , int[] right){

        Map<Integer , Integer> valuesMap = new HashMap<>();
        valuesMap.put(left[0] , valuesMap.getOrDefault(left[0] , 0)+left[1]);
        valuesMap.put(left[2] , valuesMap.getOrDefault(left[2] , 0)+left[3]);
        valuesMap.put(right[0] , valuesMap.getOrDefault(right[0] , 0)+right[1]);
        valuesMap.put(right[2] , valuesMap.getOrDefault(right[2] , 0)+right[3]);

        PriorityQueue<Integer>  pq = new PriorityQueue<>( ( a , b) -> b-a) ;
        valuesMap.values().stream().forEach(pq::offer);

        int firstValue = pq.poll();
        int firstKey = Integer.MIN_VALUE;
        for(Map.Entry<Integer , Integer> entry :valuesMap.entrySet()){
            if(entry.getValue() == firstValue){
                firstKey = entry.getKey();
                break;
            }
        }
        int[] merged = new int[4];
        merged[0] = firstKey ;
        merged[1] = firstValue ;

        valuesMap.remove(firstKey);
        if(pq.isEmpty()){
            return merged;
        }

        int secondValue = pq.poll();
        int secondKey = Integer.MIN_VALUE;
        for(Map.Entry<Integer , Integer> entry :valuesMap.entrySet()){
            if(entry.getValue() == secondValue){
                secondKey = entry.getKey();
                break;
            }
        }

        merged[2] = secondKey ;
        merged[3] = secondValue ;

        return merged ;

    }

    public static void main(String[] args){

        int[] nums = new int[] { 2  , 2  ,1 ,1 , 1,  2 , 2};
        MajorElements majorElements = new MajorElements();
        System.out.println(majorElements.majorityElement(nums));
    }
}
