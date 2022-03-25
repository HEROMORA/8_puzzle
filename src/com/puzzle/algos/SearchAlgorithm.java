package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.frontier.Frontier;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public abstract class SearchAlgorithm<T> {
    private final HashSet<Integer> explored;
    private final Frontier<State> frontier;
    public State sol;
    public int expandedNodesCount = 0;
    public int searchDepth = 0;
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

        /*for(int state: explored){
            if(state == obj.getSequence()){
                return false;
            }
        }*/

        //return true;
        return !explored.contains(obj.getSequence());
    }

    public boolean isInFrontier(State obj) {
        return frontier.contains(obj);
    }

    public Frontier<State> getFrontier() {
        return frontier;
    }

    public abstract void updateFrontier(State parent,State child);

    public int search() {

        while (!frontier.isEmpty()) {

            State currentState = frontier.extract();
            //System.out.println("Current state: " + currentState.getSequence());
            explored.add(currentState.getSequence());
            expandedNodesCount++;
            if (searchDepth < currentState.getCost()) searchDepth = currentState.getCost();
            if (currentState.isGoal()) {
                //System.out.println(currentState.getSequence());
                sol = currentState;
                return currentState.getSequence();
            }

            List<State> children = currentState.getPossibleChildren();

            for (State child: children) {
//                System.out.println(Arrays.toString(child.getSequence()));
                if(isNotExplored(child)) updateFrontier(currentState,child);
            }

        }

        return -1;
    }


}
