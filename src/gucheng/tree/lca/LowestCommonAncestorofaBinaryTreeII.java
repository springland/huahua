package gucheng.tree.lca;

import java.util.Stack;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
public class LowestCommonAncestorofaBinaryTreeII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        findPath(root , p , pStack);
        findPath(root  , q , qStack);


        while(pStack.size() > qStack.size()){
            pStack.pop();
        }

        while(qStack.size() > pStack.size()){
            qStack.pop();
        }

        while(!pStack.isEmpty() && !qStack.isEmpty()){
            if(pStack.peek().val == qStack.peek().val){
                return pStack.peek();
            }
            pStack.pop();
            qStack.pop();
        }

        return null;

    }

    public boolean findPath(TreeNode root , TreeNode target ,  Stack<TreeNode> stack){

        if(root == null){
            return false ;
        }


        stack.push(root);
        if(root.val == target.val) return true ;

        if(findPath(root.left , target , stack)){
            return true ;
        }

        if(findPath(root.right , target , stack)){
            return true ;
        }

        stack.pop();
        return false ;
    }}
