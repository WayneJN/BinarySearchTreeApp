package com.wayne.bstapp.service;

import com.wayne.bstapp.model.TreeNode;
import lombok.Getter;

import java.util.*;

@Getter
public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.getValue()) node.setLeft(insertRecursive(node.getLeft(), value));
        else if (value > node.getValue()) node.setRight(insertRecursive(node.getRight(), value));
        return node;
    }

    public void buildBalancedTree(List<Integer> sortedValues) {
        root = buildBalancedHelper(sortedValues, 0, sortedValues.size() - 1);
    }

    private TreeNode buildBalancedHelper(List<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.setLeft(buildBalancedHelper(values, start, mid - 1));
        node.setRight(buildBalancedHelper(values, mid + 1, end));
        return node;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null) return false;
        if (value == node.getValue()) return true;
        return value < node.getValue()
                ? searchRecursive(node.getLeft(), value)
                : searchRecursive(node.getRight(), value);
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderHelper(node.getLeft(), result);
            result.add(node.getValue());
            inOrderHelper(node.getRight(), result);
        }
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null) return null;
        if (value < node.getValue()) node.setLeft(deleteRecursive(node.getLeft(), value));
        else if (value > node.getValue()) node.setRight(deleteRecursive(node.getRight(), value));
        else {
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();
            TreeNode successor = findMin(node.getRight());
            node = new TreeNode(successor.getValue());
            node.setLeft(deleteRecursive(node.getLeft(), successor.getValue()));
            node.setRight(deleteRecursive(node.getRight(), successor.getValue()));
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getLeft() != null) node = node.getLeft();
        return node;
    }

    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    private void preOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.getValue());
            preOrderHelper(node.getLeft(), result);
            preOrderHelper(node.getRight(), result);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private void postOrderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            postOrderHelper(node.getLeft(), result);
            postOrderHelper(node.getRight(), result);
            result.add(node.getValue());
        }
    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.getValue());
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
        return result;
    }

    public int getHeight() {
        return heightHelper(root);
    }

    private int heightHelper(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(heightHelper(node.getLeft()), heightHelper(node.getRight()));
    }

    public boolean isBalanced() {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(TreeNode node) {
        if (node == null) return 0;
        int left = isBalancedHelper(node.getLeft());
        int right = isBalancedHelper(node.getRight());
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
