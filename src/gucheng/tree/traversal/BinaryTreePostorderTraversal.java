package gucheng.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {


        //return recursive(root);
        //return nonRecursiveTwoStacks(root);
        return oneStack(root);
    }

    public List<Integer> recursive(TreeNode root){

        List<Integer>  result = new ArrayList<>();
        recursive(root , result);
        return result ;
    }

    public void recursive(TreeNode root , List<Integer> result){
        if(root != null){
            recursive(root.left , result);
            recursive(root.right , result);
            result.add(root.val);
        }
    }

    public List<Integer> nonRecursiveTwoStacks(TreeNode root){

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if(root == null){
            return result ;
        }

        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            // here we need to use pre-order in stack1 in order to get post order in stack2
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            result.add(node.val);
        }

        return result ;
    }


    public List<Integer> oneStack(TreeNode root){

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){

            if(root != null){
                if(root.right != null){
                    stack.push(root.right);
                }

                stack.push(root);
                root = root.left ;

            }
            else{
                root = stack.pop();
                if(root.right != null && !stack.isEmpty() && root.right == stack.peek()){
                        stack.pop();
                        stack.push(root);
                        root = root.right;
                }
                else{
                    result.add(root.val);
                    root = null;
                }
            }

        }


        return result ;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        BinaryTreePostorderTraversal treePostorderTraversal = new BinaryTreePostorderTraversal();
        treePostorderTraversal.oneStack(root);
    }

}
