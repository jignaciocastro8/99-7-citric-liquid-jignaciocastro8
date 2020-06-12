package com.github.cc3002.citricjuice.model.board;

public interface IBoard {
    IPanel getPanel(int key);
    void addPanel(IPanel panel);
    int numberOfPanels();
}
