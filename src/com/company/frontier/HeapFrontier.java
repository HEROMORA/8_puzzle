package com.company.frontier;

import java.util.PriorityQueue;

public class HeapFrontier<T> implements Frontier<T> {

    public PriorityQueue<T> heap;

    public HeapFrontier(T initialState) {
        heap = new PriorityQueue<>();
        heap.add(initialState);
    }

    @Override
    public void add(T obj) {

    }

    @Override
    public T extract() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
