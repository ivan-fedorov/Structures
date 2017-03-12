package com.tree;


import java.util.ArrayList;
import java.util.List;

class Node {
    Node parent;
    List<Node> keys;
    List<Node> childs;
    String data;

    Node(String data) {
        this.data = data;
        childs = new ArrayList<>();
        keys = new ArrayList<>();
    }

}