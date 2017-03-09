package com.tree;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
        this(null);
    }

    static int height(Node node) {


        int tmpHeight = -1;

        if (!node.child.isEmpty()) {
            for (Node childNode : node.child) {
                int childHeight = height(childNode);
                if (childHeight > tmpHeight) {
                    tmpHeight = childHeight;
                }
            }
        }
        return tmpHeight + 1;
    }

    int size(Node node) {
        if (node == null) {
            return 0;
        }
        int tmpSize = 0;
        for (Node childNode : node.child) {
            tmpSize += size(childNode);
        }
        return tmpSize + 1;
    }

    int rank(Node node) {
        return size(node) - 1;
    }

    int depth(Node curNode, Node searchNode) {
        int tmpDepth;
        if (curNode == null || root == searchNode) {
            return 0;
        }
        if (curNode == searchNode) {
            return 1;
        }
        if (!curNode.child.isEmpty()) {
            for (Node childNode : curNode.child) {
                tmpDepth = depth(childNode, searchNode);
                if (tmpDepth != 0) {
                    return tmpDepth + 1;
                }
            }
        }
        return -1;
    }

    void add(Node curNode, String data) {
        if (data.isEmpty()) {
            return;
        }
        if (root == null) {
            this.root = new Node(data);
        }
        if (curNode == null) {
            curNode = new Node(data);
        }
        if (data.compareTo(curNode.data) < 0) {
            add(curNode.child.get(0), data);
        } else {
            add(curNode.child.get(1), data);
        }
    }
}
