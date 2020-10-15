## Description
This program provides a collections of basic operations on a binary tree such as inserting, inorderTransversal, and getting size of tree.

## Example Code
Find the height of the tree:
Method that is available to user:
```java
//Initializes the tree with a root
    public BinaryTree(int rootItem) {
        /* DO NOT EDIT THIS METHOD */
        root = new TreeNode(rootItem, null, null);
    }
```
Helper Method:
```java
public int heightSubtree(TreeNode current){
       //Base case
       if (current == null) return -1; 
       // If there is no node in the tree, return height (-1)
       // Or the call pass a leaf

       // As we know, height = 1 + max(height of left subtree, height of right subtree)
       // I think of it as addition of the max between the length of the subtrees and 1 (the path from root to that child)
       return 1 + Math.max(heightSubtree(current.getLeft()), heightSubtree(current.getRight()));
    }
```
