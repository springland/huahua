package gucheng.algorithms.prefixsum;

// https://leetcode.com/problems/range-sum-query-2d-immutable/
public class NumMatrix {

    int[][]  sums  ;
    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length+1][matrix[0].length+1];
        for(int rowIndex = 1 ; rowIndex < sums.length ; rowIndex++){
            for(int colIndex = 1 ; colIndex < sums[0].length ; colIndex++){
                sums[rowIndex][colIndex] = sums[rowIndex][colIndex-1]
                        + sums[rowIndex-1][colIndex] + matrix[rowIndex-1][colIndex-1] - sums[rowIndex-1][colIndex-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];

    }
}
