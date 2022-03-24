package com.puzzle.cost;

import com.puzzle.State;
import com.puzzle.Util;

public class EnhancedCost implements CostFunction {

    CostType costType;

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
        //System.out.println("H = "+heuristic);
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
        //System.out.println("H = "+heuristic);

        return heuristic;
    }


    @Override
    public int calculateCost(int parentCost, int sequence) {
        return parentCost + 1;
    }

    @Override
    public int calculateH(int sequence)
    {
        int []seq = Util.getArrSequence(sequence);
        return (costType == CostType.EUCLIDEAN)? (Math.round(getEuclideanDistance(seq))):calculateManhattanDistance(seq);
    }

    @Override
    public int calculateF(int parentCost, int sequence)
    {
        return calculateCost(parentCost,sequence) + calculateH(sequence);
    }

    public EnhancedCost(CostType type)
    {
        this.costType = type;
    }
}
