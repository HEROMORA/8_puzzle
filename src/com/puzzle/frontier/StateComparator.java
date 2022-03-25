package com.puzzle.frontier;

import com.puzzle.State;
import com.puzzle.cost.CostType;
import com.puzzle.cost.EnhancedCost;

import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    @Override
    public int compare(State first, State second) {
        return Math.round(first.getCost() - second.getCost());
    }
}
