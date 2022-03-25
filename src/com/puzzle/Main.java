package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;
import com.puzzle.view.MainView;
import com.puzzle.Controller;

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
        // String seq = "847632150"; //this one is a lot of trouble
//        int  seq = 847632015; //this one is a lot of trouble
//        String seq = "168403725";
//        String seq = "185647230";
        // int seq = controller.seq();


//        SearchAlgorithm<State> algo = new AStar(seq, CostType.MANHATTAN);
//        SearchAlgorithm<State> algo = new AStar(seq, CostType.EUCLIDEAN);
        // SearchAlgorithm<State> algo = new BFS(seq);
//        SearchAlgorithm<State> algo = new DFS(seq);
//         State finalState = algo.search();
//         if (finalState == null) {
//             System.out.println("Unsolvable");
//         } else {

//         System.out.println(finalState.getSequence());
//         }
        // SearchAlgorithm<State> algo = new DFS(seq);

//        Controller controller = new Controller(view);


        // Timer.tick();
        // State res = Controller.algo.search();
        // long time = Timer.tock();


        // Controller.setOuts(Controller.algo, res.getCost(),time);

        // System.out.println("Finished in "+time+" Seconds");
        // System.out.println("Search Depth = "+Controller.algo.searchDepth);
        // System.out.println("Nodes expanded = "+Controller.algo.expandedNodesCount);

        // if(res == null) {
        //         System.out.println("Unsolvable.");
        // } else {
        //     System.out.println("Cost = "+res.getCost());
        //     if(res.getCost() < 1000)
        //         System.out.println(res.traceback());
        // }


    }
}
