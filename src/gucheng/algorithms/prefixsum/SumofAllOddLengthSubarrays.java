package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class SumofAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {

        int[] sums = new int[arr.length+1];

        for(int index = 1 ; index < sums.length ; index++){
            sums[index] = sums[index-1] + arr[index-1];
        }
        int ans = 0 ;
        for(int length = 1 ; length <= arr.length ; length += 2){
            for(int index = length ; index <sums.length  ; index++){
                ans += sums[index] - sums[index - length];
            }
        }

        return ans ;
    }
}
