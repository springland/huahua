package round1.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 *
 * 449
 */
public class SerializeAndDeserializeBST {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null)
        {
            return "";
        }

        List<Integer> values = new LinkedList<>();

        values.add(root.val);
        values.addAll(serializeToList(root.left));
        values.addAll(serializeToList(root.right));

        return "[" + values.stream().map( t -> String.valueOf(t)).collect(Collectors.joining(",")) + "]";
    }

    protected List<Integer> serializeToList(TreeNode root)
    {
        if(root == null)
        {
            return Collections.emptyList();
        }

        List<Integer> values = new LinkedList<>();
        values.add(root.val);

        values.addAll(serializeToList(root.left));
        values.addAll(serializeToList(root.right));
        return values ;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        if(data == null)
        {
            return null;
        }

        data = data.trim();

        if(data.isEmpty() || data.charAt(0) != '[' || data.charAt(data.length()-1) != ']' )
        {
            return null;
        }

        data = data.substring(1 , data.length()-1);

        String strValues[] = data.split(",");
        int   intValues[] = new int[strValues.length];
        for(int index = 0 ; index < strValues.length ; index++)
        {
            intValues[index]= Integer.parseInt(strValues[index]);
        }


        return deserialize(intValues , 0 , intValues.length-1);

    }

    protected TreeNode deserialize(int[] values , int beginIndex ,int endIndex)
    {

        if(beginIndex > endIndex  )
        {
            return null;
        }
        TreeNode root = new TreeNode( values[beginIndex]);
        int index = beginIndex+1;
        while(index <= endIndex && values[index] < values[beginIndex])
        {
            index ++;

        }
        if(index <= endIndex)
        {
            root.left = deserialize(values , beginIndex+1 , index-1);
            root.right = deserialize(values , index , endIndex);
        }
        else {
            root.left = deserialize(values , beginIndex+1 , endIndex);
        }

        return root ;
    }

    public static void main(String args[])
    {
        SerializeAndDeserializeBST helper = new SerializeAndDeserializeBST();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String data = helper.serialize(root);
        System.out.println(data);

        TreeNode ans = helper.deserialize(data);
        System.out.println(ans);
    }
}
