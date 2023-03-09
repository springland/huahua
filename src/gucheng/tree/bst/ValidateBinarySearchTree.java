package gucheng.tree.bst;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root , null , null);

    }

    public boolean isValidBST(TreeNode root , Integer minVal , Integer maxVal){

        if(root == null){
            return true ;
        }

        if(minVal != null && root.val <= minVal){
            return false ;
        }

        if(maxVal != null && root.val >= maxVal){
            return false ;
        }

        return isValidBST(root.left , minVal , root.val) && isValidBST(root.right , root.val , maxVal);
    }
}
