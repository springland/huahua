package leetcodedaily;

public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] strs) {

        int ans = 0;

        for(int colIndex = 0; colIndex < strs[0].length() ; colIndex++){
            for(int rowIndex = 1 ; rowIndex < strs.length  ; rowIndex++){
                if(strs[rowIndex-1].charAt(colIndex) > strs[rowIndex].charAt(colIndex)){
                    ans ++ ;
                    break;
                }
            }
        }
        return ans ;
    }
}
