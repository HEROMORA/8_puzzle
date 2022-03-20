package com.puzzle.algos;

import com.puzzle.frontier.Frontier;

import java.util.HashSet;

public abstract class SearchAlgorithm<T> {
    private HashSet<T> explored;
    private Frontier<T> frontier;

    public void addToFrontier(T obj) {
        frontier.add(obj);
    }

    public T extractFromFrontier() {
        return frontier.extract();
    }

    public void setExplored(T obj) {
        explored.add(obj);
    }

    public boolean isExplored(T obj) {
        return explored.contains(obj);
    }


}
