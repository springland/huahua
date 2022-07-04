package round1.binarysearch;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 */
public class KthSmallestNumberinMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int min = 1 ;
        int max = m*n ;

        while(min < max)
        {
            int middle = min + (max-min)/2;
            int count = calculateLessnThanCount(m , n , middle);

            if(count >= k)
            {
                max = middle;
            }
            else{
                min = middle+1;
            }
        }
        return max ;

    }

    public int calculateLessnThanCount(int m , int n , int cap)
    {
        int count = 0 ;
        for(int index = 1  ; index <= n ; index++)
        {
            count += cap / index > m ? m: cap/index  ;
        }

        return count ;
    }
    public static void main(String args[])
    {
        KthSmallestNumberinMultiplicationTable kth = new KthSmallestNumberinMultiplicationTable();

        System.out.println(kth.findKthNumber(5 , 5 , 6));
    }
}
