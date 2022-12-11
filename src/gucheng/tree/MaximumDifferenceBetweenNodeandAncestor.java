package gucheng.tree;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class MaximumDifferenceBetweenNodeandAncestor {

    static class TreeNode {
        int val;
        LeafSimilarTrees.TreeNode left;
        LeafSimilarTrees.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, LeafSimilarTrees.TreeNode left, LeafSimilarTrees.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

    public int maxAncestorDiff(TreeNode root) {

        return maxAncestorDiff(root , 0 , 0);
    }

    public int maxAncestorDiff(TreeNode parent , int max , int min) {

        if(parent == null){
            return  Math.min(Math.abs(min) , Math.abs(max));
        }


        return 0;

    }

}
