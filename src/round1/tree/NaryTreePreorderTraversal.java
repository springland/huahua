package round1.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * LeetCode 589
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer>  answer = new LinkedList<>();
        preorder(root , answer);
        return answer ;
    }

    protected void preorder(Node root , List<Integer> answer)
    {
        if(root == null)
        {
            return ;
        }

        answer.add(root.val);
        if(root.children != null)
        {
            for(Node child : root.children)
            {
                preorder(child , answer);
            }
        }
    }


}
