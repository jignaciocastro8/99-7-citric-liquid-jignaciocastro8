package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.DropPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class DropPanelFactory implements IPanelFactory {
    @Override
    public IPanel createWithKey(int key) {
        return new DropPanel(key);
    }
}
