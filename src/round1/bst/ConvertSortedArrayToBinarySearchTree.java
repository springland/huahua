package round1.bst;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {


        return sortedArrayToBST(nums , 0 , nums.length-1);

    }

    public TreeNode sortedArrayToBST(int[] nums , int beginIndex , int endIndex){

        if(beginIndex > endIndex){
            return null ;
        }
        if(beginIndex == endIndex){
            return new TreeNode(nums[beginIndex]);
        }

        int middleIndex = beginIndex + (endIndex - beginIndex)/2;

        TreeNode root = new TreeNode(nums[middleIndex]);
        root.left = sortedArrayToBST(nums , beginIndex , middleIndex-1);
        root.right = sortedArrayToBST(nums , middleIndex+1 , endIndex);
        return root ;
    }

    public static void main(String args[]){
        int[] nums = new int[] {-10,-3,0,5,9};
        ConvertSortedArrayToBinarySearchTree bst = new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = bst.sortedArrayToBST(nums);

    }
}
