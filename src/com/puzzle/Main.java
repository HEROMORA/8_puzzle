package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;

public class Main {

    public static void main(String[] args) {

        //int seq = 427613850;
        int seq = 102345678; //solves
        //int  seq = 847632150; //this one is a lot of trouble
        //int seq = 168403725;
        //int seq = 185647230;

        SearchAlgorithm<State> algo = new AStar<>(seq, CostType.MANHATTAN);
        //SearchAlgorithm<State> algo = new AStar<>(seq, CostType.EUCLIDEAN);
        //SearchAlgorithm<State> algo = new BFS(seq);
        //SearchAlgorithm<State> algo = new DFS(seq);

        Timer.tick();
        int res = algo.search();
        long time = Timer.tock();


        System.out.println("Finished in "+time+" Seconds");

        if(res == -1) System.out.println("Unsolvable.");
        else {
            System.out.println("Cost = "+algo.sol.getCost());
            if(algo.sol.getCost() < 1000)
                System.out.println(algo.sol.traceback());
        }
//        List<State> children =  s.getPossibleChildren();
//
//        System.out.println((children.get(0).getCost()));
    }
}
