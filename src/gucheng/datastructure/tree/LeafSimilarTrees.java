package gucheng.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

// https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilarTrees {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    };
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

          List<TreeNode>  root1Leaves = getLeaves(root1);
          List<TreeNode>  root2Leaves =  getLeaves(root2);

          if(root1Leaves.size() != root2Leaves.size()){
              return false ;
          }

          for(int index = 0 ; index < root1Leaves.size(); index++){
              if(root1Leaves.get(index).val != root2Leaves.get(index).val){
                  return false ;
              }
          }
          return true ;
    }

    public List<TreeNode> getLeaves(TreeNode root){
        List<TreeNode> leaves = new ArrayList<>();

        // pre order

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){

            if(root != null){
                if(root.right != null){
                    stack.push(root.right);
                }
                else{
                    if(root.left == null)
                    {
                        leaves.add(root);
                    }
                }
                root = root.left ;
            }
            else{
                root = stack.pop();
            }
        }
        return leaves;
    }

    public static void main(String args[]){

        TreeNode rootLeft = new TreeNode(3);
        rootLeft.left = new TreeNode(5);
        rootLeft.left.left = new TreeNode(6);
        rootLeft.left.right = new TreeNode(2);
        rootLeft.left.right.left = new TreeNode(7);
        rootLeft.left.right.right = new TreeNode(4);

        rootLeft.right = new TreeNode(1);
        rootLeft.right.left = new TreeNode(9);
        rootLeft.right.right = new TreeNode(8);

        LeafSimilarTrees  similarTrees = new LeafSimilarTrees();
        List<TreeNode> leaves = similarTrees.getLeaves(rootLeft);
        System.out.println(leaves.stream().map(t -> String.valueOf(t.val)).collect(Collectors.joining(",")));

    }

}
