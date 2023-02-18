package gucheng.tree.traversal;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        //return recursive(root);
        return iterative(root);
    }

    public List<List<Integer>>  recursive(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root != null){

            recursive(root , 0 , ans);

        }

        Collections.reverse(ans);
        return ans ;
    }

    public void recursive(TreeNode root , int index , List<List<Integer>> ans){

        if(ans.size() == index){
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


    public List<List<Integer>> iterative(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size() ;
                List<Integer> level = new ArrayList<>();
                ans.add(level);
                for(int index = 0 ; index < size ; index++){
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }

        }

        Collections.reverse(ans);
        return ans ;
    }

}
