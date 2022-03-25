package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.cost.NormalCost;
import com.puzzle.frontier.QueueFrontier;

public class BFS extends SearchAlgorithm<State> {

    public BFS(String seq) {
        super(new QueueFrontier(new State(seq, new NormalCost())));
    }

    @Override
    public void updateFrontier(State child) {
        if(!isInFrontier(child) && isNotExplored(child)) {
            addToFrontier(child);
        }
    }
}
