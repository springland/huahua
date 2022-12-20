package gucheng.algorithms.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
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


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> currentLevel = new LinkedList<>();
        if(root != null){
            currentLevel.add(root);
        }

        Queue<TreeNode> nextLevel = new LinkedList<>();
        while(!currentLevel.isEmpty()){
            List<Integer> level = new ArrayList<>();

            while(! currentLevel.isEmpty()){
                TreeNode node = currentLevel.poll();
                level.add(node.val);
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }

            result.add(level);
            currentLevel = nextLevel ;
            nextLevel = new LinkedList<>();
        }
        return result ;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size() ;
            List<Integer> currentLevel = new ArrayList<>() ;
            for(int index = 0 ; index < size ; index ++){
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result ;
    }

}
