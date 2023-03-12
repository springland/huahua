package gucheng.tree.bst;

// https://leetcode.com/problems/unique-binary-search-trees/
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        return recursive(n);
    }

    public int recursive(int n){
        int[] ans = new int[n+1];

        return recursive(n , ans);
    }

    public int recursive(int n , int[] ans){
        if( n < 3){
            return n ;
        }

        if(n == 3){
            return 5 ;
        }

        if(ans[n] > 0){
            return ans[n];
        }

        int total = 0 ;
        for(int index = 1 ; index <= n ; index++){

            int left = index -1 ;
            int right = n - index ;

            if(left == 0 ){
                total += recursive(right , ans);
                continue;
            }
            if(right == 0){
                total += recursive(left  , ans);
                continue;
            }
            total += recursive(left , ans) * recursive(right , ans);
        }

        ans[n] = total ;
        return total ;
    }

    public static void main(String args[] ){
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(4));
    }
}
