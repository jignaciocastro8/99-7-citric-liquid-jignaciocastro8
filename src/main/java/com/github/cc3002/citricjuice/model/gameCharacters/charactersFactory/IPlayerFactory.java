package com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory;

import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;

public interface IPlayerFactory extends ICharacterFactory {
    /**
     *
     * @param name Name of the character.
     * @param hp Hp of the character.
     * @param atk Atk of the character.
     * @param def Def of the character.
     * @param evd Evd of the character.
     * @return IPlayer.
     */
    IPlayer create(String name, int hp, int atk, int def, int evd);
}
