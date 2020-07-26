package com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory;

import com.github.cc3002.citricjuice.model.gameCharacters.BossUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;

public class BossFactory implements ICharacterFactory {

    @Override
    public ICharacter create(String name, int hp, int atk, int def, int evd) {
        return new BossUnit(name, hp, atk, def, evd);
    }
}
