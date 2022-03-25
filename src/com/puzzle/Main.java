package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;
import com.puzzle.view.MainView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

//        MainView view = new MainView();
//        JFrame frame = new JFrame("8-Puzzle Solver");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(view);
//        frame.pack();
//        frame.setVisible (true);


//        int seq = 125340678;
//        String seq = "102345678"; //solves
        String seq = "847632150"; //this one is a lot of trouble
//        int  seq = 847632015; //this one is a lot of trouble
//        String seq = "168403725";
//        String seq = "185647230";
        //int seq = controller.seq();


//        SearchAlgorithm<State> algo = new AStar(seq, CostType.MANHATTAN);
//        SearchAlgorithm<State> algo = new AStar(seq, CostType.EUCLIDEAN);
        SearchAlgorithm<State> algo = new BFS(seq);
//        SearchAlgorithm<State> algo = new DFS(seq);
        State finalState = algo.search();
        if (finalState == null) {
            System.out.println("Unsolvable");
        } else {

        System.out.println(finalState.getSequence());
        }
        //SearchAlgorithm<State> algo = new DFS(seq);

//        Controller controller = new Controller(view);


        /*Timer.tick();
        int res = algo.search();
        long time = Timer.tock();


        Controller.setOuts(algo,time);

        System.out.println("Finished in "+time+" Seconds");
        System.out.println("Search Depth = "+algo.searchDepth);
        System.out.println("Nodes expanded = "+algo.expandedNodesCount);

        if(res == -1) System.out.println("Unsolvable.");
        else {
            System.out.println("Cost = "+algo.sol.getCost());
            if(algo.sol.getCost() < 1000)
                System.out.println(algo.sol.traceback());
        }
//        List<State> children =  s.getPossibleChildren();
//
//        System.out.println((children.get(0).getCost()));
*/

    }
}
