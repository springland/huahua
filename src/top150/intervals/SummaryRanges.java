package top150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String>  ans = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return ans ;
        }
        Arrays.sort(nums);

        int head = nums[0];

        int tail = nums[0];

        for(int index = 1 ; index < nums.length ; index++){

            if(nums[index] == tail +1){
                tail = nums[index];

            }
            else{
                if(head == tail){
                    ans.add(String.valueOf(head));
                }
                else{
                    ans.add(String.format("%d->%d" , head , tail));
                }

                head = nums[index];
                tail = nums[index];

            }
        }

        if(head == tail){
            ans.add(String.valueOf(head));
        }
        else{
            ans.add(String.format("%d->%d" , head , tail));
        }

        return ans ;
    }

    public static void main(String[] args){
        SummaryRanges summaryRanges = new SummaryRanges();

        int[] nums = new int[] {0,1,2,4,5,7} ;
        nums = new int[0];

        List<String>  ans = summaryRanges.summaryRanges(nums);
        System.out.println(ans);
    }
}

