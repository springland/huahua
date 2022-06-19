package round1.tree;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class LongestUnivaluePath {


    class Answer {

        int sameTargetValue ;

        int differentTargetValue ;
    }
    public int longestUnivaluePath(TreeNode root) {


        if(root == null)
        {
            return 0 ;
        }


        Answer answer = longestUnivaluePath(root , root.val);

        // what answer has is the number of nodes  , so substract 1 from it to get the path
        return Math.max(answer.sameTargetValue , answer.differentTargetValue)-1;
    }

    protected Answer longestUnivaluePath(TreeNode root , int targetValue)
    {
        Answer answer = new Answer() ;

        if(root == null)
        {
            return answer;
        }

        if(root.val == targetValue)
        {
            if(root.left != null && root.right != null)
            {
                Answer left = longestUnivaluePath(root.left, targetValue);
                Answer right = longestUnivaluePath(root.right, targetValue);

                answer.sameTargetValue = 1 + Math.max(left.sameTargetValue, right.sameTargetValue);
                answer.differentTargetValue = Math.max(1 + left.sameTargetValue+ right.sameTargetValue , Math.max(left.differentTargetValue, right.differentTargetValue));
            }
            else if (root.left != null)
            {
                Answer left = longestUnivaluePath(root.left, targetValue);
                answer.sameTargetValue = 1 + left.sameTargetValue;
                answer.differentTargetValue = left.differentTargetValue;

            }
            else if (root.right != null)
            {
                Answer right = longestUnivaluePath(root.right, targetValue);
                answer.sameTargetValue = 1 + right.sameTargetValue;
                answer.differentTargetValue = right.differentTargetValue;
            }
            else
            {
                answer.sameTargetValue = 1;
                answer.differentTargetValue = 0;
            }
        }
        else
        {
            answer.sameTargetValue = 0 ;

            Answer left = longestUnivaluePath(root.left , root.val);
            Answer right = longestUnivaluePath(root.right , root.val);

            answer.differentTargetValue = Math.max(1 + left.sameTargetValue + right.sameTargetValue ,  Math.max(  left.differentTargetValue , right.differentTargetValue));
        }

        return answer ;
    }


    public static void main(String args[] )
    {
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);

        int answer = longestUnivaluePath.longestUnivaluePath(root);
        System.out.println(answer);
    }
}
