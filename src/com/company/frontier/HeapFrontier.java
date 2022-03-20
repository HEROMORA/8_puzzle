package com.company.frontier;

import java.util.PriorityQueue;

public class HeapFrontier<T> implements Frontier<T> {

    private final PriorityQueue<T> heap;

    public HeapFrontier(T initialState) {
        heap = new PriorityQueue<>();
        heap.add(initialState);
    }

    @Override
    public void add(T obj) {
        heap.add(obj);
    }

    @Override
    public T extract() {
        return heap.poll();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
