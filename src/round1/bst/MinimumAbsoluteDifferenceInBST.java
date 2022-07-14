package round1.bst;

/**
 *https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {

        if(root == null){
            return 0 ;
        }

        if(root.left == null && root.right == null)
        {
            return Integer.MAX_VALUE ;
        }

        int leftDiff = root.left == null ? Integer.MAX_VALUE : Math.abs(getMaxDescendValue(root.left) - root.val);
        int rightDiff = root.right == null ?  Integer.MAX_VALUE :Math.abs(getMinDescendValue(root.right) - root.val);

        int leftMin = root.left == null ? Integer.MAX_VALUE: getMinimumDifference(root.left);
        int rightMin = root.right == null ? Integer.MAX_VALUE:getMinimumDifference(root.right);

        return Math.min( rightDiff , Math.min(leftDiff , Math.min(leftMin, rightMin)));
    }

    public int getMaxDescendValue(TreeNode root)
    {
        while(root.right != null)root = root.right ;

        return root.val ;
    }

    public int getMinDescendValue(TreeNode root)
    {
        while(root.left != null){
            root = root.left ;
        }
        return root.val ;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);

        MinimumAbsoluteDifferenceInBST min = new MinimumAbsoluteDifferenceInBST();
        System.out.println(min.getMinimumDifference(root));
    }
}
