package round1.bst;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null) {
            return root ;
        }
        if(root.val == val){
            return root ;
        }else  if(val < root.val ){
            return searchBST(root.left , val);
        } else  {
            return searchBST(root.right , val);
        }
    }
}
