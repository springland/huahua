package round1.binarysearch;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rowNum = matrix.length;
        if(rowNum == 0)
        {
            return false ;
        }
        int colNum = matrix[0].length ;
        if(colNum == 0)
        {
            return false ;
        }

        int firstCol[] = new int[rowNum];
        for(int index = 0 ; index < rowNum ; index++)
        {
            firstCol[index] = matrix[index][0];
        }

        int rowIndex = searchRowIndex(firstCol , target);

        if(rowIndex < rowNum && matrix[rowIndex][0] == target)
        {
            return true ;
        }

        if(rowIndex == 0)
        {
            return false ;
        }

        if(rowIndex == matrix.length)
        {
            if(matrix[rowNum-1][colNum-1] < target)
            {
                return false ;
            }
        }

        int colIndex = searchColIndex(matrix[rowIndex-1] , target);

        return colIndex > 0;
    }

    public int searchRowIndex(int[] data , int target)
    {
        int beginIndex =  0 ;
        int endIndex = data.length-1;

        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex-beginIndex)/2 ;
            if(target == data[middleIndex])
            {
                return middleIndex;
            }
            if(data[middleIndex] < target)
            {
                beginIndex = middleIndex+1;
            }
            else{
                endIndex = middleIndex-1;
            }

        }
        return endIndex+1;
    }

    public int searchColIndex(int[] data , int target)
    {
        int beginIndex =  0 ;
        int endIndex = data.length-1;

        while(beginIndex <= endIndex)
        {
            int middleIndex = beginIndex + (endIndex-beginIndex)/2 ;
            if(target == data[middleIndex])
            {
                return middleIndex;
            }
            if(data[middleIndex] < target)
            {
                beginIndex = middleIndex+1;
            }
            else{
                endIndex = middleIndex-1;
            }

        }
        return -1;
    }

    public static void main(String args[])
    {
        /*
        int[][] matrix = new int[3][4];
        matrix[0][0]= 1;
        matrix[0][1]= 3;
        matrix[0][2]= 5;
        matrix[0][3]= 7;

        matrix[1][0]= 10;
        matrix[1][1]= 11;
        matrix[1][2]= 16;
        matrix[1][3]= 20;

        matrix[2][0]= 23;
        matrix[2][1]= 30;
        matrix[2][2]= 34;
        matrix[2][3]= 60;


        Searcha2DMatrix searcher = new Searcha2DMatrix();
        System.out.println(searcher.searchMatrix(matrix , 0));

        System.out.println(searcher.searchMatrix(matrix , 1));
        System.out.println(searcher.searchMatrix(matrix , 2));
       System.out.println(searcher.searchMatrix(matrix , 3));
        System.out.println(searcher.searchMatrix(matrix , 8));
        System.out.println(searcher.searchMatrix(matrix , 60));
        System.out.println(searcher.searchMatrix(matrix , 61));
        System.out.println(searcher.searchMatrix(matrix , 15));
        System.out.println(searcher.searchMatrix(matrix , 16));
         */

        int[][] matrix = new int[1][1];
        matrix[0][0]= 1;
        //matrix[1][0]= 3;
        Searcha2DMatrix searcher = new Searcha2DMatrix();
        System.out.println(searcher.searchMatrix(matrix , 3));

    }

}
