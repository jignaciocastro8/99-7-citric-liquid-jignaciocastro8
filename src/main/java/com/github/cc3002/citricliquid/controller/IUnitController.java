package com.github.cc3002.citricliquid.controller;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;

import java.util.ArrayList;

public interface IUnitController {
    /**
     * Create a unit.
     * @param name Name.
     * @param hp Hp.
     * @param atk Atk.
     * @param def Def.
     * @param evd Evd.
     * @return ICharacter.
     */
    ICharacter createWild(String name, int hp, int atk, int def, int evd);
    /**
     * Create a unit.
     * @param name Name.
     * @param hp Hp.
     * @param atk Atk.
     * @param def Def.
     * @param evd Evd.
     * @return ICharacter.
     */
    ICharacter createBoss(String name, int hp, int atk, int def, int evd);
    /**
     * Getter of the units of the game.
     * @return ICharacter[]
     */
    ArrayList<ICharacter> getUnits();
}
