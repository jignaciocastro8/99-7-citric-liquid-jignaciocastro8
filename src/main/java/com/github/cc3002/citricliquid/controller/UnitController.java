package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.BossFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.ICharacterFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.WildFactory;

import java.util.ArrayList;

public class UnitController implements IUnitController {

    private ICharacterFactory wildFactory =  new WildFactory();
    private ArrayList<ICharacter> units;
    private ICharacterFactory bossFactory =  new BossFactory();

    public UnitController() {
        this.units = new ArrayList<>();
    }

    /**
     * Create a boss unit.
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     * @return ICharacter.
     */
    @Override
    public ICharacter createBoss(String name, int hp, int atk, int def, int evd) {
        ICharacter boss = bossFactory.create(name, hp, atk, def, evd);
        this.units.add(boss);
        return boss;
    }

    /**
     * Getter of the units of the game.
     *
     * @return ICharacter[]
     */
    @Override
    public ArrayList<ICharacter> getUnits() {
        return this.units;
    }

    /**
     * Create a wild unit.
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     * @return ICharacter.
     */
    @Override
    public ICharacter createWild(String name, int hp, int atk, int def, int evd) {
        ICharacter wild = wildFactory.create(name, hp, atk, def, evd);
        this.units.add(wild);
        return wild;
    }
}
