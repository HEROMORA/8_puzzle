package com.puzzle;

import com.puzzle.view.MainView;

public class Controller {
    MainView view;
    public Controller(MainView view)
    {
        this.view = view;
    }
    public static void setOuts(State sol, long time){
        view.setTime(time);
        view.setTime(time);

    }
}
