package com.puzzle;

import com.puzzle.cost.CostFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class State {
    private static final int optimal = 12345678;

    private State parent;
    private final int sequence;
    private final int cost;
    private final int zeroIndex;
    private final CostFunction costFunction;

    public State(int sequence, CostFunction costFunction) {
        this.sequence = sequence;
        this.cost = 0;
        this.zeroIndex = getZeroIndex();
        this.costFunction = costFunction;
    }

    public State(int sequence, int cost, State parent, CostFunction costFunction) {
        this.sequence = sequence;
        this.zeroIndex = getZeroIndex();
        this.cost = cost;
        this.parent = parent;
        this.costFunction = costFunction;
    }

    public int getSequence() {
        return sequence;
    }

    public boolean isSameState(State other) {
        return this.sequence == other.sequence;
    }

    public List<State> getPossibleChildren() {
        List<State> states = new ArrayList<>();

        if (canMoveUp()) {
            states.add(moveUp());
        }

        if (canMoveDown()) {
            states.add(moveDown());
        }

        if (canMoveLeft()) {
            states.add(moveLeft());
        }

        if (canMoveRight()) {
            states.add(moveRight());
        }

        return states;
    }

    public boolean isGoal() {
        return sequence == optimal;
    }

    public State getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    private boolean canMoveUp() {
        return zeroIndex > 2;
    }

    private boolean canMoveDown() {
        return zeroIndex < 6;
    }

    private boolean canMoveRight() {
        return ((zeroIndex + 1)  % 3) != 0;
    }

    private boolean canMoveLeft() {
        return (zeroIndex % 3) != 0;
    }

    private int getZeroIndex() {
        int seq = this.sequence;
        if (seq < 100000000) return 8;
        for (int i = 0; i < 9; i++) {
            if (seq%10 == 0) {
                return 8 - i;
            }
            seq = seq/10;
        }

        return -1;
    }


    private State getNewState(int bias) {
        int idx = this.zeroIndex + bias;
        int [] numbers = Util.getArrSequence(this.sequence);
        int[] newStateArr = swap(numbers, this.zeroIndex, idx);

        /*FOR DEBUGGING ONLY, TODO:REMOVE LATER*/
        int zerocount = 0;
        for(int i : newStateArr)
        {
            if (i == 0) zerocount++;
        }
        if (zerocount > 1)
        {
            System.err.println("2 zeros!!");
            exit(0);
        }
        int newSequence = newStateArr[0];
        for (int i = 1; i<newStateArr.length ; i++) {
            newSequence = newSequence*10;
            newSequence = newSequence + newStateArr[i];
        }

        int newCost = this.costFunction.calculateCost(this.cost, newSequence);
        return new State(newSequence, newCost, this, this.costFunction);
    }


    private State moveUp() {
        return getNewState(-3);
    }

    private State moveDown() {
        return getNewState(3);
    }

    private State moveLeft() {
        return getNewState(-1);
    }

    private State moveRight() {
        return getNewState(1);
    }

    private int[] swap(int[] arr, int a, int b) {
        int[] newArr = arr.clone();
        int temp = newArr[a];
        newArr[a] = newArr[b];
        newArr[b] = temp;
        /*FOR DEBUGGING ONLY, TODO:REMOVE LATER*/
        int zerocount = 0;
        for(int i : newArr)
        {
            if (i == 0) zerocount++;
        }
        if (zerocount > 1)
        {
            System.err.println("2 zeros!!");
        }
        return newArr;
    }
}
