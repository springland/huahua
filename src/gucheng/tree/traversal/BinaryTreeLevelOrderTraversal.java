package gucheng.tree.traversal;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //return recursive(root);
        return iterative(root);
    }

    public List<List<Integer>>  iterative(TreeNode root){

        List<List<Integer>>  ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size() ;
                List<Integer>  level = new ArrayList<>();
                ans.add(level);
                for(int index = 0 ; index < size ; index++){
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null)queue.offer(node.right);
                }

            }


        }
        return ans ;
    }

    public List<List<Integer>> recursive(TreeNode root){
        List<List<Integer>>  ans = new ArrayList<>();

        if(root != null){
            recursive(root , 0 , ans);
        }
        return ans ;

    }

    public void recursive(TreeNode root , int index , List<List<Integer>> ans){

        if(index == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(index).add(root.val);
        if(root.left != null){
            recursive(root.left , index+1 , ans);
        }
        if(root.right != null){
            recursive(root.right , index+1 , ans);
        }
    }


}
