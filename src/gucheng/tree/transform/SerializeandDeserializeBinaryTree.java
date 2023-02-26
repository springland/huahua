package gucheng.tree.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<Integer> nodeList = new ArrayList<>();

        if(root != null){
            preOrderSerialize(root , nodeList);
        }

        String ans = nodeList.stream().map( t -> t == null ? null : t.toString()).collect(Collectors.joining(","));
        return ans;
    }

    public void preOrderSerialize(TreeNode root , List<Integer> nodeList ){

        if(root != null){

            nodeList.add(root.val);
            preOrderSerialize(root.left , nodeList);
            preOrderSerialize(root.right , nodeList);
        }
        else{
            nodeList.add(null);
        }

    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        TreeNode root = null;
        if(!data.isEmpty()){

            List<Integer> nodeValues = Arrays.stream(data.split(",")).map( t -> t.equals("null") ? null : Integer.valueOf(t)).collect(Collectors.toList());

            root = preOrderDeserialize(nodeValues , new AtomicInteger(0));
        }

        return root ;

    }

    public TreeNode preOrderDeserialize(List<Integer> nodeValues , AtomicInteger index ){

        TreeNode root = null;
        Integer nodeValue = nodeValues.get(index.getAndIncrement());
        if(nodeValue != null){
            root = new TreeNode();
            root.val = nodeValue.intValue() ;

            root.left = preOrderDeserialize(nodeValues , index);
            root.right = preOrderDeserialize(nodeValues , index);
        }
        return root ;
    }
}
