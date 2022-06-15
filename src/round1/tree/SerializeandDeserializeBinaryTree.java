package round1.tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * LeetCode 297
 */
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {


        if(root == null)
        {
            return "" ;
        }
        List<TreeNode>  currentLevel = new LinkedList<>();
        currentLevel.add(root);

        LinkedList<String> values = new LinkedList<>();
        while( !currentLevel.isEmpty())
        {
            List<TreeNode> nextLevel = new LinkedList<>();

            Iterator<TreeNode> itr = currentLevel.iterator();
            while(itr.hasNext())
            {
                TreeNode node = itr.next();
                if(node == null)
                {
                    values.add(null);
                }
                else {
                    values.add(String.valueOf(node.val));
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel ;

        }

        // remove all nulls from tail;

        while(values.peekLast() == null)
        {
            values.removeLast();
        }

        return "[" + values.stream().map( t-> t == null ? "null" : t).collect(Collectors.joining(",")) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null  )
        {
            return null ;
        }

        data = data.trim();
        if(data.isEmpty() || data.charAt(0) != '[' || data.charAt(data.length()-1) != ']')
        {
            return null ;
        }

        data =  data.substring(1 , data.length()-1);
        String[] values = data.split(",");

        List<TreeNode>  parentLevel = new LinkedList<>();

        TreeNode root = buildTreeNode(values[0]);
        parentLevel.add(root);

        int index = 1;
        while(!parentLevel.isEmpty())
        {
            Iterator<TreeNode> itr = parentLevel.iterator();
            LinkedList<TreeNode>  currentLevel = new LinkedList<>();
            while(itr.hasNext() && index < values.length)
            {
                TreeNode node = itr.next();
                node.left = buildTreeNode(values[index++]);
                if(node.left != null) currentLevel.add(node.left);
                if(index < values.length) {
                    node.right = buildTreeNode(values[index++]);
                    if(node.right != null) currentLevel.add(node.right);
                }



            }
            parentLevel = currentLevel ;

        }

        return root ;

    }

    protected TreeNode buildTreeNode(String value)
    {
        if("null".equals(value))
        {
            return null;
        }
        else {
            return new TreeNode(Integer.parseInt(value));
        }
    }


    public static void main(String args[])
    {
        String data= "[1,2,3,null,null,4,5,6,7]";

        data = "[1,2,3,null,null,4,5]";
        data = "[1,2]";

        /*
                                  1
                           2               3
                                      4          5
                                  6       7


         */

        SerializeandDeserializeBinaryTree tool = new SerializeandDeserializeBinaryTree();

        TreeNode root = tool.deserialize(data);

        String value = tool.serialize(root);
        System.out.print(value);
        assert data.equals(value);

    }
}
