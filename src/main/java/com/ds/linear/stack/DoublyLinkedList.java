package com.ds.linear.stack;

public class DoublyLinkedList {

    public static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node head;
    public Node tail;

    // O(1) time | O(1) space
    public void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            insertBefore(head, node);
        }
    }

    // O(1) time | O(1) space
    public void setTail(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            insertAfter(tail, node);
        }
    }

    // O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {
        remove(nodeToInsert);
        if (node.prev != null) {
            nodeToInsert.prev = node.prev;
            node.prev.next = nodeToInsert;
        } else {
            head = nodeToInsert;
        }

        nodeToInsert.next = node;
        node.prev = nodeToInsert;
    }

    // O(1) time | O(1) space
    public void insertAfter(Node node, Node nodeToInsert) {
        remove(nodeToInsert);
        if (node.next != null) {
            nodeToInsert.next = node.next;
            node.next.prev = nodeToInsert;
        } else {
            tail = nodeToInsert;
        }

        node.next = nodeToInsert;
        nodeToInsert.prev = node;
    }

    // O(p) time | O(1) space
    public void insertAtPosition(int position, Node nodeToInsert) {
        Node currentNode = head;
        int i = 1;
        while (i != position && currentNode != null) {
            currentNode = currentNode.next;
            i++;
        }

        if (currentNode != null) {
            insertBefore(currentNode, nodeToInsert);
        } else {
            setTail(nodeToInsert);
        }
    }

    // O(n) time | O(1) space
    public void removeNodesWithValue(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            Node nodeToRemove = currentNode;
            currentNode = currentNode.next;
            if (nodeToRemove.value == value) {
                remove(nodeToRemove);
            }
        }
    }

    // O(1) time | O(1) space
    public void remove(Node node) {
        if (node == head) {
            head = head.next;
        } else if (node == tail) {
            tail = tail.prev;
        }

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    // O(n) time | O(1) space
    public boolean containsNodeWithValue(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
}

