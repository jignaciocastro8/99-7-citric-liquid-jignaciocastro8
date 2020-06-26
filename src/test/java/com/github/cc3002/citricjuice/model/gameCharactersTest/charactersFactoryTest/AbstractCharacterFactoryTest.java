package com.github.cc3002.citricjuice.model.gameCharactersTest.charactersFactoryTest;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory.ICharacterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractCharacterFactoryTest implements ICharacterFactoryTest {
    /**
     * Makes an abstract factory.
     * @return ICharacterFactory.
     */
    public abstract ICharacterFactory makeCharacterFactory();

    /**
     * Makes a character in classical way (Without factory).
     * @return ICharacter.
     */
    public abstract ICharacter makeCharacter(String name, int hp, int atk, int def, int evd);

    /**
     * Method that tests character creation by a ICharacterFactory.
     */
    public void abstractCreateWithKeyTest() {
        ICharacterFactory factory = makeCharacterFactory();
        for (int i = 0; i < 10; i++) {
            ICharacter expectedCharacter = makeCharacter("Name" + i, i, i, i, i);
            assertEquals(expectedCharacter, factory.create("Name" + i, i, i, i, i));
        }
    }
}
