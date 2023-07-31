package top150.matrix;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        //solution1(matrix);
        solution2(matrix);

    }


    public void solution1(int[][] matrix){
        boolean colFlag[] = new boolean[matrix[0].length];
        boolean rowFlag[] = new boolean[matrix.length];

        for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){
            for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
                if(matrix[rowIndex][colIndex] == 0){
                    rowFlag[rowIndex] = true ;
                    colFlag[colIndex] = true ;
                }
            }
        }

        for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){
            if(rowFlag[rowIndex]){
                for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
                    matrix[rowIndex][colIndex] = 0 ;
                }
            }
        }

        for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
            if(colFlag[colIndex]){
                for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){
                    matrix[rowIndex][colIndex] = 0 ;
                }
            }
        }

    }

    public void solution2(int[][] matrix){
        for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){

            for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
                if(matrix[rowIndex][colIndex] == 0){
                    matrix[rowIndex][0] = 0 ;
                    matrix[0][colIndex] = 0 ;
                }
            }

        }

        for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){
            if(matrix[rowIndex][0] == 0){
                for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
                    matrix[rowIndex][colIndex] = 0 ;
                }
            }
        }

        for(int colIndex = 0 ; colIndex < matrix[0].length ; colIndex++){
            if(matrix[0][colIndex] == 0){
                for(int rowIndex = 0 ; rowIndex < matrix.length ; rowIndex++){
                    matrix[rowIndex][colIndex] = 0 ;
                }
            }
        }
    }

    public static void main(String[] args){

        int[][] matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
    }
}
