package gucheng.algorithms.prefixsum;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/matrix-block-sum/
public class MatrixBlockSum {
        /*
             1   2    3
             4   5    6
             7   8    9

             A   B

             C   D

             SUM(ABCD) = SUM(AC ) + SUM(AB) -SUM(A) + D


             k = 1

             12  21   16
             27  45   33
             24  39   28

            k = 2
            45    45    45
            45    45    45
            45    45    45

            sums  sum[m ,n] = mat[m][n] + sum[m-1 , n] + sum[m , n-1]
            1    3     6
            5    13    25
            13   34    68
         */


    public int[][] matrixBlockSum(int[][] mat, int k) {


        int[][] ans = new int[mat.length][mat[0].length];


        int[][] blockSums = calcBlockSum(mat);

        for( int rowIndex = 0 ; rowIndex < mat.length ; rowIndex++){
            for(int colIndex = 0 ; colIndex < mat[0].length ; colIndex++){
                ans[rowIndex][colIndex] = calcBlockSum(rowIndex+1 ,  colIndex+1 , k , blockSums  );
            }
        }
        return ans;
    }

    public int calcBlockSum(int rowIndex , int colIndex , int k , int[][] blockSums)
    {
        int blockSum = 0 ;

        // top , bottom are row
        // left , right are col
        int top = Math.max(0 , rowIndex - k-1);
        int bottom = Math.min(blockSums.length-1 , rowIndex+k);
        int left = Math.max(0 , colIndex -k-1);
        int right = Math.min(blockSums[0].length-1 , colIndex +k);


        //  A (top , left)  B ( top , right)
        //  C (bottom  , left) D ( bottom , right)
        //  D = SUM(ABCD) - SUM(AC) - SUM(AB) + SUM(A)

        blockSum = blockSums[bottom][right] - blockSums[bottom][left] - blockSums[top][right] + blockSums[top][left];

        return blockSum ;

    }
    public int[][] calcBlockSum(int[][] mat){
        int[][] blockSum = new int[mat.length+1][mat[0].length+1];

        //blockSum[0][0] = mat[0][0];

//        for(int index = 1 ; index <= mat.length; index++ ){
//            blockSum[0][index] = blockSum[0][index-1] + mat[0][index];
//            blockSum[index][0] = blockSum[index-1][0] + mat[index][0];
//        }
        for(int rowIndex = 1 ; rowIndex <= mat.length ; rowIndex++){
            for(int colIndex = 1 ; colIndex <= mat[0].length; colIndex++ ){

                    blockSum[rowIndex][colIndex] =
                            blockSum[rowIndex - 1][colIndex] + blockSum[rowIndex][colIndex - 1]
                                    + mat[rowIndex -1 ][colIndex-1 ] - blockSum[rowIndex - 1][colIndex - 1];

            }
        }


        return blockSum ;
    }

    public static void printMatrix(int[][] mat){
        for(int index = 0 ; index < mat.length ; index++){
            System.out.println(IntStream.of(mat[index]).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }
    }
    public static void main(String args[]){

        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        int[][] blockSums = matrixBlockSum.matrixBlockSum(mat , 1);
        printMatrix(blockSums);

        blockSums = matrixBlockSum.matrixBlockSum(mat , 2);
        printMatrix(blockSums);


    }
}
