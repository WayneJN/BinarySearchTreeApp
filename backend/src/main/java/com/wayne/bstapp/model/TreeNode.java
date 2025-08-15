package com.wayne.bstapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    // Constructors
    public TreeNode(int value) {
        this.value = value;
    }

    // Getters and setters
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public TreeNode getLeft() { return left; }
    public void setLeft(TreeNode left) { this.left = left; }

    public TreeNode getRight() { return right; }
    public void setRight(TreeNode right) { this.right = right; }
}

