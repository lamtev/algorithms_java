package com.lamtev.algorithms_java.data_structures.collections;

/**
 * FIFO — First In First Out
 */
public interface IQueue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();

}
