package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.IPanel;

public interface IPanelFactory {
    IPanel createWithKey(int key);
}
