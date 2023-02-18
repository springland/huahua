package gucheng.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        //return recursive(root);
        return nonRecursive(root);
    }

    public List<Integer>  recursive(TreeNode root){

        List<Integer>  result = new ArrayList<>();

        recursive(root , result);
        return result ;
    }

    public void recursive(TreeNode root , List<Integer> result){

        if(root != null){
            recursive(root.left , result);
            result.add(root.val);
            recursive(root.right , result);
        }
    }

    public List<Integer>  nonRecursive(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            if(root == null){
                root = stack.pop();
                result.add(root.val);
                root = root.right ;
            }
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        return result ;
    }
}
