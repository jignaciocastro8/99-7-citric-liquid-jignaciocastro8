package com.github.cc3002.citricjuice.model.gameCharactersTest.charactersFactoryTest;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.ICharacterFactory;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.PlayerFactory;
import org.junit.jupiter.api.Test;

public class PlayerFactoryTest extends AbstractCharacterFactoryTest {

    /**
     * Makes an abstract factory.
     * @return ICharacterFactory.
     */
    @Override
    public ICharacterFactory makeCharacterFactory() {
        return new PlayerFactory();
    }

    /**
     * Makes a character in classical way (Without factory).
     *
     * @param name Character's name.
     * @param hp Character's hp.
     * @param atk Character's atk.
     * @param def Character's def.
     * @param evd Character's evd.
     * @return ICharacter.
     */
    @Override
    public ICharacter makeCharacter(String name, int hp, int atk, int def, int evd) {
        return new Player(name, hp, atk, def, evd);
    }

    @Override
    @Test
    public void createTest() {
        abstractCreateWithKeyTest();
    }
}
