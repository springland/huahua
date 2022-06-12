package round1.tree;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * LeetCode 669
 */
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root == null)
        {
            return null ;
        }

        if(root.val == low)
        {
            root.left = null ;
            root.right = trimBST(root.right , low , high);
            return root ;
        }

        if(root.val == high)
        {
            root.right = null;
            root.left = trimBST(root.left , low , high);
            return root ;
        }
        if(root.val < low)
        {
            return trimBST(root.right , low , high) ;
        }

        if(root.val > high)
        {
            return trimBST(root.left , low , high) ;

        }
        // root.val is between low and high

        root.left = trimBST(root.left , low , root.val);
        root.right = trimBST(root.right , root.val , high) ;
        return root ;
    }
}
