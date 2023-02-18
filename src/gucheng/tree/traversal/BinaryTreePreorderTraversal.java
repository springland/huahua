package gucheng.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        //return recursive(root);
        return nonRecursive(root);
    }

    public List<Integer> recursive(TreeNode root){
        List<Integer>  result = new ArrayList<>();
        recursive(root , result);
        return result ;
    }

    public void recursive(TreeNode root , List<Integer> result){
        if(root == null){ return ;}
        result.add(root.val);
        recursive(root.left , result);
        recursive(root.right , result);
    }

    public List<Integer>  nonRecursive(TreeNode root){

        List<Integer>  result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root == null){
                root = stack.pop();
            }
            result.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            root = root.left ;
        }
        return result ;
    }
}
