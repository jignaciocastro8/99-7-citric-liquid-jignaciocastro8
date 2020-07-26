package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.board.NeutralPanel;

public class NeutralPanelFactory implements IPanelFactory {
    @Override
    public IPanel createWithKey(int key) {
        return new NeutralPanel(key);
    }
}
