package lab4;
public class BinaryTree {

    protected TreeNode root;

    //Constructor 1 (Default)
    //Initializes an empty tree
    public BinaryTree() {
        /* DO NOT EDIT THIS METHOD */
        root = null;
    }

    //Constructor 2
    //Initializes the tree with a root
    public BinaryTree(int rootItem) {
        /* DO NOT EDIT THIS METHOD */
        root = new TreeNode(rootItem, null, null);
    }

    //Constructor 3
    //Initializes the tree with the root, left subtree and right subtree
    public BinaryTree(int rootItem, BinaryTree leftTree, BinaryTree rightTree) {
        /* DO NOT EDIT THIS METHOD */
        root = new TreeNode(rootItem, null, null);
        attachToLeftSubtree(leftTree);
        attachToRightSubtree(rightTree);
    }

    //Tree Traversal: In Order
    public void inorderTraversal(){
        /* DO NOT EDIT THIS METHOD */
        inorderRecursive(root);
    }

    //Tree Traversal: In Order (recursive)
    public void inorderRecursive(TreeNode current) {
        /* DO NOT EDIT THIS METHOD */
        if (current != null) {
            inorderRecursive(current.getLeft());
            System.out.print(" " + current.getItem());
            inorderRecursive(current.getRight());
        }
    }

    //Attaches an item to the left branch
    public void attachToLeft(int newItem) {
        // Create a node for the new element
        TreeNode temp = new TreeNode(newItem);

        // In case, the tree is empty
        if (root == null) root = temp;

        // In case, there is any element on the left branch
        if (root.getLeft() != null) {
            System.out.println("Left branch is already occupied!");
            return;
        }

        //  Add the node as the left child
        root.setLeft(temp);
    }

    //Attaches an item to the right branch
    public void attachToRight(int newItem) {
        // Create a new node for the new element
        TreeNode temp = new TreeNode(newItem);
        
        // In case, the tree is empty
        if (root == null) root = temp;


        // In case, there is already an element on the right branch
        if (root.getRight() != null) {
            System.out.println("Right branch is already occupied!");
            return;
        }

        // Add the new node as the right child 
        root.setRight(temp);
    }

    //Attaches a sub-tree to the left branch
    public void attachToLeftSubtree(BinaryTree leftTree) {

        // In case the root is empty
        if (root == null) root  = leftTree.root;

        // Check if the left branch is already occupied
        if (root.getLeft() != null) {
            System.out.println("Left branch already occupied!");
            return;
        }

        // Add the new subtree as the left subtree of the root
        root.setLeft(leftTree.root);
    }

    //Attaches a sub-tree to the right branch
    public void attachToRightSubtree(BinaryTree rightTree) {

        // In case the root is empty
        if (root == null) root = rightTree.root;

        // In case the right branch has a subtree
        if (root.getRight() != null) {
            System.out.println("Left branch is already occupied!");
            return;
        }

        // Add the new subtree as th right subtree of the root
        root.setRight(rightTree.root);
    }

    //Returns the number of nodes in the tree.
    public int size(){
        // Use a helper method to find the size
        return sizeRecursive(root);
    }

    //Recursive method to calculate the number of nodes.
    public int sizeRecursive(TreeNode node) {
        
        // Intialize size to be 0
        int size = 0;

        // Base case
        if (node == null) return size;
        
        size++; // If not, count the current node in
 
        // Check if the node has a left child
        if (node.getLeft() != null)
            size += sizeRecursive(node.getLeft());
        
        // Check if the node has a right child
        if(node.getRight() != null)
            size += sizeRecursive(node.getRight());

        return size; 
        /* Another way
        if (node == null) return 0;
        if (node.getLeft() != null && node.getRight() != null)
            return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
        if (node.getLeft() != null)
            return 1 + sizeRecursive(node.getLeft());
        if (node.getRight() != null)
            return 1 + sizeRecursive(node.getRight());
        else return 1;
        */
    }

    //Returns the height of the tree
    public int height(){
        // Use a helper method to find the height
        return heightSubtree(root);
    }

    public int heightSubtree(TreeNode current){
       //Base case
       if (current == null) return -1; 
       // If there is no node in the tree, return height (-1)
       // Or the call pass a leaf

       // As we know, height = 1 + max(height of left subtree, height of right subtree)
       // I think of it as addition of the max between the length of the subtrees and 1 (the path from root to that child)
       return 1 + Math.max(heightSubtree(current.getLeft()), heightSubtree(current.getRight()));
    }
}