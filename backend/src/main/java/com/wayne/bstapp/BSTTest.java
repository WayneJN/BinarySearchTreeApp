package com.wayne.bstapp;

import com.wayne.bstapp.service.BinarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) bst.insert(val);

        System.out.println("In-order Traversal: " + bst.inOrderTraversal());
        System.out.println("Pre-order Traversal: " + bst.preOrderTraversal());
        System.out.println("Post-order Traversal: " + bst.postOrderTraversal());
        System.out.println("Level-order Traversal: " + bst.levelOrderTraversal());
        System.out.println("Height: " + bst.getHeight());
        System.out.println("Is Balanced: " + bst.isBalanced());
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));
    }
}
