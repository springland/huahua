package round1.tree;

/**
 *  https://leetcode.com/problems/path-sum-iii/
 *
 *  LeetCode 437
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {

        if(root == null)
        {
            return 0 ;
        }

        int rootSum = countPath(root , targetSum);
        int leftChildSum = pathSum(root.left , targetSum);
        int rightChildSum = pathSum(root.right , targetSum);

        return rootSum +leftChildSum +rightChildSum ;
    }

    public int countPath(TreeNode root , int targetSum )
    {
        if(root == null)
        {
            return  0;
        }

        if( root.val == targetSum)
        {
            return  1 + countPath(root.left , 0) + countPath(root.right , 0);
        }

        return countPath(root.left , targetSum - root.val) + countPath(root.right , targetSum - root.val);

    }


    public  static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.right.right = null;
        root.left.left.left = new TreeNode(-1);

        PathSumIII pathSum = new PathSumIII();
        System.out.println(pathSum.pathSum(root , -1) );

    }
}
