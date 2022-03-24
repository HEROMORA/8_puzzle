package com.puzzle.frontier;

import com.puzzle.State;
import com.puzzle.cost.CostType;
import com.puzzle.cost.EnhancedCost;

import java.util.Comparator;

public class StateComparator implements Comparator<State> {

    @Override
    public int compare(State o1, State o2) {
        return (o1.getF() - o2.getF());
    }
}
