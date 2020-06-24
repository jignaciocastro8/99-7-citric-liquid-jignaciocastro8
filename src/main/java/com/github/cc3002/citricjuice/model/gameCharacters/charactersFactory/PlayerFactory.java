package com.github.cc3002.citricjuice.model.gameCharacters.charactersFactory;

import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.IPlayer;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;

public class PlayerFactory implements IPlayerFactory {


    @Override
    public IPlayer create(String name, int hp, int atk, int def, int evd) {
        return new Player(name, hp, atk, def, evd);
    }
}
