package round1.bst;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {


        Stack<TreeNode> stack = new Stack();

        TreeNode node = root ;
        while(node != null){
            stack.push(node);
            node = node.left ;
        }

        int max = 0 ;
        int count = 0;
        Set<Integer> modes  = new HashSet<>();
        TreeNode prev = null;
        while(!stack.isEmpty()){

            node = stack.pop();
            if(prev == null)
            {
                count = 1;

            }
            else{
                if(prev.val == node.val){
                    count ++ ;
                }else{
                    count = 1;
                }

            }
            prev = node ;

            if(count == max){
                modes.add(node.val);
            }
            else if (count > max){
                max = count ;
                modes.clear();
                modes.add(node.val);
            }

            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left ;
            }
        }

        int[] result = new int[modes.size()];

        int index = 0;
        for(Integer mode : modes){
            result[index++] = mode ;
        }

        return result ;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        FindModeInBinarySearchTree bst = new FindModeInBinarySearchTree();
        bst.findMode(root);
    }
}
