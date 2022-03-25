package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.cost.NormalCost;
import com.puzzle.frontier.StackFrontier;

public class DFS extends SearchAlgorithm<State> {
    public DFS(int seq) {
        super(new StackFrontier(new State(seq, new NormalCost())));
    }

    @Override
    public void updateFrontier(State child) {
        if(!isInFrontier(child) && isNotExplored(child)) {
            addToFrontier(child);
        }
    }
}
