package com.github.cc3002.citricjuice.model.gameCharacters.factory;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;

public interface ICharacterFactory {
    ICharacter create(String name, int hp, int atk, int def, int evd);
}
