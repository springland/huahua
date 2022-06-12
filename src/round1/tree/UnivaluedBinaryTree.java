package round1.tree;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 *
 * LeetCode 965
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {

        if(root == null)
        {
            return true ;
        }

        return isUnivalTree(root , root.val);
    }

    protected boolean isUnivalTree(TreeNode root , int val)
    {
        if(root == null )
        {
            return true ;
        }

        if(root.val != val)
        {
            return false ;
        }

        return isUnivalTree(root.left , val ) && isUnivalTree(root.right , val);
    }


}
