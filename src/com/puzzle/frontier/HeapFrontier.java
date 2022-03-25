package com.puzzle.frontier;

import com.puzzle.State;

import java.util.Iterator;
import java.util.PriorityQueue;

public class HeapFrontier implements Frontier<State> {

    private final PriorityQueue<State> heap;

    public HeapFrontier(State initialState) {
        heap = new PriorityQueue<>(new StateComparator());
        heap.add(initialState);
    }

    @Override
    public void add(State obj) {
        heap.add(obj);
    }

    @Override
    public State extract() {
        return heap.poll();
    }

    @Override
    public boolean contains(State obj) {
        for(State state: heap){
            if(state.isSameState(obj)){
                return true;
            }
        }
        return false;
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
