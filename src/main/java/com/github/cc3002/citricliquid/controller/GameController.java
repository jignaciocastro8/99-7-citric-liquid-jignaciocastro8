package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.factory.*;


import java.util.ArrayList;

public class GameController implements IGameController {

    private ICharacterFactory playerFactory =  new PlayerFactory();
    private ICharacterFactory wildFactory =  new WildFactory();
    private ICharacterFactory bossFactory =  new BossFactory();

    private ArrayList<ICharacter> characters = new ArrayList<ICharacter>();
    private Board board;

    public GameController(){}


    @Override
    public void createPlayer(String name, int hp, int atk, int def, int evd) {
        characters.add(playerFactory.create(name, hp, atk, def, evd));
    }

    @Override
    public void createBoss(String name, int hp, int atk, int def, int evd) {
        characters.add(bossFactory.create(name, hp, atk, def, evd));
    }

    @Override
    public void createWild(String name, int hp, int atk, int def, int evd) {
        characters.add(wildFactory.create(name, hp, atk, def, evd));
    }

    @Override
    public void createPanel() {

    }

    @Override
    public void assignNextPanel(IPanel panel) {

    }

    @Override
    public ArrayList<ICharacter> getCharacters() {
        return this.characters;
    }

    @Override
    public void createBoard(int rows, int cols) {
        this.board = new Board(rows, cols);
    }

    @Override
    public void createHomePanel(int row, int col) {

    }

    @Override
    public IPanel getBoardPanel(int row, int col) {
        return this.board.getPanel(row, col);
    }

    @Override
    public Board getBoard() {
        return this.board;
    }
}
