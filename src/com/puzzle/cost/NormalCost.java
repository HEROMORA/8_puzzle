package com.puzzle.cost;

public class NormalCost implements CostFunction {

    @Override
    public int calculateCost(int parentCost, int sequence) {
        return parentCost + 1;
    }

    @Override
    public int calculateH(int sequence) {
        return 0;
    }

    @Override
    public int calculateF(int parentCost, int sequence) {
        return calculateCost(parentCost,sequence);
    }
}
