package com.tree;


public class TwoThreeTree {

    private Node root;


    private class Node {
        TwoThreeTree.Node left;
        TwoThreeTree.Node right;
        String data;
        boolean visited;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

}
