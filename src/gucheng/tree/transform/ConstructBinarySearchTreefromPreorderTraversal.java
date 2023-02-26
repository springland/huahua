package gucheng.tree.transform;

import java.util.concurrent.atomic.AtomicInteger;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {

        return recursive(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE ,  new AtomicInteger(0));

    }

    public TreeNode recursive(int[] preorder , int min ,  int max , AtomicInteger index){

        TreeNode root = null;

        if( index.get() < preorder.length){

            root = new TreeNode(preorder[index.getAndIncrement()]);
            while( index.get() < preorder.length && preorder[index.get()] > min && preorder[index.get()]< max){
                int nextValue = preorder[index.get()];
                if (nextValue < root.val && nextValue > min) {
                    root.left = recursive(preorder, min, root.val, index);
                } else if (nextValue > root.val && nextValue < max) {
                    root.right = recursive(preorder, root.val, max, index);
                }

            }
        }


        return root ;
    }
}
