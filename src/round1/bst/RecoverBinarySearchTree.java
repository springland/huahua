package round1.bst;

import java.util.Stack;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {


    // swap two nodes in a ascending list
    // if those two nodes are adjacent  then swap the node which is smaller than previous one
    //  1 2 3 4 -> 1 3 2 4
    // if they are not adjacent , then it is the previous node of the first node that is smaller and the second node that is smaller
    // 1 2 3 4 5 ->   1 2 5 4 3  , 4 and 3 are all smaller than previous one . The swap nodes are 5 ( previous of the first smaller node ) and 3 ( the second smaller node)

    public void recoverTree(TreeNode root) {

        Stack<TreeNode>  stack = new Stack<>();
        TreeNode first = null;

        TreeNode second = null;
        TreeNode prev = null;
        TreeNode node = root;
        while(node != null){
            stack.push(node);
            node = node.left ;
        }
        while(!stack.isEmpty()){
            node = stack.pop();
            if(prev != null){
                if(node.val < prev.val){
                    if(first == null){
                        first = prev ;
                        second = node ;
                    }
                    else{
                        second = node ;
                        break;
                    }
                }
            }

            prev = node ;
            node = node.right ;
            while(node != null){
                stack.push(node);
                node = node.left ;
            }
        }


        int temp = first.val;
        first.val = second.val;
        second.val = temp ;

    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBinarySearchTree bst = new RecoverBinarySearchTree();
        bst.recoverTree(root);
        System.out.println(root.val);
    }

}
