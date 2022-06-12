package round1.tree;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * LeetCode 144
 */

import java.util.List ;
import java.util.LinkedList ;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer>  nodeValuesList = new LinkedList<>();

        preorderTraversal(root , nodeValuesList);
        return nodeValuesList ;
    }

    protected void preorderTraversal(TreeNode root , List<Integer> nodeValuesList)
    {
        if(root == null)
        {
            return ;
        }

        nodeValuesList.add(root.val);
        if(root.left != null)
        {
            preorderTraversal(root.left , nodeValuesList);
        }

        if(root.right != null)
        {
            preorderTraversal(root.right , nodeValuesList);
        }
    }
}
