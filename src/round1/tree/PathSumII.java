package round1.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * LeetCode 113
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>>  pathes = new LinkedList<>();
        List<Integer>  path = new LinkedList<>();
        if(root == null)
        {
            return Collections.emptyList();
        }

        if(root.left == null && root.right == null && targetSum == root.val)
        {
            path.add(root.val);
            pathes.add(path);
            return pathes ;
        }

        List<List<Integer>>  left = pathSum(root.left , targetSum - root.val);
        List<List<Integer>>  right = pathSum(root.right , targetSum - root.val);

        for(List<Integer> subPath : left)
        {

            ((LinkedList<Integer>)subPath).addFirst(root.val);
            pathes.add(subPath);
        }

        for(List<Integer> subPath : right)
        {
            ((LinkedList<Integer>)subPath).addFirst(root.val);
            pathes.add(subPath);
        }

        return pathes ;
    }
}
