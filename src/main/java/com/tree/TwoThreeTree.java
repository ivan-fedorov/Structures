package com.tree;


import java.util.Arrays;
import java.util.List;

public class TwoThreeTree {

    private Node root;

    private void sortNode(List<Node> sortNode) {
        Node[] tmpNode = (Node[]) sortNode.toArray();
        Arrays.sort(tmpNode);
        for (int i = 0; i < tmpNode.length; i++) {
            sortNode.set(i, tmpNode[i]);
        }
    }

    Node search(Node searchNode) {
        Node tmpNode = root;
        while (!tmpNode.childs.isEmpty()) {
            if (tmpNode.childs.size() == 2) {
                if (tmpNode.keys.get(0).data.compareTo(searchNode.data) < 0) {
                    tmpNode = tmpNode.childs.get(1);
                } else {
                    tmpNode = tmpNode.childs.get(0);
                }
            } else if (tmpNode.keys.get(1).data.compareTo(searchNode.data) < 0) {
                tmpNode = tmpNode.childs.get(2);
            } else if (tmpNode.keys.get(2).data.compareTo(searchNode.data) < 0) {
                tmpNode = tmpNode.childs.get(1);
            } else {
                tmpNode = tmpNode.childs.get(0);
            }
        }
        return tmpNode.keys.get(0);
    }

    private void splitParent(Node splitNode) {
        if (splitNode.childs.size() > 3) {
            Node tmpNode = new Node(splitNode.data);
            tmpNode.childs.set(0, splitNode.childs.get(2));
            tmpNode.childs.set(1, splitNode.childs.get(3));
            tmpNode.keys.set(0, splitNode.keys.get(2));
            tmpNode.parent = splitNode.parent;

            splitNode.childs.get(2).parent = tmpNode;
            splitNode.childs.get(3).parent = tmpNode;

            splitNode.childs.set(2, null);
            splitNode.childs.set(3, null);

            if (splitNode.parent != null) {
                splitNode.parent = tmpNode;
                sortNode(splitNode.parent.childs);
            } else {
                splitNode = root;
                root.childs.set(0, splitNode);
                root.childs.set(1, tmpNode);
                splitNode.parent = root;
                tmpNode.parent = root;
                sortNode(root.childs);
            }
        }
    }

    private void updateKeys() {

    }

    void insert(String data) {
        if (root == null) {
            root = new Node(data);
        }


    }

}
