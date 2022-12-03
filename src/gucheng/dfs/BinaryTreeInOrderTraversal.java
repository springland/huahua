package gucheng.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class BinaryTreeInOrderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {

          List<Integer>  result = new ArrayList<>();
          //recursive(root , result);
            nonrecursive(root , result);
          return result ;
    }

    public void recursive(TreeNode root , List<Integer> result){
          if(root != null){
              recursive(root.left , result);
              result.add(root.val);
              recursive(root.right , result);
          }
    }

    public void nonrecursive(TreeNode root , List<Integer> result){

        Stack<TreeNode>  stack = new Stack<>();

        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right ;
        }
    }

    public static void main(String args[]){
        BinaryTreeInOrderTraversal binary = new BinaryTreeInOrderTraversal();

        //System.out.println(binary.inorderTraversal(null));
        System.out.println(binary.inorderTraversal(new TreeNode(1)));
    }
}
