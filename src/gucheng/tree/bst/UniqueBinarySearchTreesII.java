package gucheng.tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {

        if(n == 0) return null ;

        return  recursive(n);
    }

    public List<TreeNode> recursive(int n){

        List<TreeNode>[][] memo = new List[n+1][n+1];


        return recursive(1 , n , memo);

    }

    public List<TreeNode> recursive(int begin , int end , List<TreeNode>[][] memo){
        if(begin > end){
            return Collections.EMPTY_LIST;
        }
        if(begin == end){
            return List.of(new TreeNode(begin));
        }

        if(memo[begin][end] != null){
            return memo[begin][end];
        }

        List<TreeNode> ans = new ArrayList<>();


        for(int index = begin ; index <= end  ; index++){



            if(index == begin){

                List<TreeNode>  children = recursive(begin+1 , end , memo);
                ans.addAll(buildTree(index , Collections.EMPTY_LIST , children ));

                continue ;
            }
            if(index == end){

                List<TreeNode> children = recursive(begin , end-1 , memo);
                ans.addAll(buildTree(index  ,children , Collections.EMPTY_LIST));
            }
            else{
                List<TreeNode> leftChildren = recursive(begin , index-1 , memo);
                List<TreeNode> rightChildren = recursive(index+1 , end , memo);
                ans.addAll(buildTree(index , leftChildren , rightChildren));
            }

        }

        memo[begin][end] = ans ;
        return ans ;

    }

    public List<TreeNode>  buildTree(int value , List<TreeNode> leftChildren , List<TreeNode> rightChildren){

        List<TreeNode>  ans = new ArrayList<>();


        if(leftChildren.isEmpty()){
            for(TreeNode node : rightChildren){
                TreeNode root = new TreeNode(value);
                root.right = node ;
                ans.add(root);
            }
        }
        else if ( rightChildren.isEmpty()){
            for(TreeNode node : leftChildren){
                TreeNode root = new TreeNode(value);
                root.left = node ;
                ans.add(root);
            }
        }
        else{
            for(TreeNode left : leftChildren){
                for(TreeNode right: rightChildren){

                    TreeNode root = new TreeNode(value);
                    root.left = left ;
                    root.right = right ;
                    ans.add(root);
                }
            }

        }
        return ans ;
    }

    public static void main(String[] args){
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        uniqueBinarySearchTreesII.generateTrees(3);
    }

}
