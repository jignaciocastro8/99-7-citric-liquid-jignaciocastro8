package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.board.*;
import com.github.cc3002.citricjuice.model.board.panelFactory.*;
import com.github.cc3002.citricjuice.model.board.panelFactory.IPanelFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.*;


import java.util.ArrayList;

public class GameController implements IGameController {

    private ICharacterFactory playerFactory =  new PlayerFactory();
    private ICharacterFactory wildFactory =  new WildFactory();
    private ICharacterFactory bossFactory =  new BossFactory();

    private IPanelFactory bonusPanelFactory = new BonusPanelFactory();
    private IPanelFactory bossPanelFactory = new BossPanelFactory();
    private IPanelFactory drawPanelFactory = new DrawPanelFactory();
    private IPanelFactory dropPanelFactory = new DropPanelFactory();
    private IPanelFactory encounterPanelFactory = new EncounterPanelFactory();
    private IPanelFactory homePanelFactory = new HomePanelFactory();
    private IPanelFactory neutralPanelFactory = new NeutralPanelFactory();

    private ArrayList<ICharacter> characters = new ArrayList<ICharacter>();
    private IBoard board = new Board();

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
    public void assignNextPanel(IPanel panel) {

    }

    @Override
    public ArrayList<ICharacter> getCharacters() {
        return this.characters;
    }

    @Override
    public void createBoard() {
        this.board = (IBoard) new Board();
    }


    @Override
    public IPanel getBoardPanel(int key) {
        return this.board.getPanel(key);
    }

    @Override
    public IBoard getBoard() {
        return this.board;
    }

    @Override
    public void createHomePanel(int key) {
        this.board.addPanel(homePanelFactory.createWithKey(key));
    }

    @Override
    public void createBonusPanel(int key) {
        this.board.addPanel(bonusPanelFactory.createWithKey(key));
    }

    @Override
    public void createBossPanel(int key) {
        this.board.addPanel(bossPanelFactory.createWithKey(key));
    }

    @Override
    public void createDrawPanel(int key) {
        this.board.addPanel(drawPanelFactory.createWithKey(key));
    }

    @Override
    public void createDropPanel(int key) {
        this.board.addPanel(dropPanelFactory.createWithKey(key));

    }

    @Override
    public void createEncounterPanel(int key) {
        this.board.addPanel(encounterPanelFactory.createWithKey(key));

    }

    @Override
    public void createNeutralPanel(int key) {
        this.board.addPanel(neutralPanelFactory.createWithKey(key));

    }
}
