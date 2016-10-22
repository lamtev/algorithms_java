package com.lamtev.algorithms_java.data_structures.collections;

/**
 * LIFO — Last In First Out
 */
public interface IStack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
