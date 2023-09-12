package top150.hashmap;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int ans = 0 ;

        Map<Integer , List<Integer>>  map = new HashMap<>();
        Set<Integer> processed = new HashSet<>();
        for(int index = 0 ; index < nums.length ; index++){
            List<Integer> headList = null;

            List<Integer> tailList = null ;


            if(!processed.add(nums[index])){
                continue;
            }
            if(map.containsKey(nums[index]-1)){
                headList = map.get(nums[index]-1);
            }

            if(map.containsKey(nums[index]+1)){
                tailList = map.get(nums[index]+1);
            }

            if(headList != null && tailList != null){

                List<Integer>  merged = new ArrayList<>();
                merged.addAll(headList);
                merged.add(nums[index]);
                merged.addAll(tailList);

                map.remove(headList.get(headList.size()-1));
                map.remove(tailList.get(0));
                map.put(merged.get(0) , merged);
                map.put(merged.get(merged.size()-1) , merged);
            }
            else if (headList != null){

                int tail = headList.get(headList.size()-1);

                map.remove(tail);
                headList.add(nums[index]);
                map.put(headList.get(0) , headList);
                map.put(headList.get(headList.size() -1) , headList);
            }
            else if( tailList != null){

                int head = tailList.get(0);
                map.remove(head);
                tailList.add(0 , nums[index]);
                map.put(tailList.get(0) , tailList);
                map.put(tailList.get(tailList.size()-1) , tailList);
            }
            else{
                List<Integer>  list = new ArrayList<>();
                list.add(nums[index]);
                map.put(nums[index] , list);
            }

        }


        for(List<Integer> value : map.values()){
            if(value.size() > ans){
                ans = value.size();
            }
        }
        return ans ;
    }


    public static void main(String[] args){
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println( longestConsecutiveSequence.longestConsecutive(new int[] {1,2,0,1}));
    }
}
