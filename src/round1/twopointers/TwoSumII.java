package round1.twopointers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int beginIndex = 0 ;
        int endIndex = numbers.length-1;
        while(beginIndex < endIndex){
            if(numbers[beginIndex] + numbers[endIndex] < target){
                beginIndex++;
            }
            else if (numbers[beginIndex] + numbers[endIndex] > target)
            {
                endIndex-- ;
            }
            else{
                return new int[] {beginIndex+1 , endIndex+1};
            }
        }

         return new int[] {beginIndex+1 , endIndex+1};
    }

    public static void main(String args[]){
        TwoSumII twoSumII = new TwoSumII();
        int[] numbers = null;

        numbers = new int[] {2,7,11,15};
        int[] ans ;
        ans = twoSumII.twoSum(numbers , 9);
        System.out.println(IntStream.of(ans).mapToObj(t-> String.valueOf(t)).collect(Collectors.joining(",")));

        numbers = new int[] {2 , 3 ,4};
        ans = twoSumII.twoSum(numbers , 6);
        System.out.println(IntStream.of(ans).mapToObj(t-> String.valueOf(t)).collect(Collectors.joining(",")));

        numbers = new int[] {-1 , 0};
        ans = twoSumII.twoSum(numbers , -1);
        System.out.println(IntStream.of(ans).mapToObj(t-> String.valueOf(t)).collect(Collectors.joining(",")));

    }
}
