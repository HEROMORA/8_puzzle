package com.puzzle.frontier;

import com.puzzle.State;

import java.util.Stack;

public class StackFrontier implements Frontier<State> {

    private final Stack<State> stack;

    public StackFrontier(State initialState) {
        stack = new Stack<>();
        stack.push(initialState);
    }

    @Override
    public void add(State obj) {
        stack.push(obj);
    }

    @Override
    public State extract() {
        return stack.pop();
    }

    @Override
    public boolean contains(State obj) {
        for(State state: stack){
            if(state.isSameState(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
