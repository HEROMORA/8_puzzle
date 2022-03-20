package com.puzzle.frontier;

import java.util.LinkedList;
import java.util.Queue;

public class QueueFrontier<T> implements Frontier<T> {

    private final Queue<T> queue;

    public QueueFrontier(T initialState) {
        queue = new LinkedList<>();
        queue.add(initialState);
    }

    @Override
    public void add(T obj) {
        queue.add(obj);
    }

    @Override
    public T extract() {
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}


