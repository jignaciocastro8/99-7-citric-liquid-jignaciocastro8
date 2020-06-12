package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.DrawPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class DrawPanelFactory implements IPanelFactory {
    @Override
    public IPanel createWithKey(int key) {
        return new DrawPanel(key);
    }
}
