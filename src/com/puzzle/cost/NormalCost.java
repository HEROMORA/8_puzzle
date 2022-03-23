package com.puzzle.cost;

public class NormalCost implements CostFunction {

    @Override
    public int calculateCost(int parentCost, int sequence) {
        return parentCost + 1;
    }
}
