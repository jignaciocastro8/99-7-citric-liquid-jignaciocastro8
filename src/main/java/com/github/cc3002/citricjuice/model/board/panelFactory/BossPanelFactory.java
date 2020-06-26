package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.BossPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class BossPanelFactory implements IPanelFactory {
    @Override
    public IPanel createWithKey(int key) {
        return new BossPanel(key);
    }
}
