package gucheng.tree.transform;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        TreeNode root = null;
        if(preorder.length > 0){

            root = buildTree(preorder , 0 , preorder.length-1 ,  postorder , 0 , postorder.length-1);
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder , int preOrderBeginIndex , int preOrderEndIndex ,  int[] postorder , int postOrderBeginIndex , int postOrderEndIndex){

        TreeNode root = null;

        if(preOrderEndIndex < preOrderBeginIndex){
            return null;
        }

        if(preOrderBeginIndex == preOrderEndIndex){
            return new TreeNode(preorder[preOrderBeginIndex]);
        }

        root = new TreeNode(preorder[preOrderBeginIndex]);


        int leftChildrenSize = 0 ;
        int rightChildrenSize = 0 ;
        if(preorder[postOrderBeginIndex+1] == postorder[postOrderEndIndex-1]){

            /* It only has one child

                    1                        1
                   /                          \
                  2                            2
                 / \                          / \
                4   5                        4   5

            both of them have preorder [ 1 2 4 5] and postorder [ 4 5 2 1]

            */
            leftChildrenSize = postOrderEndIndex - postOrderBeginIndex;
            // leave right to be 0 ;
        }
        else{
            // the postorder-1 is the right child

            int rightChildPreOrderIndex  ;
            for(rightChildPreOrderIndex = preOrderBeginIndex ; rightChildPreOrderIndex <= preOrderEndIndex ; rightChildPreOrderIndex++){
                if(preorder[rightChildPreOrderIndex] == postorder[postOrderEndIndex-1]) break;
            }

            rightChildrenSize = preOrderEndIndex - rightChildPreOrderIndex+1 ;
            leftChildrenSize = rightChildPreOrderIndex - (preOrderBeginIndex+1);
        }

        if(leftChildrenSize > 0){
            root.left =  buildTree(preorder , preOrderBeginIndex+1 , preOrderBeginIndex+ leftChildrenSize ,
                    postorder , postOrderBeginIndex  , postOrderBeginIndex + leftChildrenSize -1 );
        }

        if(rightChildrenSize > 0 ){
            root.right =  buildTree(preorder , preOrderBeginIndex+1 + leftChildrenSize , preOrderEndIndex ,
                    postorder , postOrderEndIndex - rightChildrenSize  , postOrderEndIndex-1 );

        }
        return root ;
    }
}
