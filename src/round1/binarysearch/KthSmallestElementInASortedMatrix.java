package round1.binarysearch;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {


        // go with priority queue , did not do it in binary search way

        // o(n) space , speed is n*n*(log(n)) ,
        //
        // check KthSmallestNumberinMultiplicationTable , it is using binary search , O(2n) extra space

        PriorityQueue<int[]> heap = new PriorityQueue<>( (a , b) ->  a[0] - b[0] );
        int length = matrix.length;
        for(int index = 0 ; index < matrix.length ; index++)
        {
            heap.offer( new int[ ]{ matrix[index][0] , index , 0});
        }
        int count = 0 ;
        while(!heap.isEmpty() && count < k)
        {
            int[] data  = heap.poll();
            count ++;
            if(count == k)
            {
                return data[0];
            }
            if(data[2]+1 < length)
            {
                heap.offer(new int[] { matrix[data[1]][data[2]+1] , data[1] , data[2]+1});
            }
        }


        return 0 ;

    }
    public static void main(String[] args)
    {
        int[][] matrix ;
        matrix = new int[][] { new int[] {-5}};

        KthSmallestElementInASortedMatrix kth = new KthSmallestElementInASortedMatrix();
        System.out.println(kth.kthSmallest(matrix , 1));

        matrix = new int[][] {
                new int[] {1 , 5, 9},
                new int[] {10 , 11, 13},
                new int[] {12 , 13, 15}
        };
        System.out.println(kth.kthSmallest(matrix , 9));
    }



}
