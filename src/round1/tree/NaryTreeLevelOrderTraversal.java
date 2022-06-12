package round1.tree;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * LeetCode 429
 */

import java.util.LinkedList;
import java.util.List ;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NaryTreeLevelOrderTraversal {


    public static void main(String args[])
    {

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3 , Stream.of(node5 , node6).collect(Collectors.toList()));
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node root = new Node(1 , Stream.of(node3 , node2 , node4).collect(Collectors.toList())) ;

        useQueue(root);
    }

    /*
        To my surprise useQueue is slower than the recrusive solution

     */
    public static List<List<Integer>>  useQueue(Node root)
    {
        List<List<Integer>> levels = new LinkedList<>();

        if(root != null)
        {
            java.util.Queue<Node>  nodes = new LinkedList<>();

            nodes.add(root);
            nodes.add(null);
            List<Integer> level = new LinkedList<>();
            while(!nodes.isEmpty())
            {
                Node node = nodes.remove();
                if(node != null)
                {
                    level.add(node.val);
                    if(node.children != null )
                    {
                        nodes.addAll(node.children);
                    }
                }
                else
                {
                    levels.add(level);
                    level = new LinkedList<>();
                    if(!nodes.isEmpty()) {
                        nodes.add(null);
                    }
                }
            }
        }

        return levels ;
    }


    public List<List<Integer>> levelOrder(Node root) {


        List<List<Integer>> levels = new LinkedList<>();

        if(root != null) {
            List<Node> nodes = new LinkedList<>();
            nodes.add(root);
            levelOrder(nodes, levels);
        }
        return levels ;
    }


    protected void  levelOrder(List<Node> nodes , List<List<Integer>> levels)
    {
        if(nodes == null || nodes.isEmpty())
        {
            return ;
        }

        List<Integer> values = new LinkedList<>();
        List<Node> nextLevelNodes = new LinkedList<>();


        for(Node node : nodes)
        {
            values.add(node.val);
            if(node.children != null)
            {
                nextLevelNodes.addAll(node.children);
            }
        }
        levels.add(values);
        levelOrder(nextLevelNodes , levels );
    }
}
