package gucheng.algorithms.dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        //recursivePreorder(root , result);
        nonRecursiveProder(root , result);
        return result ;
    }

    public void nonRecursiveProder(TreeNode root , List<Integer> result){

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root == null){
                root = stack.pop();
            }

            while(root != null){
                result.add(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
                root = root.left ;
            }
        }
    }
    public void recursivePreorder(TreeNode root , List<Integer> result){
        if(root != null){
            result.add(root.val);
            if(root.left != null){
                recursivePreorder(root.left , result);
            }
            if(root.right != null){
                recursivePreorder(root.right , result);
            }
        }
    }
}
