package com.puzzle.view;

import java.awt.*;
import javax.swing.*;

public class MainView extends JPanel {

    private JTextField[] fields = new JTextField[9];

    private JComboBox algoBox;
    private JButton startBtn;
    private JCheckBox traceBackEnable;
    private JButton nxtStepBtn;
    private JLabel timeLbl;
    private JLabel costLbl;
    private JLabel depthLbl;
    private JLabel nodesExpLbl;
    private JLabel time;
    private JLabel cost;
    private JLabel depth;
    private JLabel nodesExp;

    public MainView() {
        //construct preComponents
        String[] algos = {"A* | Manhattan", "A* | Euclidean", "BFS", "DFS"};

        //construct components
        for (int i = 0; i < 9; i++)
            fields[i] = new JTextField(1);

        algoBox = new JComboBox(algos);
        startBtn = new JButton("Solve");
        traceBackEnable = new JCheckBox("View Steps");
        nxtStepBtn = new JButton("Next Step");
        timeLbl = new JLabel("Time");
        costLbl = new JLabel("Cost");
        depthLbl = new JLabel("Search Depth");
        nodesExpLbl = new JLabel("Nodes Expanded");
        time = new JLabel("0");
        cost = new JLabel("0");
        depth = new JLabel("0");
        nodesExp = new JLabel("0");

        //adjust size and set layout
        setPreferredSize(new Dimension(360, 391));
        setLayout(null);

        //add components
        for (int i = 0; i < 9; i++)
            add(fields[i]);
        add(algoBox);
        add(startBtn);
        add(traceBackEnable);
        add(nxtStepBtn);
        add(timeLbl);
        add(costLbl);
        add(depthLbl);
        add(nodesExpLbl);
        add(time);
        add(cost);
        add(depth);
        add(nodesExp);

        //set component bounds (only needed by Absolute Positioning)
        int x;
        int y;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x = 30 + 105 * i;
                y = 40 + 30 * j;
                fields[j * 3 + i].setBounds(x, y, 100, 25);
            }
        }

        algoBox.setBounds(30, 140, 100, 25);
        startBtn.setBounds(240, 140, 100, 25);
        traceBackEnable.setBounds(30, 180, 100, 25);
        nxtStepBtn.setBounds(240, 180, 100, 25);
        timeLbl.setBounds(35, 220, 100, 25);
        costLbl.setBounds(35, 260, 100, 25);
        depthLbl.setBounds(35, 300, 100, 25);
        nodesExpLbl.setBounds(35, 340, 100, 25);
        time.setBounds(240, 220, 100, 25);
        cost.setBounds(240, 260, 100, 25);
        depth.setBounds(240, 300, 100, 25);
        nodesExp.setBounds(240, 340, 100, 25);
    }

    public JTextField[] getFields() {
        return fields;
    }

    public void setFields(JTextField[] fields) {
        this.fields = fields;
    }

    public JComboBox getAlgoBox() {
        return algoBox;
    }

    public void setAlgoBox(JComboBox algoBox) {
        this.algoBox = algoBox;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(JButton startBtn) {
        this.startBtn = startBtn;
    }

    public JCheckBox getTraceBackEnable() {
        return traceBackEnable;
    }

    public void setTraceBackEnable(JCheckBox traceBackEnable) {
        this.traceBackEnable = traceBackEnable;
    }

    public JButton getNxtStepBtn() {
        return nxtStepBtn;
    }

    public void setNxtStepBtn(JButton nxtStepBtn) {
        this.nxtStepBtn = nxtStepBtn;
    }

    public JLabel getTimeLbl() {
        return timeLbl;
    }

    public void setTimeLbl(JLabel timeLbl) {
        this.timeLbl = timeLbl;
    }

    public JLabel getCostLbl() {
        return costLbl;
    }

    public void setCostLbl(JLabel costLbl) {
        this.costLbl = costLbl;
    }

    public JLabel getDepthLbl() {
        return depthLbl;
    }

    public void setDepthLbl(JLabel depthLbl) {
        this.depthLbl = depthLbl;
    }

    public JLabel getNodesExpLbl() {
        return nodesExpLbl;
    }

    public void setNodesExpLbl(JLabel nodesExpLbl) {
        this.nodesExpLbl = nodesExpLbl;
    }

    public JLabel getTime() {
        return time;
    }

    public void setTime(JLabel time) {
        this.time = time;
    }

    public JLabel getCost() {
        return cost;
    }

    public void setCost(JLabel cost) {
        this.cost = cost;
    }

    public JLabel getDepth() {
        return depth;
    }

    public void setDepth(JLabel depth) {
        this.depth = depth;
    }

    public JLabel getNodesExp() {
        return nodesExp;
    }

    public void setNodesExp(JLabel nodesExp) {
        this.nodesExp = nodesExp;
    }
}
