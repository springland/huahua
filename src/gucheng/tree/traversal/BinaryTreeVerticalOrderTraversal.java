package gucheng.tree.traversal;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class BinaryTreeVerticalOrderTraversal {

    static class NodeInfo{
        TreeNode node ;
        int index;

        public NodeInfo(TreeNode node , int index){
            this.node = node ;
            this.index = index ;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        //return recursive(root);
        return iterative(root);
    }



    public List<List<Integer>> recursive(TreeNode root){

        List<List<NodeInfo>> ans = new ArrayList<>();
        if(root != null){
            recursive(root , 0 , 0, 0 , ans);
        }

        return ans.stream().map(
                t -> {Collections.sort(t , (t1 ,t2) -> t1.index - t2.index); return t ;}
        ).map( t-> t.stream().map(r -> r.node.val).collect(Collectors.toList())).collect(Collectors.toList());
    }

    public int recursive(TreeNode root , int index , int min , int level , List<List<NodeInfo>> ans){

        if(index < min){
            min = index ;
            ans.add(0 , new ArrayList<>());
        }else if (index - min +1 > ans.size() ){
            ans.add(new ArrayList<>());
        }

        ans.get(index - min).add(new NodeInfo(root, level));
        if(root.left != null){
            min =  recursive(root.left , index-1 , min , level+1, ans);
        }
        if(root.right != null){
            min = recursive(root.right , index+1 , min , level+1, ans);
        }

        return min ;

    }

    public List<List<Integer>> iterative(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        Queue<NodeInfo> queue = new LinkedList<>();
        if(root != null){
            int minColIndex = 0 ;
            ans.add(new ArrayList<>());
            queue.offer(new NodeInfo(root , 0));
            while(!queue.isEmpty()){
                int size = queue.size() ;
                for(int index = 0 ; index < size ; index++){
                    NodeInfo nodeInfo = queue.poll();
                    if(nodeInfo.index < minColIndex){
                        ans.add(0 , new ArrayList<>());
                        minColIndex = nodeInfo.index ;
                    }else if ( nodeInfo.index - minColIndex == ans.size()){
                        ans.add(new ArrayList<>());
                    }

                    ans.get(nodeInfo.index - minColIndex ).add(nodeInfo.node.val);
                    if(nodeInfo.node.left != null){
                        queue.offer(new NodeInfo(nodeInfo.node.left , nodeInfo.index-1 ));
                    }
                    if(nodeInfo.node.right != null){
                        queue.offer(new NodeInfo(nodeInfo.node.right , nodeInfo.index+1 ));
                    }

                }
            }
        }



        return ans ;

    }
    public static void main(String[] args){
        BinaryTreeVerticalOrderTraversal treeVerticalOrderTraversal = new BinaryTreeVerticalOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(5);

        List<List<Integer>> ans = treeVerticalOrderTraversal.verticalOrder(root);
        System.out.println(ans);
    }

}
