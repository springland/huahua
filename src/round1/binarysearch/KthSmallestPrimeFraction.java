package round1.binarysearch;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/
 *
 *   [ 1  , 2  ,3  , 5  , 7]
 *
 *   1/2  1/3  1/5    1/7
 *        2/3  2/5    2/7
 *             3/5    3/7
 *                    5/7
 *
 *   layer 1 :  [1/7]
 *   layer 2 :  [1/5 , 2/7]
 *   layer 3: [1/3 , 2/5 , 3/7]
 *   layer 4: [1/2 , 2/3 , 3/5 , 5/7]
 *
 *   m = size-1 = 4  , look back 4 , 3 , 2 , 1
 *
 *
 *   1,7,23,29,47
 *
 *   1/7    1/23  1/29   1/47
 *          7/23  7/29   7/47
 *                23/29  23/47
 *                        29/47
 *
 *    It does not work for this case , 23/47 at layer 3 is greater than 1/7 and 7/23 at layer 4
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        //return brutalForce(arr , k);
        return binarySearch(arr , k);

    }

    public int[] brutalForce(int[] arr , int k)
    {
        PriorityQueue<int[]>  pq = new PriorityQueue<>((a , b) -> a[0]*b[1] - b[0]*a[1]);

        for(int i = 0 ; i < arr.length-1 ; i++)
        {
            for(int j = i+1 ; j < arr.length ; j++){
                int[] pair = new int[2];
                pair[0] = arr[i];
                pair[1] = arr[j];
                pq.offer(pair);
            }
        }

        int count = 0 ;
        int[] kth = null;

        while(count < k){
            count++;
            kth = pq.poll();
        }
        return kth ;
    }
    public int[] binarySearch(int[] arr, int k)
    {
        final int n = arr.length;
        double l = 0;
        double r = 1.0;
        while (l < r) {
            double m = (l + r) / 2;
            double max_f = 0.0;
            int total = 0;
            int p = 0;
            int q = 0;
            for (int i = 0, j = 1; i < n - 1; ++i) {
                while (j < n && arr[i] > m * arr[j]) ++j;
                if (n == j) break;
                total += (n - j);
                final double f = (double)arr[i] / arr[j];
                if (f > max_f) {
                    p = i;
                    q = j;
                    max_f = f;
                }
            }
            if (total == k)
                return new int[]{arr[p], arr[q]};
            else if (total > k)
                r = m;
            else
                l = m;
        }
        return new int[] {};
    }


    public static void main(String args[]){
        KthSmallestPrimeFraction kth = new KthSmallestPrimeFraction();

        int[] nums = new int[] {1,7,23,29,47};


        int[] ans = kth.kthSmallestPrimeFraction(nums , 8);
        System.out.println(ans[0] + " , " + ans[1]);

    }
}
