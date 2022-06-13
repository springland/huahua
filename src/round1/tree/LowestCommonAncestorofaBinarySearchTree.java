package round1.tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 *
 * LeetCode 235
 *
 *
 * Seems something wrong with LeetCode test case
 *
 *
 [2,null,3]
 3

 This code returns 3 but the test case expect 2. However per the description (where we allow a node to be a descendant of itself). Then 3 should be the correct answer
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
        {
            return null;
        }

        if(root.val > p.val && root.val > q.val )
        {
            return lowestCommonAncestor(root.right , p , q);
        }

        if( root.val < p.val && root.val < p.val)
        {
            return lowestCommonAncestor(root.left , p , q);
        }

        return root ;
    }

    public static void main(String args[])
    {
        LowestCommonAncestorofaBinarySearchTree check = new LowestCommonAncestorofaBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode p = new TreeNode(3);

        TreeNode c = check.lowestCommonAncestor(root , p ,p);

        if( c != null)
        {
            System.out.println(c.val);
        }


    }
}
