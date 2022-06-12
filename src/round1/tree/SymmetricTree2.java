package round1.tree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * LeetCode 101
 */
public class SymmetricTree2 {

    public boolean isSymmetric(TreeNode root) {

        return isMirror(root , root) ;
    }


    public boolean isMirror(TreeNode left , TreeNode right)
    {

        if(left == null && right == null)
        {
            return true ;
        }

        if((left == null && right != null) ||(left != null && right == null) )
        {
            return false ;
        }

        return left.val == right.val && isMirror(left.left , right.right) && isMirror (left.right , right.left);
    }

}
