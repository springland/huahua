package round1.bst;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementinABST {

    // in order traversal
    public int kthSmallest(TreeNode root, int k) {

        AtomicInteger  count = new AtomicInteger();
        //TreeNode kth = kthSmallestRecursive(root , k , count);
        TreeNode kth = kthSmallestNonRecursive(root , k);
        return kth.val ;
    }

    public TreeNode kthSmallestRecursive(TreeNode root , int k  , AtomicInteger count){


        if(root == null)
        {
            return null ;
        }

        TreeNode left = null;

        left = kthSmallestRecursive(root.left , k , count);

        if(left != null)
        {
            return left ;
        }

        if(count.incrementAndGet() == k){
            return root ;
        };

        return kthSmallestRecursive(root.right , k , count);

    }

    public TreeNode  kthSmallestNonRecursive(TreeNode root , int k)
    {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root ;
        while(node != null){
            stack.push(node);
            node = node.left ;
        }

        node = null ;
        while(!stack.isEmpty() )
        {
            node = stack.pop();
            k -- ;
            if(k == 0){
                break;
            }
            node = node.right ;
            while(node != null){
                stack.push(node);
                node = node.left ;
            }
        }

        return node ;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(8);
        root.right .right = new TreeNode(12);

        KthSmallestElementinABST bst = new KthSmallestElementinABST();
        for(int index = 1 ; index <= 7 ; index++) {
            TreeNode node = bst.kthSmallestNonRecursive(root, index);
            System.out.println(node.val);
        }
    }
}
