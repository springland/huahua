package round1.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {


    public int rob(TreeNode root) {
        if(root == null)
        {
            return 0 ;
        }

        if(root.left == null && root.right == null)
        {
            return root.val ;
        }

        Map<TreeNode , Integer>  robbedMap = new HashMap<>();
        Map<TreeNode , Integer>  skippedMap = new HashMap<>();
        return rob(root , false , robbedMap , skippedMap);

    }

    protected int rob(TreeNode  root, boolean parentRobbed , Map<TreeNode , Integer>  robbedMap , Map<TreeNode , Integer>  skippedMap)
    {
        if(root == null)
        {
            return 0 ;
        }

        if(parentRobbed == true)
        {
            // have to skip this level

            if(skippedMap.containsKey(root))
            {
                return skippedMap.get(root);
            }
            int left = rob(root.left , false , robbedMap , skippedMap);
            int right = rob(root.right , false , robbedMap , skippedMap);
            skippedMap.put(root , left + right);
            return left + right ;
        }
        else{

            int leftRobRoot  = 0;
            int leftSkipRoot = 0;
            int rightRobRoot =0;
            int rightSkipRoot = 0;

            int robbed = 0;
            int skipped = 0 ;
            if(robbedMap.containsKey(root))
            {
                robbed = robbedMap.get(root);

            }
            else
            {
                if(root.left != null)
                {
                    leftRobRoot = rob(root.left , true , robbedMap , skippedMap);
                }
                if(root.right != null)
                {
                    rightRobRoot = rob(root.right , true , robbedMap , skippedMap);

                }
                robbed = root.val + leftRobRoot + rightRobRoot ;
                robbedMap.put(root , robbed);
            }

            if(skippedMap.containsKey(root))
            {
                skipped = skippedMap.get(root);
            }
            else
            {
                if(root.left != null)
                {
                    leftSkipRoot = rob(root.left , false , robbedMap , skippedMap);
                }
                if(root.right != null)
                {
                    rightSkipRoot = rob(root.right , false , robbedMap , skippedMap);

                }
                skipped =  leftSkipRoot + rightSkipRoot ;
                skippedMap.put(root , skipped);

            }


            return Math.max(robbed , skipped);
        }

    }

    public static void main(String args[])
    {

        HouseRobberIII houseRobber = new HouseRobberIII();
        TreeNode root = new TreeNode(5);

        assert houseRobber.rob(root) == 5;


        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        assert houseRobber.rob(root) == 5;

        root.left = new TreeNode(4);
        assert houseRobber.rob(root) == 6;

        root.right = null ;
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        assert houseRobber.rob(root) == 10;

    }





}
