package gucheng.dfs;

import java.util.*;

// https://leetcode.com/problems/sudoku-solver/

// it is interesting , solveSudoku2 is faster than solveSudoku
// I thought solveSudoku would be faster
public class SudokuSolver {


    public void solveSudoku2(char[][] board){


        solve(board);

    }

    public boolean solve(char board[][]){

        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex++){
            for(int colIndex = 0 ; colIndex < board.length ; colIndex++){

                if(board[rowIndex][colIndex] == '.'){
                    for(char ch = '1'; ch <= '9' ; ch++){

                        if(isValid(board , rowIndex , colIndex , ch)){
                            board[rowIndex][colIndex] = ch ;
                            if(solve(board)){
                                return true ;
                            }else {
                                board[rowIndex][colIndex] = '.';
                            }
                        }
                    }

                    return false ;
                }
            }
        }
        return true ;
    }
    public boolean isValid(char[][] board , int rowIndex ,int colIndex , char ch){

        for(int index = 0 ; index < board.length ; index++){
            if(board[rowIndex][index] == ch){
                return false ;
            }

            if(board[index][colIndex] == ch){
                return false ;
            }
        }

        for(int row = (rowIndex /3) *3 ; row < (rowIndex /3) *3+3 ; row ++){
            for(int col = (colIndex/3)*3 ; col < (colIndex/3)*3 +3 ; col ++){
                if(board[row][col] == ch){
                    return false ;
                }
            }
        }
        return true ;
    }

    public void solveSudoku(char[][] board) {

        List<int[]>  cells = new ArrayList<>();
        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex ++){
            for(int colIndex = 0 ; colIndex < board[0].length ; colIndex++){
                if(board[rowIndex][colIndex] == '.'){
                    cells.add(new int[] { rowIndex , colIndex});
                }
            }
        }

        Map<Integer , Set<Character>> rowCandidates = new HashMap<>();
        Map<Integer , Set<Character>> colCandidates = new HashMap<>();

        Set<Character> tempalte = Set.of('1' , '2' , '3' , '4' , '5' , '6' , '7' , '8' , '9');
        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex++){
            Set<Character>  candidates = new HashSet<>(tempalte);
            for(int colIndex = 0 ; colIndex < board[0].length ; colIndex++){
                candidates.remove(board[rowIndex][colIndex]);
            }

            rowCandidates.put(rowIndex , candidates);
        }

        for(int colIndex = 0 ; colIndex < board.length ; colIndex++){
            Set<Character>  candidates = new HashSet<>(tempalte);
            for(int rowIndex = 0 ; rowIndex < board[0].length ; rowIndex++){
                candidates.remove(board[rowIndex][colIndex]);
            }

            colCandidates.put(colIndex , candidates);
        }

        solveSudoku(board , cells , 0 , rowCandidates , colCandidates) ;


    }

    public boolean solveSudoku(char[][] board , List<int[]> cells , int index , Map<Integer , Set<Character>> rowCandidatesMap , Map<Integer , Set<Character>> colCandidatesMap){


        if(index == cells.size()){
            return true ;
        }
        int rowIndex = cells.get(index)[0];
        int colIndex = cells.get(index)[1];

        Set<Character>  rowCandidates = rowCandidatesMap.get(rowIndex);
        Set<Character>  colCandidates = colCandidatesMap.get(colIndex);

        Set<Character>  candidates = new HashSet(rowCandidates);
        candidates.retainAll(colCandidates);


        for( Character ch : candidates){
            if(isValid(board , rowIndex , colIndex , ch)) {
               board[rowIndex][colIndex] = ch;
                rowCandidates.remove(ch);
                colCandidates.remove(ch);
                if (solveSudoku(board, cells, index + 1, rowCandidatesMap, colCandidatesMap)) {
                    return true;
                }
                rowCandidates.add(ch);
                colCandidates.add(ch);

                //          }
            }
        }
        board[rowIndex][colIndex] = '.';
        return false ;

    }




    public static void main(String[] args){

        char[][] board = new char[][]  {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);

        for(int rowIndex = 0 ; rowIndex < board.length ; rowIndex++){
            for(int colIndex = 0 ; colIndex < board[0].length ; colIndex++){
                System.out.print(board[rowIndex][colIndex]);
                if(colIndex != board[0].length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }

    }
}
