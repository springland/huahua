package round1.tree;

/**
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * LeetCode 94
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.List ;
import java.util.LinkedList;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  nodeValuesList = new LinkedList<>();

        inorderTraversal(root , nodeValuesList);
        return nodeValuesList ;
    }

    protected void inorderTraversal(TreeNode root , List<Integer> nodeValuesList)
    {
        if(root == null)
        {
            return ;
        }

        if(root.left != null )
        {
            inorderTraversal(root.left , nodeValuesList);
        }
        nodeValuesList.add(root.val);
        if(root.right != null)
        {
            inorderTraversal(root.right , nodeValuesList);
        }
    }
}
