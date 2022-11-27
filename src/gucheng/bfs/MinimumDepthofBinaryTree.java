package gucheng.bfs;

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

        int minDepth = 0;
        if(root != null) {


            if (root.left != null && root.right != null) {
                int leftMinDepth = minDepth(root.left);
                int rightMinDepth = minDepth(root.right);

                minDepth = 1 + Math.min(leftMinDepth, rightMinDepth);
            }
            else if(root.left != null){
                minDepth =  1 + minDepth(root.left);
            }else if ( root.right != null){
                minDepth = 1+ minDepth(root.right);
            }else{
                minDepth = 1;
            }

        }

        return minDepth ;
    }

}
