package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.frontier.Frontier;

import java.util.Arrays;
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

    public boolean isNotExplored(State obj) {

        for(State state: explored){
            if(state.isSameState(obj)){
                return false;
            }
        }
        return true;
//        return !explored.contains(obj);
    }

    public boolean isInFrontier(State obj) {
        return frontier.contains(obj);
    }

    public Frontier<State> getFrontier() {
        return frontier;
    }

    public abstract void updateFrontier(State child);

    public int search() {

        while (!frontier.isEmpty()) {

            State currentState = frontier.extract();
            System.out.println("Current state: " + currentState.getSequence());
            explored.add(currentState);

            if (currentState.isGoal()) {
                System.out.println(currentState.getSequence());
                return 999;
            }

            List<State> children = currentState.getPossibleChildren();

            for (State child: children) {
//                System.out.println(Arrays.toString(child.getSequence()));
                updateFrontier(child);
            }

        }

        return -1;
    }


}
