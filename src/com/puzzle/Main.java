package com.puzzle;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] seq = {9,0,2,4,3,6,1,8,5};
        State s = new State(seq);

        List<State> children =  s.getPossibleChildren();

        System.out.println((children.get(0).getCost()));
    }
}
