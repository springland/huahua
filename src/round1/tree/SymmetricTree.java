package round1.tree;

/**
 *
 * https://leetcode.com/problems/symmetric-tree/
 * LeetCode 101
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        TreeNode flipped = flipTree(root);
        return isSameTree(root , flipped);
    }

    public TreeNode flipTree(TreeNode root)
    {
        if(root == null )
        {
            return null ;
        }

        TreeNode flipped = new TreeNode(root.val);
        flipped.left = flipTree(root.right);
        flipped.right = flipTree(root.left);

        return flipped ;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null)
        {
            return true ;
        }

        if((p == null && q != null) || (p != null && q == null) )
        {
            return false ;
        }

        if( p.val != q.val)
        {
            return false ;
        }

        return isSameTree(p.left ,q.left) && isSameTree(p.right , q.right);
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);

        root.right.left = null;
        root.right.right = new TreeNode(3);

        SymmetricTree check = new SymmetricTree();
        System.out.println(check.isSymmetric(root));
    }
}
