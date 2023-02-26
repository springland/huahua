package gucheng.tree.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// https://leetcode.com/problems/serialize-and-deserialize-bst/
public class SerializeandDeserializeBST {

    /*
        It requires  The encoded string should be as compact as possible.

        use preorder  , see 1008 for deserialize

     */
    public String serialize(TreeNode root) {

        return preOrderSerialize(root);


    }

    public String preOrderSerialize(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        preOrderSerialize(root , values);

        return values.stream().map( t-> t.toString()).collect(Collectors.joining(","));

    }

    public void preOrderSerialize(TreeNode root , List<Integer> values) {

        if(root != null) {
            values.add(root.val);
            preOrderSerialize(root.left , values);
            preOrderSerialize(root.right , values);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        TreeNode root = null;
        if(!data.isEmpty()){
            List<Integer> values = Arrays.stream(data.split(",")).map( Integer::valueOf).collect(Collectors.toList());
            root = preOrderDeserialize(values , Integer.MIN_VALUE , Integer.MAX_VALUE , new AtomicInteger(0));
        }
        return root;
    }

    public TreeNode preOrderDeserialize(List<Integer> values , int min , int max , AtomicInteger index){

        TreeNode root = null;
        if(index.get() < values.size()){
            int  value = values.get(index.getAndIncrement());
            root = new TreeNode(value);
            while(index.get() < values.size() && values.get(index.get()) > min && values.get(index.get()) < max){

                int childValue = values.get(index.get());
                if(childValue > min && childValue < value){
                    root.left = preOrderDeserialize(values , min , value , index);
                }else if ( childValue < max && childValue > value){
                    root.right = preOrderDeserialize(values , value , max , index);
                }
            }
        }
        return root ;
    }

}
