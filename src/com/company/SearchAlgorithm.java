package com.company;

import com.company.frontier.Frontier;

import java.util.HashSet;

public abstract class SearchAlgorithm<T> {
    public HashSet<T> explored;
    public Frontier<T> frontier;

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
