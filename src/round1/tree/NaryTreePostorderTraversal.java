package round1.tree;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 *
 * LeetCode 590
 *
 */

import java.util.LinkedList;
import java.util.List ;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {

        List<Integer>  answer = new LinkedList<>();

        postorder(root , answer);
        return answer;
    }

    protected void postorder(Node root , List<Integer> answer)
    {
        if(root == null)
        {
            return ;
        }

        if(root.children != null)
        {
            for(Node child: root.children)
            {
                postorder(child , answer);
            }
        }

        answer.add(root.val);
    }
}
