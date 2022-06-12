package round1.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * LeetCode 104
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root == null)
        {
            return 0 ;
        }

        int leftMax = maxDepth(root.left);

        int rightMax = maxDepth(root.right);

        return leftMax > rightMax ? leftMax+1 : rightMax+1;
    }
}
