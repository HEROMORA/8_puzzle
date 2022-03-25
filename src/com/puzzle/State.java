package com.puzzle;

import com.puzzle.cost.CostFunction;
import com.puzzle.cost.CostType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class State {
    private static final String optimal = "012345678";

    private final State parent;
    private final String sequence;
    private final float cost;
    private final int zeroIndex;
    private final float costIncludingHeuristic;
    public final CostFunction costFunction;

    public State(String sequence, CostFunction costFunction) {
        this.sequence = sequence;
        this.cost = 0;
        this.costIncludingHeuristic = 0;
        this.zeroIndex = getZeroIndex();
        this.costFunction = costFunction;
        this.parent = this;
    }

    public State(String sequence, float cost, State parent, CostFunction costFunction, float costIncludingHeuristic) {
        this.sequence = sequence;
        this.zeroIndex = getZeroIndex();
        this.cost = cost;
        this.parent = parent;
        this.costFunction = costFunction;
        this.costIncludingHeuristic = costIncludingHeuristic;
    }


    public boolean isSameState(State other) {
        return this.sequence.equals(other.getSequence());
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

    public ArrayList<String> traceback()
    {
        ArrayList<String> arr = new ArrayList<>();
        State current = this;
        while (!current.getParent().getSequence().equals(current.getSequence())) {
            arr.add(current.getSequence());
            current = current.getParent();
        }

        return arr;
    }

    public String getSequence() {
        return sequence;
    }

    public boolean isGoal() {
        return Objects.equals(sequence, optimal);
    }

    public State getParent() {
        return parent;
    }

    public float getCost() {
        return cost;
    }

    public float getCostIncludingHeuristic() {
        return costIncludingHeuristic;
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
        return this.sequence.indexOf('0');
    }


    private State getNewState(int bias) {
        int idx = this.zeroIndex + bias;

        String newSequence = swap(this.sequence, this.zeroIndex, idx);

        float newCost = this.costFunction.calculateCost(this.cost, newSequence);
        float newCostIncludingHeuristic = this.costFunction.calculateCostWithHeuristic(newSequence, this.cost);
        return new State(newSequence, newCost, this, this.costFunction, newCostIncludingHeuristic);
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

    private String swap(String s, int a, int b) {
        char[] newArr = s.toCharArray();
        char temp = newArr[a];
        newArr[a] = newArr[b];
        newArr[b] = temp;

        return String.valueOf(newArr);
    }

}
