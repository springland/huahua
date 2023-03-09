package gucheng.tree.bst;

import java.util.Stack;

// https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {

        // Binary Search Tree in order traversal should give sorted result

        // so if the current value is less than the max value , then swap it

        if(root == null)return ;

        TreeNode first = null ;
        TreeNode second = null;
        TreeNode prev = null;

        Stack<TreeNode> stack =  new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left ;
        }
        while(root != null || !stack.isEmpty()){

            if(root == null){
                root = stack.pop();
            }

            if(prev != null){

                if(root.val < prev.val){
                    if(first == null){

                        first = prev ;
                        second = root ;
                    }
                    else{
                        second = root ;
                        break;
                    }
                }
            }

            prev = root ;
            root = root.right ;
            while(root != null){
                stack.push(root);
                root = root.left ;
            }
        }

        int temp = first.val ;
        first.val = second.val ;
        second.val = temp;


    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(root);

        System.out.println(root.val);
    }

}
