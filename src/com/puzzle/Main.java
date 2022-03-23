package com.puzzle;

import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] seq = {1,2,5,3,4,0,6,7,8};
//        int [] seq = {1,0,2,3,4,5,6,7,8};
                int [] seq = {8,4,7,6,3,2,1,5,0};

        SearchAlgorithm<State> algo = new DFS(seq);
        algo.search();
//
//        List<State> children =  s.getPossibleChildren();
//
//        System.out.println((children.get(0).getCost()));
    }
}
