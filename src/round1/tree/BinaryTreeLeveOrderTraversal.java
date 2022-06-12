package round1.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * LeetCode 102
 *
 */
public class BinaryTreeLeveOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> levels = new ArrayList<>();

        if(root == null)
        {
            return levels ;
        }
        List<TreeNode>  currentLevel = new ArrayList<>() ;
        currentLevel.add(root);

        while(!currentLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                values.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            levels.add(values);
            currentLevel = nextLevel;
        }

        return levels;
    }



}
