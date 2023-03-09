package gucheng.tree.bst;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {


        return sortedArrayToBST(nums , 0 , nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums , int left , int right){

        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }

        int middle = left + ( right -left )/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums , left , middle-1);
        root.right = sortedArrayToBST(nums , middle+1 , right);
        return root ;
    }
}
