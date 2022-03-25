package com.puzzle.cost;

import com.puzzle.Util;

public class EnhancedCost implements CostFunction {

    private final CostType costType;

    public EnhancedCost(CostType type)
    {
        this.costType = type;
    }


    private int getRowIndex(int val) {
        return val / 3 ;
    }

    private int getColIndex(int val) {
        return val % 3;
    }

   public float getEuclideanDistance(String sequence) {

       float heuristic = 0;
       for (int i = 0; i < sequence.length(); i++) {
           int goalIndex = sequence.charAt(i) - '0';
           if(goalIndex == 0)
               continue;
           int goalRow = getRowIndex(goalIndex);
           int goalCol = getColIndex(goalIndex);
           int row = getRowIndex(i);
           int col = getColIndex(i);

           heuristic += (float) Math.sqrt(Math.pow(row - goalRow, 2) + Math.pow(col - goalCol, 2));
       }

       return heuristic;
   }

   public float calculateManhattanDistance(String sequence) {
       int heuristic = 0;
       for (int i = 0; i < sequence.length(); i++) {
           int goalIndex = sequence.charAt(i) - '0'; 
           if(goalIndex == 0)
               continue;
           int goalRow = getRowIndex(goalIndex);
           int goalCol = getColIndex(goalIndex);
           int row = getRowIndex(i);
           int col = getColIndex(i);

           heuristic += Math.abs(row - goalRow) + Math.abs(col - goalCol);
       }

       return heuristic;
   }


    @Override
    public float calculateCost(float parentCost, String sequence) {
        return parentCost +  1;
    }

    @Override
    public float calculateCostWithHeuristic(String sequence, float parentCost)
    {
        float heuristicCost = costType == CostType.EUCLIDEAN ? getEuclideanDistance(sequence)
                : calculateManhattanDistance(sequence);
        return heuristicCost + parentCost + 1;
    }


}
