package com.puzzle.frontier;

import com.puzzle.State;

import java.util.LinkedList;
import java.util.Queue;

public class QueueFrontier implements Frontier<State> {

    private final Queue<State> queue;

    public QueueFrontier(State initialState) {
        queue = new LinkedList<>();
        queue.add(initialState);
    }

    @Override
    public void add(State obj) {
        queue.add(obj);
    }

    @Override
    public State extract() {
        return queue.remove();
    }

    @Override
    public boolean contains(State obj) {
        for(State state: queue){
            if(state.isSameState(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}


