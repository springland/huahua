package round1.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * LeetCode 257
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null)
        {
            return Collections.EMPTY_LIST ;
        }

        if(root.left == null && root.right == null)
        {
            return List.of(String.valueOf(root.val));
        }

        List<String>  paths = new LinkedList<>();

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        paths.addAll(leftPaths.stream().map( p-> String.valueOf(root.val) + "->" + p ).collect(Collectors.toList()));
        paths.addAll(rightPaths.stream().map( p-> String.valueOf(root.val) + "->" + p ).collect(Collectors.toList()));
        return paths ;

    }



}
