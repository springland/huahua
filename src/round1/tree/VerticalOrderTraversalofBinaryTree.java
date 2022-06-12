package round1.tree;

import java.util.LinkedList;
import java.util.List ;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

public class VerticalOrderTraversalofBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();

        return answer ;
    }

    protected void verticalTraversal(TreeNode root , int row , int col , List<List<Integer>> answer)
    {
        if(root == null)
        {
            return ;
        }

        verticalTraversal(root.left , row+1 , col-1 , answer);
        verticalTraversal(root.left , row+1 , col+1 , answer);

    }
}
