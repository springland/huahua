package gucheng.tree.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
public class SerializeandDeserializeNaryTree {

    // Encodes a tree to a single string.
    public String serialize(Node root) {

        List<Integer>  treeNodeList = new ArrayList<>();
        if(root != null){

            treeNodeList = preOrderSerialize(root);
        }

        return treeNodeList.stream().map( t-> t.toString()).collect(Collectors.joining(","));

    }

    public List<Integer> preOrderSerialize( Node root  ){
        // a pair , first one is value , second one is the number of children
        List<Integer> treeNodeList = new ArrayList<>();
        if(root != null){

            treeNodeList.add(root.val);
            treeNodeList.add(root.children.size());
            for(Node child: root.children){
                treeNodeList.addAll(preOrderSerialize(child));
            }
        }
        else{
            treeNodeList.add(null);
            treeNodeList.add(null);
        }

        return treeNodeList ;
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {

        Node root = null;
        if(!data.isEmpty()){
            List<Integer> treeNodeList = Arrays.stream(data.split(",")).map( t-> "null".equals(t) ? null : Integer.valueOf(t)).collect(Collectors.toList());
            root = preOrderDeserialize(treeNodeList , new AtomicInteger(0));
        }

        return root ;
    }

    public Node  preOrderDeserialize(List<Integer> treeNodeList , AtomicInteger index){

        Node root = null ;
        Integer value = treeNodeList.get(index.getAndIncrement());
        Integer childrenSize = treeNodeList.get(index.getAndIncrement());
        if(value != null){
            root = new Node();
            root.val = value ;
            root.children = new ArrayList<>();
            for(int childIndex = 0 ; childIndex < childrenSize ; childIndex ++){
                root.children.add( preOrderDeserialize(treeNodeList ,  index));
            }
        }
        return root ;
    }
}
