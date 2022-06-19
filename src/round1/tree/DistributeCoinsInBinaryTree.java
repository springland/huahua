package round1.tree;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class DistributeCoinsInBinaryTree {

    protected int count ;

    public int distributeCoins(TreeNode root) {

        count = 0 ;
        if(root != null)
        {
            moveCoins(root);
        }

        return count ;

    }


    protected int moveCoins(TreeNode root)
    {

        if(root == null)
        {
            return 0 ;
        }

        int coinsMoved = 0;
        if(root.left == null && root.right == null)
        {
            coinsMoved = root.val - 1 ;

        }
        else {
            int leftCoin = moveCoins(root.left);

            int rightCoin = moveCoins(root.right);

            coinsMoved = root.val + leftCoin + rightCoin - 1;
        }
        if(coinsMoved != 0) count += Math.abs(coinsMoved);

        return coinsMoved ;
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);


        root.val = 0;
        root.left.val = 3;
        DistributeCoinsInBinaryTree  coins = new DistributeCoinsInBinaryTree() ;

        int ans = coins.distributeCoins(root);
        System.out.println(ans);

    }

}
