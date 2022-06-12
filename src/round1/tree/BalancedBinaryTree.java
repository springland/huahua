package round1.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * LeetCode 101
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root == null)
        {
            return true ;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return leftDepth >= 0 && rightDepth >= 0 && ( leftDepth == rightDepth || leftDepth == rightDepth+1 || rightDepth == leftDepth+1);


    }

    public int getDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0 ;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if(leftDepth < 0 || rightDepth < 0)
        {
            return -1 ;
        }
        if(leftDepth < rightDepth-1 || rightDepth < leftDepth -1)
        {
            return -1 ;
        }
        return leftDepth > rightDepth ? leftDepth+1: rightDepth+1 ;
    }
}
