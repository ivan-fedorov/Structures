package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }


    public int height() {
        return height(root);
    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        }

        int childLeft = height(node.left);
        int childRight = height(node.right);
        return childLeft > childRight ? childLeft : childRight;

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    public int rank(String data) {
        return size(find(data)) - 1;
    }

    int depth(Node searchNode) {
        return depth(root, searchNode);
    }

    private int depth(Node curNode, Node searchNode) {
        int tmpDepth;
        if (curNode == null || root == searchNode) {
            return 0;
        }
        if (curNode == searchNode) {
            return 1;
        }
        tmpDepth = depth(curNode.left, searchNode);
        if (tmpDepth != 0) {
            return tmpDepth + 1;
        } else {
            return depth(curNode.right, searchNode) + 1;
        }
    }

    public void add(String data) {
        add(root, data);
    }

    private void add(Node curNode, String data) {
        if (data.isEmpty()) {
            return;
        }

        Node newNode = new Node(data);

        if (root == null) {
            this.root = newNode;
        }

        if (curNode == null) {
            return;
        }
        if (data.compareTo(curNode.data) < 0) {
            if (curNode.left == null) {
                curNode.left = newNode;
            } else {
                add(curNode.left, data);
            }
        } else {
            if (curNode.right == null) {
                curNode.right = newNode;
            } else {
                add(curNode.right, data);
            }
        }
    }

    public Node find(String data) {
        return find(root, data);
    }

    private Node find(Node curNode, String data) {
        if (data.isEmpty() || curNode == null) {
            return null;
        }
        if (curNode.data.equals(data)) {
            return curNode;
        }

        if (data.compareTo(curNode.data) < 0) {
            return find(curNode.left, data);
        } else {
            return find(curNode.right, data);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node curNode) {
        if (curNode == null) {
            return;
        }
        System.out.print(curNode.data + " ");
        if (curNode.left != null || curNode.right != null) {
            preOrder(curNode.left);
            preOrder(curNode.right);
        }
    }


    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.print(root.data + " ");
        root.visited = true;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            while ((node.left != null && !node.left.visited) || (node.right != null && !node.right.visited)) {
                if (node.left != null) {
                    node.left.visited = true;
                    System.out.print(node.left.data + " ");
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.visited = true;
                    System.out.print(node.right.data + " ");
                    queue.add(node.right);
                }
            }
        }
    }


    private class Node {
        Node left;
        Node right;
        String data;
        boolean visited;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

}