package com.puzzle.frontier;

public interface Frontier<T> {
    void add(T obj);
    T extract();
    boolean isEmpty();
}
