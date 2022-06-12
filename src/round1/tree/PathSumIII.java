package round1.tree;

/**
 *  https://leetcode.com/problems/path-sum-iii/
 *
 *  LeetCode 437
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {

        return pathSum(root , targetSum , targetSum);
    }

    protected int pathSum(TreeNode root , int targetSum , int originalTargetSum)
    {

        if(root == null)
        {
            return 0 ;
        }

        if(targetSum == root.val )
        {
            if(root.left == null && root.right == null)
            {
                return 1 ;
            }
            else
            {
                return 1 + pathSum(root.left , originalTargetSum - root.val) + pathSum(root.right, originalTargetSum - root.val);
            }
        }
        else
        {
            return pathSum(root.left , targetSum - root.val , originalTargetSum)
                    + pathSum(root.right , targetSum - root.val , originalTargetSum)
                    + pathSum(root.left , originalTargetSum - root.val , originalTargetSum)
                    + pathSum(root.right , originalTargetSum - root.val , originalTargetSum);
        }
    }
}
