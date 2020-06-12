package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.EncounterPanel;
import com.github.cc3002.citricjuice.model.board.IPanel;

public class EncounterPanelFactory implements IPanelFactory {
    @Override
    public IPanel createWithKey(int key) {
        return new EncounterPanel(key);
    }
}
