package gucheng.tree.bst;

// https://leetcode.com/problems/closest-binary-search-tree-value/submissions/910518041/
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {


        double diff = Double.MAX_VALUE;
        return closestValue(root , target  , diff , root.val);
    }

    public int closestValue(TreeNode root , double target  , double maxDiff , int ans){

            double diff = Math.abs(target - root.val);
            TreeNode node = null;
            if(target < root.val){

                if(root.left != null){
                    node = root.left ;
                }
            }
            else{

                if(root.right != null){
                    node = root.right ;
                }
            }


            if(node != null){
                if(diff < maxDiff){
                    return closestValue(node , target , diff , root.val);
                }
                else{
                    return closestValue(node , target , maxDiff , ans);
                }
            }
            else{
                if(diff < maxDiff) {
                    return root.val ;
                }
                else{
                    return ans ;
                }
            }
    }

    public static void main(String args[] ){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        ClosestBinarySearchTreeValue binarySearchTreeValue = new ClosestBinarySearchTreeValue();
        System.out.println(binarySearchTreeValue.closestValue(root , 2.857143));
    }
}
