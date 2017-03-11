package com.tree;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@Log
class TreeTest {
    private Tree tree;


    /*
              D
           /    \
          C      G
         /      / \
        A      E   H
         \          \
          B          V
                             */
    @BeforeEach
    void setUp() {
        tree = new Tree();
        tree.add("D");
        tree.add("G");
        tree.add("C");
        tree.add("E");
        tree.add("A");
        tree.add("H");
        tree.add("V");
        tree.add("B");
    }

    @Test
    void testTree() {

        System.out.println("BFS: ");
        tree.bfs();
        System.out.println();

        System.out.println("PRE-ORDER: ");
        tree.preOrder();
        System.out.println();

        System.out.println("IN-ORDER: ");
        tree.inOrder();
        System.out.println();

        System.out.println("POST-ORDER: ");
        tree.postOrder();
        System.out.println();
    }

}