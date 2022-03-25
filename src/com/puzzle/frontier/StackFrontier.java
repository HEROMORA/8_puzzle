package com.puzzle.frontier;

import com.puzzle.State;

import java.util.HashSet;
import java.util.Stack;

public class StackFrontier implements Frontier<State> {

    private final Stack<State> stack;
    private  final HashSet<String> set;


    public StackFrontier(State initialState) {
        stack = new Stack<>();
        set = new HashSet<>();
        stack.push(initialState);
    }

    @Override
    public void add(State obj) {
        stack.push(obj);
        set.add(obj.getSequence());
    }

    @Override
    public State extract() {
        State x = stack.pop();
        set.remove(x.getSequence());
        return x;
    }

    @Override
    public boolean contains(State obj) {
        return set.contains(obj.getSequence());
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
