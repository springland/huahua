package round1.bst;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)
        {
            return new TreeNode(val);
        }
        if(val < root.val ){

            if(root.left == null) {
                root.left = new TreeNode(val);
            }
            else{
                insertIntoBST(root.left , val);
            }
        }
        else{
            if(root.right == null){
                root.right = new TreeNode(val);
            }
            else {
                insertIntoBST(root.right, val);
            }
        }
        return root ;
    }


    public static void main(String args[]){

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        InsertIntoABinarySearchTree bst = new InsertIntoABinarySearchTree();
        bst.insertIntoBST(root , 25);

        System.out.println(root.val);
    }
}
