package gucheng.algorithms.recurison;

// https://leetcode.com/problems/binary-tree-cameras/description/
public class BinaryTreeCameras {

 public static class TreeNode {
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


 int ans ;

 public int minCameraCover(TreeNode root) {
  ans = 0 ;

  return (countCamera(root) < 1 ?  1 : 0) + ans ;
 }

 public int countCamera(TreeNode root){
   if (root == null) return 2 ;
   int left = countCamera(root.left) ;
   int right = countCamera(root.right);

   if(left == 2 && right == 2){
    return 0 ;
   }
   if(left == 0 || right == 0){
    ans ++;
    return 1 ;
   }
   if(left == 1 || right == 1){
    return 2 ;
   }

   return 100;
 }




}
