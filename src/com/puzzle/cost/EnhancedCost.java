package com.puzzle.cost;

import java.util.List;

public class EnhancedCost implements CostFunction {
    private int getRowIndex(int val) {
        return val/3;
    }

    private int getColIndex(int val) {
        return val%3;
    }

    public float getEuclideanDistance(int[] sequence) {
        //TODO
        float heuristic = 0;
        for (int i = 0; i < sequence.length; i++) {
            int goalIndex = sequence[i];
            int goalRow = getRowIndex(goalIndex);
            int goalCol = getColIndex(goalIndex);
            int row = getRowIndex(i);
            int col = getColIndex(i);

            heuristic += (float) Math.sqrt(Math.pow(row - goalRow, 2) + Math.pow(col - goalCol, 2));
        }
        return heuristic;
    }

    public int calculateManhattanDistance(int [] sequence) {
        //TODO
        int heuristic = 0;
        for (int i = 0; i < sequence.length; i++) {
            int goalIndex = sequence[i];
            int goalRow = getRowIndex(goalIndex);
            int goalCol = getColIndex(goalIndex);
            int row = getRowIndex(i);
            int col = getColIndex(i);

            heuristic += Math.abs(row - goalRow) + Math.abs(col - goalCol);
        }
        return heuristic;
    }


    @Override
    public int calculateCost(int parentCost, int sequence) {
        return 0;
    }
}
