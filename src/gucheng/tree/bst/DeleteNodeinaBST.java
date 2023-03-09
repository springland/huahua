package gucheng.tree.bst;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode targetNode = root ;
        TreeNode parentNode = null ;
        while(targetNode != null && targetNode.val != key){
            parentNode = targetNode ;
            if(key < targetNode.val ){
                targetNode = targetNode.left;
            }
            else{
                targetNode = targetNode.right;
            }
        }
        if(targetNode == null){
            return root ;
        }

        if(targetNode == root){

            return removeNode(root);
        }
        else{

            if(parentNode.left == targetNode){

                parentNode.left = removeNode(parentNode.left);
            }
            else{
                parentNode.right = removeNode(parentNode.right);
            }
            return root ;

        }
    }

    public TreeNode  removeNode(TreeNode root){
        if(root == null) return null;

        if(root.left != null){

            TreeNode node = root.left ;
            while(node.right != null){
                node = node.right ;
            }
            node.right = root.right ;

            return root.left ;
        }
        else{
            return root.right ;
        }

    }
}
