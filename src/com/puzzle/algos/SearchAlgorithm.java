package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.frontier.Frontier;

import java.util.HashSet;
import java.util.List;

public abstract class SearchAlgorithm<T> {
    private final HashSet<State> explored;
    private final Frontier<State> frontier;

    public SearchAlgorithm(Frontier<State> frontier) {
        this.frontier = frontier;
        this.explored = new HashSet<>();
    }

    public void addToFrontier(State obj) {
        frontier.add(obj);
    }

    public State extractFromFrontier() {
        return frontier.extract();
    }

    public void setExplored(State obj) {
        explored.add(obj);
    }

    public boolean isExplored(State obj) {
        return explored.contains(obj);
    }

    public boolean isInFrontier(State obj) {return frontier.contains(obj);}

    public abstract void updateFrontier(State child);

    public int search() {
        while (!frontier.isEmpty()) {
            State currentState = frontier.extract();
            explored.add(currentState);

            if (currentState.isGoal()) {
                // TODO: Construct path
            }

            List<State> children = currentState.getPossibleChildren();

            for (State child: children) {
                updateFrontier(child);
            }

        }

        return -1;
    }


}
