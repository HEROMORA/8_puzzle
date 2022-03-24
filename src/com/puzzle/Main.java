package com.puzzle;

import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //int seq = 125340678;
        //int seq = 102345678; //solves
        //int  seq = 847632150; this one is a lot of trouble
        //int seq = 168403725;
        int seq = 185647230;

        SearchAlgorithm<State> algo = new BFS(seq);
        if(algo.search() == -1) System.out.println("Unsolvable");
//
//        List<State> children =  s.getPossibleChildren();
//
//        System.out.println((children.get(0).getCost()));
    }
}
