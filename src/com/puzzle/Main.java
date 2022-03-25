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

       MainView view = new MainView();
       JFrame frame = new JFrame("8-Puzzle Solver");
       frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().add(view);
       frame.pack();
       frame.setVisible (true);


//        int seq = 125340678;
//        String seq = "102345678"; 
        // String seq = "847632150";
//        int  seq = 847632015; 
//        String seq = "168403725";
//        String seq = "185647230";


       Controller controller = new Controller(view);

    }
}
