package com.github.cc3002.citricjuice.model.gameCharactersTest;

import com.github.cc3002.citricjuice.model.gameCharacters.CharacterInterface;
import com.github.cc3002.citricjuice.model.gameCharacters.WildUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WildUnitTest extends AbstractCharacterTest {
    private WildUnit chicken;
    private WildUnit seagull;



    @BeforeEach
    public void setUp() {
        chicken = (WildUnit) makeCharacter("Chicken", 3, -1, -1, 1);
        seagull = (WildUnit) makeCharacter("Seagull", 3, 1, -1, -1);
    }
    /**
     * Create WildUnit.
     * @param name name of the Wild.
     * @param hp hitting points.
     * @param atk the base damage the Wild does.
     * @param def the base defense if the Wild.
     * @param evd the base evasion of the Wild.
     * @return WildUnit.
     */
    @Override
    public CharacterInterface makeCharacter(String name, int hp, int atk, int def, int evd) {
        return new WildUnit(name, hp, atk, def, evd);
    }

    /**
     * Tests the WildUnit constructor.
     */
    @Test
    public void constructorTest() {
        WildUnit expectedChicken = new WildUnit("Chicken", 3, -1, -1, 1);
        assertEquals(expectedChicken, chicken);
        WildUnit expectedSeagull = new WildUnit("Seagull", 3, 1, -1, -1);
        assertEquals(expectedSeagull, seagull);
    }

    /**
     * Tests getter and setter of hp field.
     */
    @Test
    public void wildHpTest() {
        abstractHpTest(chicken);
        abstractHpTest(seagull);
    }

    /**
     * Tests increase method.
     */
    @RepeatedTest(100)
    public void increaseWildTest() {
        increaseConsistencyTest(chicken);
        increaseConsistencyTest(seagull);
    }

    /**
     * Tests reduce method.
     */
    @RepeatedTest(100)
    public void reduceWildTest() {
        reduceConsistencyTest(chicken);
        reduceConsistencyTest(seagull);
    }

    /**
     * Test hp getter and setter consistency.
     */
    @RepeatedTest(100)
    public void hpConsistencyWildTest() {
        hitPointsConsistencyTest(chicken);
        hitPointsConsistencyTest(seagull);
    }

    /**
     * Tests roll method.
     */
    @RepeatedTest(100)
    public void rollWildConsistencyTest() {
        rollConsistencyTest(chicken);
        rollConsistencyTest(seagull);
    }

    /**
     * Tests equals method.
     */
    @Test
    public void testEquals() {
        final var o = new Object();
        assertNotEquals(chicken, o);
        assertEquals(chicken, chicken);
        final var expectedChicken = new WildUnit("Chicken", 3, -1, -1, 1);
        assertEquals(expectedChicken, chicken);
    }


}
