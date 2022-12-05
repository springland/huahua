package gucheng.dfs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/
public class NQueues {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>>  result = new ArrayList<>();

        boolean[][] board = new boolean[n][n];

        solveNQueens(board , 0 , result) ;

        return result ;
    }

    public void solveNQueens(boolean[][] board , int rowIndex , List<List<String>> result ){

        for(int colIndex = 0 ; colIndex < board.length ; colIndex++){
            if(isValid(board , rowIndex , colIndex)){

                board[rowIndex][colIndex] = true ;
                if(rowIndex == board.length-1){
                    List<String> solution = printBoard(board);
                    result.add(solution);
                }
                else {
                    solveNQueens(board , rowIndex+1 ,  result ) ;
                }
                board[rowIndex][colIndex] = false ;
            }
        }
    }

    public List<String>  printBoard(boolean[][] board){

        List<String> solution = new ArrayList<>();
        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex ++){
            StringBuilder builder = new StringBuilder();
            for(int colIndex = 0 ; colIndex < board[0].length ; colIndex++){
                if(board[rowIndex][colIndex]){
                    builder.append('Q');
                }
                else{
                    builder.append('.');
                }
            }
            solution.add(builder.toString());
        }

        return solution;
    }

    public boolean isValid(boolean[][] board , int row , int col){

        for(int rowIndex = 0 ; rowIndex < row ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < board[0].length ; colIndex++){
                if(board[rowIndex][colIndex]){
                    if(colIndex == col) return false ;
                    if(Math.abs(row - rowIndex) == Math.abs(col - colIndex)) return false ;
                }
            }
        }

        return true ;
    }
}
