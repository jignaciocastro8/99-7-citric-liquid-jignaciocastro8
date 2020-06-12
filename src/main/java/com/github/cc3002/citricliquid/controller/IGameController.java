package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.Board;
import com.github.cc3002.citricjuice.model.board.IBoard;
import com.github.cc3002.citricjuice.model.board.IPanel;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;

import java.util.ArrayList;
import java.util.Collection;

public interface IGameController {
    void createPlayer(String name, int hp, int atk, int def, int evd);

    void createBoss(String name, int hp, int atk, int def, int evd);

    void createWild(String name, int hp, int atk, int def, int evd);

    void assignNextPanel(IPanel panel);

    ArrayList<ICharacter> getCharacters();

    void createBoard();

    void createHomePanel(int key);

    IPanel getBoardPanel(int key);

    IBoard getBoard();

    void createBonusPanel(int key);

    void createBossPanel(int key);

    void createDrawPanel(int key);

    void createDropPanel(int key);

    void createEncounterPanel(int key);

    void createNeutralPanel(int key);
}
