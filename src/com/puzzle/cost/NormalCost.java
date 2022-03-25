package com.puzzle.cost;

public class NormalCost implements CostFunction {

    @Override
    public float calculateCost(float parentCost, int sequence) {
        return parentCost + 1;
    }
}
