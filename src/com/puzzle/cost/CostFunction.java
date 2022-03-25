package com.puzzle.cost;

public interface CostFunction {
    float calculateCost(float parentCost, String sequence);

    float calculateCostWithHeuristic(String sequence, float parentCost);
}

