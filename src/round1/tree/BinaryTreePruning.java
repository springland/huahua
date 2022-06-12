package round1.tree;

/**
 *
 * https://leetcode.com/problems/binary-tree-pruning/
 * LeetCode 814
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {


        if(root == null)
        {
            return root ;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val != 1)
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }
        }
        return root ;
    }


}
