package gucheng.tree.transform;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = null;

        if(preorder.length > 0){

            root = buildTree(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1);

        }
        return root ;


    }

    public TreeNode buildTree(int[] preorder , int preOrderBeginIndex , int preOrderEndIndex , int[] inorder , int inOrderBeginIndex , int inOrderEndIndex){

        if(preOrderEndIndex < preOrderBeginIndex) return null;

        if(preOrderBeginIndex == preOrderEndIndex) return new TreeNode(preorder[preOrderBeginIndex]) ;

        TreeNode root = new TreeNode(preorder[preOrderBeginIndex]);

        int inOrderRootIndex ;
        for(inOrderRootIndex= inOrderBeginIndex ; inOrderRootIndex <= inOrderEndIndex ; inOrderRootIndex++){
            if(inorder[inOrderRootIndex] == root.val) break;
        }

        int leftChildrenSize = inOrderRootIndex - inOrderBeginIndex ;
        int rightChildrenSize = inOrderEndIndex - inOrderRootIndex ;

        root.left = buildTree(preorder , preOrderBeginIndex +1 , preOrderBeginIndex + leftChildrenSize , inorder , inOrderBeginIndex , inOrderRootIndex-1);
        root.right = buildTree(preorder , preOrderEndIndex - rightChildrenSize+1 , preOrderEndIndex , inorder , inOrderRootIndex+1 , inOrderEndIndex);

        return root ;
    }

}
