package com.puzzle.cost;

public class NormalCost implements CostFunction {

    @Override
    public int calculateCost(int parentCost, int sequence) {
        return parentCost + 1;
    }

    @Override
    public float calculateH(int sequence) {
        return 0;
    }

    @Override
    public float calculateF(int parentCost, int sequence) {
        return calculateCost(parentCost,sequence);
    }
}
