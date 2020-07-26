package com.github.cc3002.citricjuice.model.gameCharacters;

import java.util.Random;

public abstract class AbstractUnit extends AbstractCharacter {
    private Random evdOrDefRan;
    public AbstractUnit(String name, int maxHp, int atk, int def, int evd){
        super(name, maxHp, atk, def, evd);
        evdOrDefRan = new Random();
    }
    public void setEvdOrDefSeed(long seed) {
        this.evdOrDefRan.setSeed(seed);
    }

    /**
     * Makes the random decision of evade or defend.
     * @return False: Evade, True: Defend.
     */
    public boolean evdOrDef() {
        return this.evdOrDefRan.nextInt(2) == 1;
    }



    /**
     * Receive the attack. Makes the decision of evade or defend.
     * @param netAtk int
     */
    public void receiveAtk(int netAtk) {
        boolean defend = this.evdOrDef();
        if (defend) {
            this.defend(netAtk);
        }
        else {
            this.evade(netAtk);
        }
    }
}
