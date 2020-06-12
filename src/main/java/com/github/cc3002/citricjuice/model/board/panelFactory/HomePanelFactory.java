package com.github.cc3002.citricjuice.model.board.panelFactory;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

public class HomePanelFactory implements IPanelFactory{

    @Override
    public IPanel createWithKey(int key) {
        return new HomePanel(key);
    }

    public IPanel createWithOwner(int key, Player player) {
        HomePanel homePanel = new HomePanel(key);
        homePanel.setPlayerOwner(player);
        return homePanel;
    }
}
