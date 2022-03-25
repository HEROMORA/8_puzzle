package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.cost.CostType;
import com.puzzle.cost.EnhancedCost;
import com.puzzle.frontier.HeapFrontier;

public class AStar extends SearchAlgorithm<State> {

    public AStar(int sequence, CostType type) {
        super(new HeapFrontier(new State(sequence, new EnhancedCost(type))));
    }

    @Override
    public void updateFrontier(State child) {

        HeapFrontier heapFrontier = (HeapFrontier)getFrontier();
        if(!isInFrontier(child) && isNotExplored(child)) {
            addToFrontier(child);
        } else if (isInFrontier(child)) {
            heapFrontier.decreaseKey(child);
        }
    }
}
