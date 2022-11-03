package round1.divideandconquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * //Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {


        //return hashmap(nums);
        //return sorting(nums);
        //return pivotal(nums);
        return boyerMooreVote(nums);
    }

    public int hashmap(int[] nums){
        // space O(n) , time O(n)
        Map<Integer , AtomicInteger>  numbersMap = new HashMap<>();
        for(int index = 0 ; index < nums.length ; index++){
            AtomicInteger count = numbersMap.get(nums[index]);

            if(count == null){
                count = new AtomicInteger(0);
                numbersMap.put(nums[index] , count);
            }

            if(count.incrementAndGet() > nums.length/2){
                return nums[index];
            }
        }
        return 0 ;
    }

    public int sorting(int[] nums){

        // space O(1) , time O(nlogn)
        Arrays.sort(nums);

        return nums[nums.length/2];


    }

    public int pivotal(int nums[]){
        // space O(1) time(O(n))

        // because the description says the answer exists , then we can use the last element as the pivotal value to move all of the
        // elmenets smaller than it to left and bigger than it to right ( like quick sort)
        // then return the middle value

        // The quick sort pivotal does not work. This one requires the pivotal point is the middle of the array
        // quick pivotal point can be at any place. Then { 3 , 2 , 3 } stop working


        return 0;

    }

    public int boyerMooreVote( int nums[])
    {
        int ans = nums[0];
        int count = 1;

        for(int index = 1 ; index < nums.length ; index++){

            if(ans != nums[index]){
                count -- ;
            }
            else{
                count ++;
            }

            if(count == 0){
                ans =  nums[index];
                count = 1;
            }
        }

        return ans ;
    }

    public static void main(String[] args){
        int nums[] = null;
        MajorityElement majorityElement = new MajorityElement();

        nums = new int[] { 3 , 2 , 3 };
        //System.out.println(majorityElement.majorityElement(nums));

        nums = new int[] { 3 , 3 , 4 };
        System.out.println(majorityElement.majorityElement(nums));

    }
}
