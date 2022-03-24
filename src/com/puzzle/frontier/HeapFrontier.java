package com.puzzle.frontier;

import com.puzzle.State;

import java.util.PriorityQueue;

public class HeapFrontier implements Frontier<State> {

    private final PriorityQueue<State> heap;

    public HeapFrontier(State initialState) {
        heap = new PriorityQueue<>(100,new StateComparator());
        heap.add(initialState);
    }

    @Override
    public void add(State obj) {
        // TODO check if it works on all cases
//        for (State state : heap) {
//            if (state.equals(obj)) {
//                if (state.getCost() > obj.getCost()) {
//                    heap.remove(state);
//                }
//                return;
//            }
//        }
        heap.add(obj);
    }

    @Override
    public State extract() {
        return heap.poll();
    }

    @Override
    public boolean contains(State obj) {
        for(State state: heap){
            if(state.isSameState(obj)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void decreaseKey(State state) {
        // TODO: decrease key
    }
}
