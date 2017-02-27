package com.queue;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class myQueue {

    @Test
    void doTest() {
        MyQueue queue = new MyQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        log.info("queue.peek() = " + queue.peek());

        assertEquals(4, queue.peek());

    }

}