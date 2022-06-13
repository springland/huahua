package round1.tree;

/**
 *
 *  https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 *  LeetCode 129
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {

        if(root == null)
        {
            return 0 ;
        }
        return sumNumbers(root , 0);
    }

    public int sumNumbers(TreeNode root , int total)
    {


        total = total * 10 + root.val ;

        if(root.left == null && root.right == null)
        {
            return total ;
        }

        int leftSum = 0 ;
        int rightSum = 0 ;
        if(root.left != null)
        {
            leftSum = sumNumbers(root.left , total);
        }

        if(root.right != null)
        {
            rightSum = sumNumbers(root.right , total);
        }

        return leftSum + rightSum ;
    }

}
