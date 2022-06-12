package round1.tree;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * LeetCode 145
 */

import java.util.List ;
import java.util.LinkedList ;
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer>  nodeValuesList = new LinkedList<>();

        postorderTraversal(root , nodeValuesList);
        return nodeValuesList ;
    }

    protected void postorderTraversal(TreeNode root , List<Integer> nodeValuesList)
    {
        if(root == null)
        {
            return ;
        }

        if(root.left != null)
        {
            postorderTraversal(root.left , nodeValuesList);
        }

        if(root.right != null)
        {
            postorderTraversal(root.right , nodeValuesList);
        }

        nodeValuesList.add(root.val);
    }
}
