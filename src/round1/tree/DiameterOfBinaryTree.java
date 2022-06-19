package round1.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    class Diameter {

        int independentDiameter = 0 ;

        int dependentDiameter = 0 ;

    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0 ;
        }

        Diameter  diameter = calculateDiameter(root);
        return Math.max(diameter.dependentDiameter, diameter.independentDiameter);
    }

    protected Diameter calculateDiameter(TreeNode root)
    {
        if(root == null || ( root.left == null && root.right == null))
        {
            return new Diameter();
        }



        Diameter left = calculateDiameter(root.left);
        Diameter right = calculateDiameter(root.right);

        Diameter diameter = new Diameter();

        diameter.dependentDiameter = Math.max(left.dependentDiameter , right.dependentDiameter) +1 ;

        if(root.left != null)
        {
            if(root.right != null)
            {
                diameter.independentDiameter = Math.max(2 + left.dependentDiameter + right.dependentDiameter , Math.max(left.independentDiameter , right.independentDiameter));
            }
            else
            {
                diameter.independentDiameter = Math.max(1 + left.dependentDiameter  , left.independentDiameter );
            }
        }
        else
        {
            diameter.independentDiameter = Math.max(1 + right.dependentDiameter  , right.independentDiameter );
        }


        return diameter ;
    }


}
