package gucheng.divideandconquer;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int k) {

        //return pq(points , k);
        return divideAndConcquer(points , 0 , points.length-1 , k);
    }


    public int[][] divideAndConcquer(int[][] points , int beginIndex  , int endIndex , int k){

        if(endIndex - beginIndex +1 <= k){
            int[][] answers= Arrays.copyOfRange(points , beginIndex , endIndex+1);
            Arrays.sort(answers ,(a , b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1] );
            return answers ;
        }

        int middle = beginIndex + ( endIndex - beginIndex)/2 ;

        int[][] left = divideAndConcquer(points , beginIndex , middle , k);
        int[][] right = divideAndConcquer(points , middle+1 , endIndex , k);

        int[][] answer  ;
        if(left.length + right.length < k){
            answer = new int[left.length + right.length][2];
        }
        else{
            answer = new int[k][2];
        }

        int leftIndex = 0 ;
        int rightIndex = 0 ;
        int answerIndex = 0 ;

        while(leftIndex < left.length && rightIndex < right.length && answerIndex < answer.length){
            if(left[leftIndex][0] * left[leftIndex][0] + left[leftIndex][1] * left[leftIndex][1] < right[rightIndex][0]*right[rightIndex][0] + right[rightIndex][1] * right[rightIndex][1]){
                answer[answerIndex] = left[leftIndex];
                leftIndex++;
            }
            else{
                answer[answerIndex] = right[rightIndex];
                rightIndex++;
            }
            answerIndex++;
        }

        while(leftIndex < left.length && answerIndex < answer.length){
            answer[answerIndex] = left[leftIndex];
            leftIndex++;
            answerIndex++;
        }

        while(rightIndex < right.length && answerIndex < answer.length){
            answer[answerIndex] = right[rightIndex];
            rightIndex++;
            answerIndex++;
        }

        return answer ;
    }
    public int[][] pq(int[][] points , int k){
        int[][]   answer = new int[k][2];

        PriorityQueue<int[]>  pq = new PriorityQueue<>( ( a , b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        for(int index = 0 ; index < points.length ; index++){
            pq.offer(points[index]);
        }

        int index = 0;
        while( index < k){
            int[] point = pq.poll();
            answer[index] = point ;
            index++;
        }

        return answer ;

    }


    public static void main(String[] args){
        KClosestPointstoOrigin k = new KClosestPointstoOrigin();
        int[][] points = new int[][] {{1,3}, {-2,2}, {2,-2}};

        int[][] answer = null;
        answer = k.kClosest(points , 2);
        for(int index = 0 ; index < answer.length ; index++){
            System.out.println("(" + answer[index][0] + "," + answer[index][1] + ")");
        }

    }
}
