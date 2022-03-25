package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.cost.CostType;
import com.puzzle.cost.EnhancedCost;
import com.puzzle.frontier.HeapFrontier;

public class AStar<T> extends SearchAlgorithm<T> {

    public AStar(int sequence, CostType type) {
        super(new HeapFrontier(new State(sequence, new EnhancedCost(type))));
    }


    private double manhattanDistance() {
        return 0;
    }

    private double eucDistance() {
        return 0;
    }

    @Override
    public void updateFrontier(State parent, State child) {

        HeapFrontier heapFrontier = (HeapFrontier)getFrontier();
        if(!isInFrontier(child) && isNotExplored(child)) {
            addToFrontier(child);
        } else if (isInFrontier(child)) {
            heapFrontier.decreaseKey(parent,child);
        }
    }
}
