package top150.matrix;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer>  ans = new ArrayList<>();

        int rowSize = matrix.length ;
        int colSize = matrix[0].length;

        int direction = 0 ;
        int rowIndex = 0 ;
        int colIndex = 0 ;

        int left = 0 ;
        int right = colSize -1 ;
        int top = 1 ;
        int bottom = rowSize-1 ;
        boolean changedirection = false ;

        ans.add(matrix[0][0]);
        while(ans.size() < rowSize * colSize){


            switch(direction){
                case 0:
                    if(changedirection){
                        right --;
                        left ++ ;
                        top ++ ;
                        bottom -- ;
                    }
                    if(colIndex +1 <= right){
                        changedirection = false;
                        colIndex++;
                    }
                    else{
                        changedirection = true ;
                    }
                    break;
                case 1:
                    if(rowIndex +1 <= bottom){
                        changedirection = false;
                        rowIndex++;
                    }
                    else{
                        changedirection = true ;
                    }
                    break;
                case 2:
                    if(colIndex-1 >= left){
                        changedirection = false;
                        colIndex--;

                    }
                    else{
                        changedirection = true ;
                    }
                    break;
                case 3:

                    if(rowIndex -1 >= top){
                        changedirection = false;
                        rowIndex --;

                    }
                    else{
                        changedirection = true ;
                    }
                    break;
            }

            if(changedirection){
                direction = (direction+1)%4;
            }
            else{
                ans.add(matrix[rowIndex][colIndex]);
            }

        }

        return ans ;

    }

    public static void main(String [] args){

        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
