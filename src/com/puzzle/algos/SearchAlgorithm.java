package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.frontier.Frontier;

import java.util.HashSet;
import java.util.List;

public abstract class SearchAlgorithm<T> {
    private final HashSet<String> explored;
    private final Frontier<State> frontier;

    public int expandedNodesCount = 0;
    public float searchDepth = 0;

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
        explored.add(obj.getSequence());
    }

    public boolean isNotExplored(State obj) {
        return !explored.contains(obj.getSequence());
    }

    public boolean isInFrontier(State obj) {
        return frontier.contains(obj);
    }

    public Frontier<State> getFrontier() {
        return frontier;
    }

    public abstract void updateFrontier(State child);

    public State search() {

        while (!frontier.isEmpty()) {

            State currentState = frontier.extract();

            explored.add(currentState.getSequence());

            // TODO: REVIEW
            if (searchDepth < currentState.getCost()) {
                searchDepth = currentState.getCost();
            }

            if (currentState.isGoal()) {
                return currentState;
            }

            List<State> children = currentState.getPossibleChildren();

            for (State child: children) {
                expandedNodesCount++;
                updateFrontier(child);
            }

        }

        return null;
    }




}
