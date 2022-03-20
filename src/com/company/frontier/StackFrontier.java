package com.company.frontier;

import java.util.Stack;

public class StackFrontier<T> implements Frontier<T> {

    public Stack<T> stack;

    public StackFrontier(T initialState) {
        stack = new Stack<>();
        stack.push(initialState);
    }

    @Override
    public void add(T obj) {
        stack.push(obj);
    }

    @Override
    public T extract() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
