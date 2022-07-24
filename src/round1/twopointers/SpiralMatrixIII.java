package round1.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class SpiralMatrixIII {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        // 1 -> 9 -> 25 -> 49 -> 81
        //
        List<int[]> ans = new ArrayList<>();


        int count = 0 ;
        int distance = 1 ;
        int row = rStart ;
        int col = cStart ;

        int[] position = new int[2];
        position[0] = row;
        position[1] = col;
        ans.add(position);
        count++;


        while(count < rows * cols){

            int step = 0 ;
            int direction = 0 ;
            while(step  < (2*distance+1) * (2*distance+1) -1) {

                position = new int[2];

                // left -> down -> right -> up -> left
                switch(direction){
                    case 0:  // left
                        if(cols +1 == cols){

                        }
                        else{

                        }
                        break;
                    case 1: // down
                        break;
                    case 2: // right
                        break;
                    case 3: // up
                        break;
                }

            }

            distance ++ ;

        }
        return null;
    }
}
