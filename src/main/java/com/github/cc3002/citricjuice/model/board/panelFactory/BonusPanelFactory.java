package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.BonusPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class BonusPanelFactory implements IPanelFactory {
    public BonusPanelFactory() {}
    @Override
    public IPanel createWithKey(int key) {
        return new BonusPanel(key);
    }
}
