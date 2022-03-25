package com.puzzle.cost;

public class NormalCost implements CostFunction {

    @Override
    public float calculateCost(float parentCost, String sequence) {
        return parentCost + 1;
    }

    @Override
    public float calculateCostWithHeuristic(String sequence, float parentCost) {
        return 0;
    }
}
