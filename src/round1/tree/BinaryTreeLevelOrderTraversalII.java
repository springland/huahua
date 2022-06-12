package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * LeetCode 107
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> levels = new LinkedList<>();

        if(root == null)
        {
            return levels ;
        }

        List<TreeNode> currentLevel = new LinkedList<>();
        List<TreeNode> nextLevel  ;

        currentLevel.add(root);
        while(!currentLevel.isEmpty())
        {
            nextLevel = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            for(TreeNode node : currentLevel)
            {
                level.add(node.val);
                if(node.left != null)
                {
                    nextLevel.add(node.left);
                }
                if(node.right != null)
                {
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel ;
            levels.addFirst(level);
        }
        return levels ;

    }
}
