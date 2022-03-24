package com.puzzle.cost;

public interface CostFunction {
    int calculateCost(int parentCost, int sequence);
    int calculateH (int sequence);
    int calculateF(int parentCost, int sequence);

}

