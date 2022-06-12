package round1.tree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 *  failed
 *
 * LeetCode 572
 *
 */
public class SubTreeOfAnother {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        return isSubtree(root , subRoot , subRoot);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot , TreeNode originalSubRoot) {

        if( subRoot == null && root == null)
        {
            return true ;
        }

        if(subRoot == null || root == null)
        {
            return false ;
        }

        if(root.val == subRoot.val)
        {
            if (isSubtree(root.left , subRoot.left , originalSubRoot) && isSubtree(root.right , subRoot.right , originalSubRoot))
            {
                return true ;
            }
        }

        return isSubtree(root.left ,originalSubRoot , originalSubRoot) || isSubtree(root.right , originalSubRoot , originalSubRoot);

    }


    public static void main(String args[])
    {
        TreeNode subRoot = new TreeNode(3);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(2);

        SubTreeOfAnother checker = new SubTreeOfAnother();
        boolean result =  checker.isSubtree(root , subRoot)  ;
        System.out.println(result);

    }
}
