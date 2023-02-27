package gucheng.tree.transform;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = null;


        if(inorder.length > 0){
            root = buildTree(inorder , 0 , inorder.length-1 , postorder , 0 , postorder.length-1);
        }
        return root ;
    }

    public TreeNode buildTree(int[] inorder , int inOrderBeginIndex , int inOrderEndIndex , int[] postorder , int postOrderBeginIndex , int postOrderEndIndex){

        if(inOrderBeginIndex > inOrderEndIndex){
            return null;
        }
        if(inOrderBeginIndex == inOrderEndIndex){
            return new TreeNode(inorder[inOrderBeginIndex]);
        }

        TreeNode root = new TreeNode(postorder[postOrderEndIndex]);

        int rootNodeInOrderIndex ;

        for(rootNodeInOrderIndex = inOrderBeginIndex ; rootNodeInOrderIndex <= inOrderEndIndex ; rootNodeInOrderIndex++){
            if(inorder[rootNodeInOrderIndex] == root.val) break;
        }

        int leftChildrenSize = rootNodeInOrderIndex - inOrderBeginIndex ;
        int rightChildrenSize = inOrderEndIndex - rootNodeInOrderIndex ;

        root.left = buildTree( inorder , inOrderBeginIndex , rootNodeInOrderIndex-1 , postorder , postOrderBeginIndex , postOrderBeginIndex + leftChildrenSize-1);
        root.right = buildTree(inorder , rootNodeInOrderIndex+1 , inOrderEndIndex , postorder , postOrderEndIndex - rightChildrenSize  , postOrderEndIndex-1);
        return root ;

    }
}
