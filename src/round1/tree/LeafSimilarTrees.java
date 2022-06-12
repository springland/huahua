package round1.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * LeetCode 872
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer>  leftLeaves = getLeafValues(root1);
        List<Integer>  rightLeaves = getLeafValues(root2);

        if(leftLeaves.size() != rightLeaves.size())
        {
            return false ;
        }

        Iterator<Integer> itr1 = leftLeaves.iterator();
        Iterator<Integer> itr2 = rightLeaves.iterator();
        while(itr1.hasNext())
        {
            if(!itr1.next().equals(itr2.next()))
            {
                return false ;
            }
        }
        return true ;
    }

    protected List<Integer> getLeafValues(TreeNode root)
    {
        if(root == null)
        {
            return Collections.EMPTY_LIST;
        }
        if(root.left == null && root.right == null)
        {
            return  List.of(root.val);
        }

        List<Integer> leafValues = new ArrayList<>();
        leafValues.addAll(getLeafValues(root.left));
        leafValues.addAll(getLeafValues(root.right));
        return leafValues ;
    }
}
