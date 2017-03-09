package com.tree;

import java.util.LinkedList;

class Node {

    LinkedList<Node> child;
    String data;

    public Node(String data) {
        this.data = data;
        child = new LinkedList<>();
    }

}

