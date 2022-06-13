package round1.tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * LeetCode 236
 */
public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == null || q == null)
        {
            return null ;
        }


        TreeNode left = lowestCommonAncestor(root.left , p , q);

        TreeNode right = lowestCommonAncestor(root.right , p , q);


        if(root == p || root == q)
        {
            return root ;
        }



        if( left == null && right == null )
        {
            return null;
        }


        if(left != null )
        {
            if(left != p && left != q) {
                return left;
            }
            else {
                if(right != null)
                {
                    return root ;
                }
                else {
                    return left ;
                }
            }
        }
        else {
            return right ;
        }
    }




}
