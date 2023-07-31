package top150.matrix;

// https://leetcode.com/problems/rotate-image/?envType=study-plan-v2&envId=top-interview-150
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public static void main(String[] args){

        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println(matrix);

    }

}
