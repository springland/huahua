package top150.matrix;

// https://leetcode.com/problems/valid-sudoku/?envType=study-plan-v2&envId=top-interview-150
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int index = 0 ; index < board.length ; index++){

            if(!isRowValid(board , index)) return false ;
            if(!isColValid(board , index)) return false ;
            if(!isBoxValid(board , index)) return false ;
        }
        return true ;
    }

    protected boolean isRowValid(char[][] board , int row){
        int[] chars = new int[9];

        boolean isValid = true ;
        for(int colIndex = 0 ; colIndex < board.length ; colIndex++){
            int index = board[row][colIndex] - '1';
            if(index >= 0 && index < 9) {
                if (chars[index] > 0) {
                    isValid = false;
                    break;
                } else {
                    chars[index] = 1;
                }
            }
        }
        return isValid;

    }

    protected boolean isColValid(char[][] board , int col){
        int[] chars = new int[9];
        boolean isValid = true ;

        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex++){
            int index = board[rowIndex][col] - '1';
            if(index >= 0 && index < 9) {
                if (chars[index] > 0) {
                    isValid = false;
                    break;
                } else {
                    chars[index] = 1;
                }
            }

        }
        return isValid;
    }

    protected boolean isBoxValid(char[][] board  , int box){

        int[] chars = new int[9];
        boolean isValid = true ;

        int startRow = (box/3)*3;
        int startCol = (box%3)*3 ;

        for(int rowIndex = startRow ; rowIndex < startRow +3 ; rowIndex++){
            for(int colIndex = startCol ; colIndex < startCol+3 ; colIndex++){
                int index = board[rowIndex][colIndex] - '1';
                if(index >= 0 && index < 9) {
                    if (chars[index] > 0) {
                        isValid = false;
                        break;
                    } else {
                        chars[index] = 1;
                    }
                }
            }
        }
        return isValid;
    }
}
