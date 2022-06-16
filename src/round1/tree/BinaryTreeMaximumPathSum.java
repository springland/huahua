package round1.tree;

public class BinaryTreeMaximumPathSum {

    class MaxPathSum {
        int terminated = 0;
        int nonTerminated = 0 ;

    };

    public int maxPathSum(TreeNode root) {

        if(root == null)
        {
            return 0 ;
        }
        MaxPathSum maxPathSum = calcPathSum(root);
        return Math.max(maxPathSum.terminated, maxPathSum.nonTerminated);
    }

    public  MaxPathSum calcPathSum( TreeNode root)
    {


        if(root == null)
        {
            return null;
        }

        MaxPathSum pathSum = new MaxPathSum() ;
        if(root.left == null && root.right == null)
        {
            pathSum.terminated = root.val ;
            pathSum.nonTerminated = root.val ;
            return pathSum ;
        }
        MaxPathSum  left = calcPathSum(root.left);
        MaxPathSum  right = calcPathSum(root.right);




        if(left != null && right != null)
        {
            pathSum.nonTerminated = Math.max(root.val , Math.max(root.val + left.nonTerminated , root.val + right.nonTerminated));
            pathSum.terminated = Math.max(right.terminated , Math.max(left.terminated , Math.max(root.val , Math.max(root.val + left.nonTerminated , Math.max(root.val + right.nonTerminated , root.val + left.nonTerminated + right.nonTerminated)))));
        }
        else if(left != null)
        {
            pathSum.nonTerminated = Math.max(root.val , root.val + left.nonTerminated);
            pathSum.terminated = Math.max(left.terminated , Math.max(root.val , root.val + left.nonTerminated));
        }
        else {
            pathSum.nonTerminated = Math.max(root.val , root.val + right.nonTerminated);
            pathSum.terminated = Math.max(right.terminated , Math.max(root.val , root.val + right.nonTerminated));

        }



        return pathSum;

    }


    public static void main(String args[])
    {

        String  data = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        SerializeandDeserializeBinaryTree  serializer = new SerializeandDeserializeBinaryTree();

        TreeNode root = serializer.deserialize(data);
        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();
        System.out.println(pathSum.maxPathSum(root));
    }
}
