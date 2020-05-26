package com.ds.nonlinear.tree;

public class BinarySearchTree {

    private int value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public BinarySearchTree insert(int value) {
        BinarySearchTree currentNode = this;
        while (currentNode != null) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = new BinarySearchTree(value);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new BinarySearchTree(value);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }

        return this;
    }

    public boolean contains(int value) {
        return findNode(value) != null;
    }

    private BinarySearchTree findNode(int value) {
        BinarySearchTree currentNode = this;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    public BinarySearchTree remove(int value) {
        BinarySearchTree currentNode = this;
        BinarySearchTree previousNode = null;

        while (currentNode != null) {
            if (value < currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                previousNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    int minValue = getInOrderSuccessorValue(currentNode.right);
                    remove(minValue);
                    currentNode.value = minValue;
                } else if (previousNode == null) {
                    if (currentNode.left != null) {
                        currentNode.value = currentNode.left.value;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else if (currentNode.right != null) {
                        currentNode.value = currentNode.right.value;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    }
                } else if (previousNode.left == currentNode) {
                    previousNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                } else if (previousNode.right == currentNode) {
                    previousNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                }
                break;
            }
        }

        return this;
    }

    private static int getInOrderSuccessorValue(BinarySearchTree node) {
        BinarySearchTree currentNode = node;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }
}

