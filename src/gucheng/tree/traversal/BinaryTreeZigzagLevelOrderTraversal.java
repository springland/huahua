package gucheng.tree.traversal;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //return recursive(root);
        return iterative(root);
    }

    public List<List<Integer>> recursive(TreeNode root){

        List<List<Integer>> ans = new ArrayList<>();

        recursive(root , 0 , ans);

        for(int index = 0 ; index < ans.size() ; index++){
            if(index %2 == 1){
                Collections.reverse(ans.get(index));
            }
        }
        return ans ;
    }

    public void recursive(TreeNode root , int index , List<List<Integer>> ans){

        if(root != null) {
            if (ans.size() == index) {
                ans.add(new ArrayList<>());
            }

            ans.get(index).add(root.val);
            recursive(root.left , index+1 , ans);
            recursive(root.right , index+1 , ans);
        }

    }

    public List<List<Integer>> iterative(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();

        if(root != null){

            int rowIndex = 0;
            queue.add(root);
            while(!queue.isEmpty()){

                int size = queue.size();
                List<Integer> row = new ArrayList<>();
                for(int index = 0 ; index < size ; index++){
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null)queue.offer(node.right);
                    row.add(node.val);
                }
                if(rowIndex %2 == 1) Collections.reverse(row);
                ans.add(row);
                rowIndex++;
            }
        }

        return ans ;

    }
}
