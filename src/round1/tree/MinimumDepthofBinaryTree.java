package round1.tree;

/**
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 *  LeetCode 111
 */
public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null)
        {
            return 0 ;
        }

        if(root.left == null && root.right == null)
        {
            return 1 ;
        }

        if(root.left == null)
        {
            return minDepth(root.right)+1;
        }

        if(root.right == null)
        {
            return minDepth(root.left) +1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return leftDepth < rightDepth ? leftDepth +1 :rightDepth+1;
    }
}
