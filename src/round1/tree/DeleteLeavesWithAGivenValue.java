package round1.tree;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 *
 * LeetCode 1325
 */
public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null)
        {
            return null;
        }



        root.left = removeLeafNodes(root.left , target);
        root.right = removeLeafNodes(root.right , target);

        if(root.left == null && root.right == null )
        {
            if(root.val == target)
            {
                return null;
            }
            else
            {
                return root ;
            }
        }
        return root ;

    }
}
