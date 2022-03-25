package com.puzzle.frontier;

import com.puzzle.State;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class QueueFrontier implements Frontier<State> {

    private final Queue<State> queue;
    HashSet<String> set;

    public QueueFrontier(State initialState) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        queue.add(initialState);
    }

    @Override
    public void add(State obj) {
        set.add(obj.getSequence());
        queue.add(obj);
    }

    @Override
    public State extract() {
       State x = queue.remove();
       set.remove(x.getSequence());
        return x;
    }

    @Override
    public boolean contains(State obj) {
        return set.contains(obj.getSequence());
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}


