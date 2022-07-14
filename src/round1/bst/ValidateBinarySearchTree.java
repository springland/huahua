package round1.bst;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/submissions/
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {

        if(root == null )
        {
            return true ;
        }


        return isValidBST(null , root.val , root.left)
                && isValidBST(root.val , null , root.right);

    }

    public boolean isValidBST(Integer minVal , Integer maxVal , TreeNode root)
    {
        if(root == null) {
            return true ;
        }

        if(minVal != null)
        {
            if(root.val <= minVal.intValue())
            {
                return false ;
            }
        }
        if(maxVal != null)
        {
            if(root.val >= maxVal.intValue()){
                return false ;
            }
        }

        return isValidBST(minVal , root.val , root.left) && isValidBST(root.val , maxVal , root.right);





    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2); ;
        root.right = new TreeNode(2) ;




        ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
        System.out.println(bst.isValidBST(root));
    }
}
