package com.puzzle.algos;

import com.puzzle.State;
import com.puzzle.cost.CostFunction;
import com.puzzle.cost.EnhancedCost;
import com.puzzle.frontier.Frontier;
import com.puzzle.frontier.QueueFrontier;

public class AStar<T> extends SearchAlgorithm<T> {

    public AStar(int[] sequence) {
        super(new QueueFrontier<>(new State(sequence, new EnhancedCost())));
    }


    private double manhattanDistance() {
        return 0;
    }

    private double eucDistance() {
        return 0;
    }
}
