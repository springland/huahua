package gucheng.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
public class MinimumDepthofBinaryTree {

    public class TreeNode {
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
    }
    public int minDepth(TreeNode root) {

        return bfs(root);
    }

    public int bfs(TreeNode root){
        int depth = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            depth ++ ;
            int size = queue.size() ;
            for(int index = 0 ; index < size ; index++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                {
                    return depth ;
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return depth ;
    }
    public int dfs(TreeNode root){
        int minDepth = 0;
        if(root != null) {


            if (root.left != null && root.right != null) {
                int leftMinDepth = dfs(root.left);
                int rightMinDepth = dfs(root.right);

                minDepth = 1 + Math.min(leftMinDepth, rightMinDepth);
            }
            else if(root.left != null){
                minDepth =  1 + dfs(root.left);
            }else if ( root.right != null){
                minDepth = 1+ dfs(root.right);
            }else{
                minDepth = 1;
            }

        }

        return minDepth ;

    }
}
