package com.puzzle;

import com.puzzle.cost.CostFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class State {
    private static final int[] optimal = {0,1,2,3,4,5,6,7,8};

    private State parent;
    private final int[] sequence;
    private final int cost;
    private final int zeroIndex;
    private final CostFunction costFunction;

    public State(int[] sequence, CostFunction costFunction) {
        this.sequence = sequence;
        this.cost = 0;
        this.zeroIndex = getZeroIndex();
        this.costFunction = costFunction;
    }

    public State(int[] sequence, int cost, State parent, CostFunction costFunction) {
        this.sequence = sequence;
        this.zeroIndex = getZeroIndex();
        this.cost = cost;
        this.parent = parent;
        this.costFunction = costFunction;
    }

    public int[] getSequence() {
        return sequence;
    }

    public boolean isSameState(State other) {
        return Arrays.equals(this.sequence, other.sequence);
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
        return Arrays.equals(sequence, optimal);
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
        for (int i = 0; i < this.sequence.length; i++) {
            if (this.sequence[i] == 0) {
                return i;
            }
        }

        return -1;
    }


    private State getNewState(int bias) {
        int idx = this.zeroIndex + bias;
        int[] newStateArr = swap(sequence, this.zeroIndex, idx);
        int newCost = this.costFunction.calculateCost(this.cost, this.sequence);
        return new State(newStateArr, newCost, this, this.costFunction);
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
        return newArr;
    }
}
