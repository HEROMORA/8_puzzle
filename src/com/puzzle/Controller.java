package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;
import com.puzzle.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
   static MainView view;
   static SearchAlgorithm<State> algo;
   static ArrayList<String> traceback;




   public Controller(MainView view)
   {
       this.view = view;
       traceback = new ArrayList<String>();
       this.view.getStartBtn().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               String seq = seq();
               String  algochoice = (String) view.getAlgoBox().getSelectedItem();

               switch (algochoice){

                   case "A* | Euclidean":
                       algo = new AStar(seq, CostType.EUCLIDEAN);
                       break;
                   case "BFS":
                       algo = new BFS(seq);
                       break;
                   case "DFS":
                       algo = new DFS(seq);
                       break;
                   default:
                       algo = new AStar(seq, CostType.MANHATTAN);
                       break;

               }

               Timer.tick();
               State resultState = algo.search();
               long time = Timer.tock();

               if( resultState != null) {
                   float cost = resultState.getCost();
                   ArrayList<String> resultTraceback = resultState.traceback();

                   System.out.println("Cost = "+ cost);

                   if(cost < 1000)
                       System.out.println(resultTraceback);

                   setOuts(algo, cost, time);
                   traceback = resultTraceback;

                   traceback.remove(0);
               }else {
                   System.out.println("Unsolvable.");
                   setOutsNoSol(algo, time);
                   JOptionPane.showMessageDialog(null, "Unable To Solve!");
               }

               System.out.println("Finished in "+time+" Seconds");
               System.out.println("Search Depth = "+algo.searchDepth);
               System.out.println("Nodes expanded = "+algo.expandedNodesCount);

               if( view.getTraceBackEnable().isSelected()) {
                   view.getNxtStepBtn().addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           if (!traceback.isEmpty()) {
                               setSeq(traceback.get(0));
                               traceback.remove(0);
                           }
                       }
                   });
               }else if (! traceback.isEmpty())
                   setSeq(traceback.get(traceback.size() - 1));


           }

       });


   }
   public static void setOuts(SearchAlgorithm<State> algo, float cost, long time){

       view.getTime().setText(String.valueOf(time)+" Seconds");
       view.getCost().setText(String.valueOf(cost));
       view.getDepth().setText(String.valueOf(algo.searchDepth));
       view.getNodesExp().setText(String.valueOf(algo.expandedNodesCount));

   }
   public static void setOutsNoSol(SearchAlgorithm<State> algo, long time){

       view.getTime().setText(String.valueOf(time)+" Seconds");
       view.getDepth().setText(String.valueOf(algo.searchDepth));
       view.getNodesExp().setText(String.valueOf(algo.expandedNodesCount));

   }
   public static String seq()
   {
       String[] arr = new String[9];
       for(int i = 0; i < 9; i++)
       {
           arr[i] = view.getFields()[i].getText();
       }
       return Util.getSequenceFromArr(arr);
   }
   public void setSeq(String seq)
   {
       int [] arr = Util.getArrSequence(seq);
       for(int i = 0; i < 9; i++) {
           this.view.getFields()[i].setText(String.valueOf(arr[i]));
       }
   }


}
