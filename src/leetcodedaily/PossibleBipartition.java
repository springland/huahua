package leetcodedaily;

import java.util.*;

// https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        Set<Integer>[]  sets = new HashSet<>[2];

        int[]  allocations = new int[n];
        for(int index = 0 ; index < n ; index++){
            allocations[index] = -1;
        }
        int curSet = 0 ;
        for(int index =  0 ; index < dislikes.length ; index++){
            int[] dislike = dislikes[index];
            if(allocations[dislike[0]] == -1){
                allocations[dislike[0]] = curSet ;
            }
        }

        return true ;
    }

    public static void main(String[] args){
        // [5 , 6] [1 ,2 ] [2 , 3] [ 3, 1] is false , it is an unlinked graph

        // [1 , 2] [ 1, 3] [2 , 4] is true

        int[][] dislikes ;
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        dislikes = new int[][] {{1,2},{1,3},{2,4}};

        System.out.println(possibleBipartition.possibleBipartition(4 , dislikes));

        dislikes = new int[][] {{1,2},{1,3},{2,3}};
        System.out.println(possibleBipartition.possibleBipartition(3 , dislikes));

        dislikes = new int[][] {{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(possibleBipartition.possibleBipartition(5 , dislikes));

        dislikes = new int[][] {{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}} ;

        // This is true
        dislikes = new int[][] {{1 , 2} , {2 , 1}};
        System.out.println(possibleBipartition.possibleBipartition(2 , dislikes));

    }
}
