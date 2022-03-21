package com.puzzle.frontier;

import com.puzzle.State;

import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapFrontier implements Frontier<State> {

    private final PriorityQueue<State> heap;

    public HeapFrontier(State initialState) {
        heap = new PriorityQueue<>();
        heap.add(initialState);
    }

    @Override
    public void add(State obj) {

        for (State state : heap) {
            if (state.equals(obj)) {
                if (state.getCost() > obj.getCost()) {
                    heap.remove(state);
                }
                return;
            }
        }
        heap.add(obj);
    }

    @Override
    public State extract() {
        return heap.poll();
    }

    @Override
    public boolean contains(State obj) {
        return heap.contains(obj);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
