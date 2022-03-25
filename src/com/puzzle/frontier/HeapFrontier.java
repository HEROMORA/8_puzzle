package com.puzzle.frontier;

import com.puzzle.State;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapFrontier implements Frontier<State> {

    private final PriorityQueue<State> heap;
    private final HashSet<String> set;

    public HeapFrontier(State initialState) {
        heap = new PriorityQueue<>(new StateComparator());
        set = new HashSet<>();
        heap.add(initialState);
    }

    @Override
    public void add(State obj) {
        set.add(obj.getSequence());
        heap.add(obj);
    }

    @Override
    public State extract() {

        State x = heap.poll();
        assert x != null;
        set.remove(x.getSequence());
        return x;
    }

    @Override
    public boolean contains(State obj) {
        return set.contains(obj.getSequence());
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void decreaseKey(State newState) {
        Iterator<State> it = heap.iterator();
        State currentState;
        while (it.hasNext())
        {
            currentState = it.next();
            if (currentState.isSameState(newState))
            {
                if (currentState.getCost() > newState.getCost())
                {
                    it.remove();
                    heap.add(newState);
                }
                break;
            }
        }
    }
}
