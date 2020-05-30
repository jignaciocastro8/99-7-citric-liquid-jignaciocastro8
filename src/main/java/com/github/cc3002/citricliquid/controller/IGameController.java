package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;

public interface IGameController {
    IPanel createPanel();
    ICharacter createCharacter();
    void assignNextPanel(IPanel panel);
}
