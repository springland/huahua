
package round1.twopointers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0 ;
        }

        int atMostK = atMostK(nums , k ) ;
        int atMostK1 = atMostK(nums , k-1);

        int ans = atMostK - atMostK1 ;
        return ans ;
    }

    public int atMostK(int nums[] , int k)
    {
        Map<Integer , AtomicInteger> numbersMap =  new HashMap<>();

        int leftIndex = 0;
        int rightIndex = 0;

        int ans = 0 ;
        for( rightIndex = 0 ; rightIndex < nums.length ; rightIndex++){

            AtomicInteger  count = null;

            if (numbersMap.containsKey(nums[rightIndex])) {
                count = numbersMap.get(nums[rightIndex]);
            } else {
                count = new AtomicInteger(0);
                numbersMap.put(nums[rightIndex], count);
            }

            count.incrementAndGet();

            while(numbersMap.size() > k){
                count = numbersMap.get(nums[leftIndex]);
                if(count.decrementAndGet() == 0){
                    numbersMap.remove(nums[leftIndex]);
                }
                leftIndex++;
            }
            ans += rightIndex - leftIndex + 1;

        }

        return ans ;

    }

    public static void main(String args[]){
        int[] nums = null;
        SubarraysWithKDifferentIntegers k = new SubarraysWithKDifferentIntegers();
        nums = new int[] {1,2,1,2,3};
        System.out.println(k.subarraysWithKDistinct(nums , 2));

        nums = new int[] {1,2,1,3,4};
        System.out.println(k.subarraysWithKDistinct(nums , 3));

    }
}
