package round1.bst;

public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }


        if(root.val == key){

            if(root.right == null){
                return root.left ;
            }
            else{
                insertNode(root.right , root.left);
                return root.right ;
            }
        }

        if(root.val > key)
        {
            TreeNode left = deleteNode(root.left , key);
            root.left = left ;
        }
        else{
            TreeNode right = deleteNode(root.right ,key);
            root.right = right ;
        }
        return root ;
    }

    public void insertNode(TreeNode root , TreeNode newNode){
        TreeNode node = root ;
        if(newNode == null){
            return ;
        }
        while(node != null){
            if(node.val < newNode.val){
                if(node.right == null){
                    node.right = newNode ;
                    return ;
                }
                else{
                    node = node.right ;
                }
            }
            else{
                if(node.left == null){
                    node.left = newNode ;
                    return ;
                }
                else{
                    node = node.left ;
                }
            }

        }
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        DeleteNodeInABST bst = new DeleteNodeInABST();
        TreeNode node = bst.deleteNode(root , 6);

        bst.printBST(node);

        System.out.println();
    }

    public void printBST(TreeNode root){
        if(root == null){
            return ;
        }
        printBST(root.left);
        System.out.print(root.val + "  ");
        printBST(root.right);
    }



}
