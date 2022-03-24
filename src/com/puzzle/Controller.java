package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;
import com.puzzle.view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    static MainView view;
    static SearchAlgorithm algo;
    public Controller(MainView view)
    {
        this.view = view;
        this.view.getStartBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int seq = seq();
                algo = new AStar<State>(seq, CostType.MANHATTAN);

                Timer.tick();
                int res = algo.search();
                long time = Timer.tock();
                setOuts(algo,time);

                System.out.println("Finished in "+time+" Seconds");
                System.out.println("Search Depth = "+algo.searchDepth);
                System.out.println("Nodes expanded = "+algo.expandedNodesCount);

                if(res == -1) System.out.println("Unsolvable.");
                else {
                    System.out.println("Cost = "+algo.sol.getCost());
                    if(algo.sol.getCost() < 1000)
                        System.out.println(algo.sol.traceback());
                }
            }
        });
    }
    public static void setOuts(SearchAlgorithm algo, long time){

        view.getTime().setText(String.valueOf(time)+" Seconds");
        view.getCost().setText(String.valueOf(algo.sol.getCost()));
        view.getDepth().setText(String.valueOf(algo.searchDepth));
        view.getNodesExp().setText(String.valueOf(algo.expandedNodesCount));

    }
    public static int seq()
    {
        int [] arr = new int [9];
        for(int i = 0; i < 9; i++)
        {
            arr[i] = Integer.parseInt(view.getFields()[i].getText());
        }
        return Util.getSequenceFromArr(arr);
    }
}
