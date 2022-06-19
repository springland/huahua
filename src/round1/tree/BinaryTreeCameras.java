package round1.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 */
public class BinaryTreeCameras {

    enum NodeMonitorStatus {
            MONITORED_BY_CHILD,
            MONITORED_BY_PARENT,
            WITH_CAMERA ,
        NOT_MONITORED
    } ;

    public int minCameraCover(TreeNode root) {

        if(root == null)
        {
            return 0 ;
        }

        if(root.left == null && root.right == null)
        {
            return 1 ;
        }

        Map<TreeNode , NodeMonitorStatus>  nodeMonitorStatusMap = new HashMap<>();

        initializeMonitorStatusMap(root , nodeMonitorStatusMap);
        installCameras(root  , 0  , nodeMonitorStatusMap );

        return (int) nodeMonitorStatusMap.values().stream().filter( t -> t.equals(NodeMonitorStatus.WITH_CAMERA)).count();


    }

    protected void initializeMonitorStatusMap(TreeNode root ,  Map<TreeNode , NodeMonitorStatus>  nodeMonitorStatusMap )
    {
        if(root == null)
        {
            return ;
        }
        nodeMonitorStatusMap.put(root , NodeMonitorStatus.NOT_MONITORED);
        initializeMonitorStatusMap(root.left , nodeMonitorStatusMap);
        initializeMonitorStatusMap(root.right , nodeMonitorStatusMap);

        int count = 0;
    }
    protected void  installCameras(TreeNode  root , int level , Map<TreeNode , NodeMonitorStatus>  nodeMonitorStatusMap)
    {


        if(root == null)
        {
            return ;
        }

        if(root.left == null && root.right == null)
        {
            return  ;
        }


        installCameras(root.left , level +1 , nodeMonitorStatusMap);
        installCameras(root.right , level+1 , nodeMonitorStatusMap);


        if(isLeaf(root.left) || isLeaf(root.right))
        {

            nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
            if(root.left != null && nodeMonitorStatusMap.get(root.left) == NodeMonitorStatus.NOT_MONITORED)
            {
                nodeMonitorStatusMap.put(root.left , NodeMonitorStatus.MONITORED_BY_PARENT);
            }

            if(root.right != null && nodeMonitorStatusMap.get(root.right) == NodeMonitorStatus.NOT_MONITORED)
            {
                nodeMonitorStatusMap.put(root.right , NodeMonitorStatus.MONITORED_BY_PARENT);
            }

            return ;
        }

        NodeMonitorStatus leftMonitorStatus = getMonitorStatusByChild(root.left , nodeMonitorStatusMap);
        NodeMonitorStatus rightMonitorStatus = getMonitorStatusByChild(root.right ,nodeMonitorStatusMap );

        if(leftMonitorStatus == NodeMonitorStatus.NOT_MONITORED && rightMonitorStatus == NodeMonitorStatus.NOT_MONITORED)
        {
            if(level == 0) {
                nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
            }
            else {

                if(leftMonitorStatus == NodeMonitorStatus.NOT_MONITORED && root.left != null && nodeMonitorStatusMap.get(root.left) == NodeMonitorStatus.NOT_MONITORED)
                {
                    nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
                    nodeMonitorStatusMap.put(root.left, NodeMonitorStatus.MONITORED_BY_PARENT);
                }

                if(rightMonitorStatus == NodeMonitorStatus.NOT_MONITORED && root.right != null && nodeMonitorStatusMap.get(root.right) == NodeMonitorStatus.NOT_MONITORED)
                {
                    nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
                    nodeMonitorStatusMap.put(root.right, NodeMonitorStatus.MONITORED_BY_PARENT);
                }

            }
        }
        else {
            // it is monitored by child
            nodeMonitorStatusMap.put(root, NodeMonitorStatus.MONITORED_BY_CHILD);

            if(leftMonitorStatus == NodeMonitorStatus.NOT_MONITORED && root.left != null && nodeMonitorStatusMap.get(root.left) == NodeMonitorStatus.NOT_MONITORED)
            {
                nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
                nodeMonitorStatusMap.put(root.left, NodeMonitorStatus.MONITORED_BY_PARENT);
            }

            if(rightMonitorStatus == NodeMonitorStatus.NOT_MONITORED && root.right != null && nodeMonitorStatusMap.get(root.right) == NodeMonitorStatus.NOT_MONITORED)
            {
                nodeMonitorStatusMap.put(root, NodeMonitorStatus.WITH_CAMERA);
                nodeMonitorStatusMap.put(root.right, NodeMonitorStatus.MONITORED_BY_PARENT);

            }
        }
    }

    protected  NodeMonitorStatus getMonitorStatusByChild(TreeNode node , Map<TreeNode , NodeMonitorStatus>  nodeMonitorStatusMap)
    {
        NodeMonitorStatus status = NodeMonitorStatus.NOT_MONITORED;
        if(node != null) {
            if ( nodeMonitorStatusMap.get(node) == NodeMonitorStatus.WITH_CAMERA) {
                status = NodeMonitorStatus.MONITORED_BY_CHILD;
            }
        }
        return status ;
    }


    protected boolean isLeaf(TreeNode node)
    {
        return node != null && node.left == null && node.right == null;
    }


    public static void main(String args[] )
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(6);
        root.left.left.left.right.right = new TreeNode(7);

        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
/*
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.left.left = new TreeNode(6);


        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        */

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.right = new TreeNode(6);
        root.left.right.left.right.left = new TreeNode(7);

        BinaryTreeCameras treeCameras = new BinaryTreeCameras();
        int ans = treeCameras.minCameraCover(root);
        System.out.println(ans);
    }
}
