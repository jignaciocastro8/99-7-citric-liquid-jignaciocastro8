package com.github.cc3002.citricjuice.model.gameCharactersTest;

import com.github.cc3002.citricjuice.model.board.HomePanel;
import com.github.cc3002.citricjuice.model.gameCharacters.ICharacter;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest extends AbstractCharacterTest{
    private Player suguri;
    private Player marc;

    @BeforeEach
    public void setUp() {
        suguri = (Player) makeCharacter("Suguri", 4, 1, -1, 2);
        marc = (Player) makeCharacter("Marc", 4,1, 1, -1);
        marc.setHomePanel(new HomePanel(new int[]{0, 0}));
    }
    /**
     * Create Player.
     * @param name name of the Player.
     * @param hp hitting points.
     * @param atk the base damage of the Player.
     * @param def the base defense of the Player.
     * @param evd the base evasion of the Player.
     * @return Player.
     */
    @Override
    ICharacter makeCharacter(String name, int hp, int atk, int def, int evd) {
        return new Player(name, hp, atk, def, evd);
    }

    /**
     * Tests the constructor of PLayer class.
     */
    @Test
    public void constructorTest() {
        // Constructor without HomePanel.
        Player expectedSuguri = new Player("Suguri", 4, 1, -1, 2);
        assertEquals(expectedSuguri, suguri);
        // Constructor with HomePanel.
        HomePanel expectedPanel = new HomePanel(new int[]{0, 0});
        Player expectedMarc =  new Player("Marc", 4,1, 1, -1, expectedPanel);
        assertEquals(expectedMarc, marc);
    }

    /**
     * Tests equals method.
     */
    @Test
    public void testEquals() {
        final var o = new Object();
        assertNotEquals(suguri, o);
        assertEquals(suguri, suguri);
        final var expectedSuguri = new Player("Suguri", 4, 1, -1, 2);
        assertEquals(expectedSuguri, suguri);
    }

    /**
     * Tests norma getter.
     */
    @Test
    public void normaTest() {
        assertFalse(-1 == suguri.getNormaLevel());
        assertEquals(1, suguri.getNormaLevel());
    }

    /**
     * Tests the norma clear effect.
     */
    @Test
    public void normaClearTest() {
        suguri.normaClear();
        assertEquals(2, suguri.getNormaLevel());
        int currentNorma = suguri.getNormaLevel();
        suguri.normaClear();
        assertEquals(currentNorma + 1, suguri.getNormaLevel());
    }

    /**
     * Tests the player's HomePanel.
     */
    @Test
    public void homePanelPlayerTest() {
        HomePanel testHomePanel = new HomePanel(new int[]{0, 0});
        suguri.setHomePanel(testHomePanel);
        assertEquals(testHomePanel, suguri.getHomePanel());
    }

    /**
     * Tests copy method.
     */
    @Test
    public void copyTest() {
        final var expectedSuguri = new Player("Suguri", 4, 1, -1, 2);
        final var actualSuguri = suguri.copy();
        // Checks that the copied player have the same parameters as the original
        assertEquals(expectedSuguri, actualSuguri);
        // Checks that the copied player doesn't reference the same object
        assertNotSame(expectedSuguri, actualSuguri);
    }

    /**
     * Tests the consistency of the getter, setter and norma clear effect.
     */
    @RepeatedTest(100)
    public void normaClearConsistencyTest() {
        // We fix a seed for the pseudo random tests.
        final long testSeed = new Random().nextLong();
        // We fix a random number of iteration.
        final int iterations = Math.abs(new Random(testSeed).nextInt(6));
        // Norma will be augmented iterations times.
        final int expectedNorma = suguri.getNormaLevel() + iterations;
        for (int it = 0; it < iterations; it++) {
            suguri.normaClear();
        }
        assertEquals(expectedNorma, suguri.getNormaLevel(),
                "Test failed with random seed: " + testSeed);
    }

    /**
     * Tests atk modifier's method.
     */
    @Test
    public void atkTest() {
        int bound = 10;
        Random ran = new Random();
        for (int i=0; i<10; i++) {
            int initialAtk = suguri.getAtk();
            int amount = ran.nextInt(bound);
            int expectedAtk = initialAtk + amount;
            suguri.increaseAtk(amount);
            assertEquals(expectedAtk, suguri.getAtk());
        }
        for (int i=0; i<10; i++) {
            int initialAtk = suguri.getAtk();
            int amount = ran.nextInt(bound);
            int expectedAtk = initialAtk - amount;
            suguri.reduceAtk(amount);
            assertEquals(expectedAtk, suguri.getAtk());
        }
    }

    /**
     * Tests def modifier's method.
     */
    @Test
    public void defTest() {
        int bound = 10;
        Random ran = new Random();
        for (int i=0; i<10; i++) {
            int initialDef = suguri.getDef();
            int amount = ran.nextInt(bound);
            int expectedDef = initialDef + amount;
            suguri.increaseDef(amount);
            assertEquals(expectedDef, suguri.getDef());
        }
        for (int i=0; i<10; i++) {
            int initialDef = suguri.getDef();
            int amount = ran.nextInt(bound);
            int expectedDef = initialDef - amount;
            suguri.reduceDef(amount);
            assertEquals(expectedDef, suguri.getDef());
        }
    }

    /**
     * Tests evd modifier's method.
     */
    @Test
    public void evdTest() {
        int bound = 10;
        Random ran = new Random();
        for (int i=0; i<10; i++) {
            int initialEvd = suguri.getEvd();
            int amount = ran.nextInt(bound);
            int expectedEvd = initialEvd + amount;
            suguri.increaseEvd(amount);
            assertEquals(expectedEvd, suguri.getEvd());
        }
        for (int i=0; i<10; i++) {
            int initialEvd = suguri.getEvd();
            int amount = ran.nextInt(bound);
            int expectedEvd = initialEvd - amount;
            suguri.reduceEvd(amount);
            assertEquals(expectedEvd, suguri.getEvd());
        }
    }


    // AbstractCharacter test region.

    /**
     * Tests getter and setter of hp field.
     */
    @Test
    public void playerHpTest() {
        abstractHpTest(suguri);
        abstractHpTest(marc);
    }
    /**
     * Tests increase method.
     */
    @RepeatedTest(100)
    public void increasePlayerTest() {
        increaseConsistencyTest(suguri);
        increaseConsistencyTest(marc);
    }
    /**
     * Tests reduce method.
     */
    @RepeatedTest(100)
    public void reducePlayerTest() {
        reduceConsistencyTest(suguri);
        reduceConsistencyTest(marc);
    }
    /**
     * Test hp getter and setter consistency.
     */
    @RepeatedTest(100)
    public void hpConsistencyPlayerTest() {
        hitPointsConsistencyTest(suguri);
        hitPointsConsistencyTest(marc);
    }
    /**
     * Tests roll method.
     */
    @RepeatedTest(100)
    public void rollPlayerConsistencyTest() {
        rollConsistencyTest(suguri);
        rollConsistencyTest(marc);
    }

    // endregion


}
