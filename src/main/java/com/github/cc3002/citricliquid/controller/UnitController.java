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
     */
    @Override
    public void createBoss(String name, int hp, int atk, int def, int evd) {
        this.units.add(bossFactory.create(name, hp, atk, def, evd));
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
     */
    @Override
    public void createWild(String name, int hp, int atk, int def, int evd) {
        this.units.add(wildFactory.create(name, hp, atk, def, evd));
    }
}
