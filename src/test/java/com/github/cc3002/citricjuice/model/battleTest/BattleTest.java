package com.github.cc3002.citricjuice.model.battleTest;

import com.github.cc3002.citricjuice.model.gameCharacters.BossUnit;
import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.WildUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTest {
    long testSeed;
    private Player suguri;
    private Player marc;
    private WildUnit chicken;
    private WildUnit seagull;
    private BossUnit flyingCastle;
    private BossUnit storeManager;
    @BeforeEach
    public void setUp() {
        // Create a seed.
        testSeed = new Random().nextLong();
        suguri = new Player("NAME", 4, 1, 1, -1);
        marc = new Player("Marc", 4,1, 1, -1);
        chicken = new WildUnit("Chicken", 3, -1, -1, +1);
        seagull = new WildUnit("Seagull", 3, 1, -1, -1);
        flyingCastle = new BossUnit("Flying Castle", 8, 1, -1, -2);
        storeManager = new BossUnit("Store Manager", 8, 3, 2, -1);
    }
    @RepeatedTest(100)
    public void defendTest() {
        // Generate a test roll with the test seed.
        int testRoll = new Random(testSeed).nextInt(6) + 1;
        // Set the character's seed to the test seed.
        marc.setSeed(testSeed);
        int atk = new Random().nextInt(200);
        int def = testRoll + marc.getDef();
        int expectedHp = Math.max(0, marc.getCurrentHP() - Math.max(1, atk - def));
        marc.defend(atk);
        assertEquals(expectedHp, marc.getCurrentHP());
    }
    @RepeatedTest(100)
    public void evadeTest() {
        // Generate a test roll with the test seed.
        int testRoll = new Random(testSeed).nextInt(6) + 1;
        // Set the character's seed to the test seed.
        flyingCastle.setSeed(testSeed);
        // Generate random attack.
        int atk = new Random().nextInt(200);
        int evd = testRoll + flyingCastle.getEvd();
        int previousHp = flyingCastle.getCurrentHP();
        flyingCastle.evade(atk);
        if (evd > atk) {
            assertEquals(previousHp, flyingCastle.getCurrentHP());
        }
        else {
            int expectedHp = Math.max(0, previousHp - atk);
            assertEquals(expectedHp, flyingCastle.getCurrentHP());
        }
    }
    @RepeatedTest(100)
    public void attackTest() {
        long seed1 = new Random().nextLong();
        long seed2 = new Random().nextLong();
        long seed3 = new Random().nextLong();
        Random decisionRan = new Random(seed1);
        chicken.setEvdOrDefSeed(seed1);
        Random attackerRan = new Random(seed2);
        suguri.setSeed(seed2);
        Random enemyRan = new Random(seed3);
        chicken.setSeed(seed3);
        // Save current HP.
        int currentHp = chicken.getCurrentHP();
        // Suguri's net attack.
        int netAtk = suguri.getAtk() + attackerRan.nextInt(6) + 1;
        // Decision.
        boolean defend = decisionRan.nextInt(2)  == 1;
        // Attack
        suguri.attack(chicken);
        if (defend) {
            // Chicken net defend.
            int netDef = chicken.getDef() + enemyRan.nextInt(6) + 1;
            int expectedHp = Math.max(0, currentHp - Math.max(1, netAtk - netDef));
            assertEquals(expectedHp, chicken.getCurrentHP());
        }
        else {
            // Chicken net evade.
            int netEvd = chicken.getEvd() + enemyRan.nextInt(6) + 1;
            if (netEvd > netAtk) {
                assertEquals(currentHp, chicken.getCurrentHP());
            }
            else {
                int expectedHp = Math.max(0, currentHp - netAtk);
                assertEquals(expectedHp, chicken.getCurrentHP());
            }
        }

    }
    @Test
    public void defeatTest() {
        // Chicken defeats Flying castle.
        int expectedStars = chicken.getStars() + (int) Math.floor(flyingCastle.getStars() * 0.5);
        int expectedWins = chicken.getWins() + 3;
        int loserExpectedStars = flyingCastle.getStars() - (int) Math.floor(flyingCastle.getStars() * 0.5);
        chicken.defeat(flyingCastle);
        assertEquals(expectedStars, chicken.getStars());
        assertEquals(expectedWins, chicken.getWins());
        assertEquals(loserExpectedStars, flyingCastle.getStars());
        // Flying castle defeats Chicken.
        expectedStars = flyingCastle.getStars() + (int) (chicken.getStars() * 0.5);
        expectedWins = flyingCastle.getWins() + 1;
        loserExpectedStars = chicken.getStars() - (int) (chicken.getStars() * 0.5);
        flyingCastle.defeat(chicken);
        assertEquals(expectedStars, flyingCastle.getStars());
        assertEquals(expectedWins, flyingCastle.getWins());
        assertEquals(loserExpectedStars, chicken.getStars());
        // Marc defeats Chicken.
        expectedStars = marc.getStars() + chicken.getStars();
        expectedWins = marc.getWins() + 1;
        loserExpectedStars = 0;
        marc.defeat(chicken);
        assertEquals(expectedStars, marc.getStars());
        assertEquals(expectedWins, marc.getWins());
        assertEquals(loserExpectedStars, chicken.getStars());
        // Marc defeats Flying Castle.
        expectedStars = marc.getStars() + flyingCastle.getStars();
        expectedWins = marc.getWins() + 3;
        loserExpectedStars = 0;
        marc.defeat(flyingCastle);
        assertEquals(expectedStars, marc.getStars());
        assertEquals(expectedWins, marc.getWins());
        assertEquals(loserExpectedStars, flyingCastle.getStars());
        // Suguri defeats Marc.
        expectedStars = suguri.getStars() + (int) Math.floor(marc.getStars() * 0.5);
        expectedWins = suguri.getWins() + 2;
        loserExpectedStars = marc.getStars() - (int) Math.floor(marc.getStars() * 0.5);
        suguri.defeat(marc);
        assertEquals(expectedStars, suguri.getStars());
        assertEquals(expectedWins, suguri.getWins());
        assertEquals(loserExpectedStars, marc.getStars());
        // Flying Castle defeats Suguri.
        expectedStars = flyingCastle.getStars() + (int) Math.floor(suguri.getStars() * 0.5);
        expectedWins = flyingCastle.getWins() + 2;
        loserExpectedStars = suguri.getStars() - (int) Math.floor(suguri.getStars() * 0.5);
        flyingCastle.defeat(suguri);
        assertEquals(expectedStars, flyingCastle.getStars());
        assertEquals(expectedWins, flyingCastle.getWins());
        assertEquals(loserExpectedStars, suguri.getStars());
        // Chicken defeats Marc.
        expectedStars = chicken.getStars() + (int) Math.floor(marc.getStars() * 0.5);
        expectedWins = chicken.getWins() + 2;
        loserExpectedStars = marc.getStars() - (int) Math.floor(marc.getStars() * 0.5);
        chicken.defeat(marc);
        assertEquals(expectedStars, chicken.getStars());
        assertEquals(expectedWins, chicken.getWins());
        assertEquals(loserExpectedStars, marc.getStars());
        // Chicken defeats Seagull.
        expectedStars = chicken.getStars() + (int) Math.floor(seagull.getStars() * 0.5);
        expectedWins = chicken.getWins() + 1;
        loserExpectedStars = seagull.getStars() - (int) Math.floor(seagull.getStars() * 0.5);
        chicken.defeat(seagull);
        assertEquals(expectedStars, chicken.getStars());
        assertEquals(expectedWins, chicken.getWins());
        assertEquals(loserExpectedStars, seagull.getStars());
        // Store Manager defeats Flying Castle.
        expectedStars = storeManager.getStars() + (int) Math.floor(flyingCastle.getStars() * 0.5);
        expectedWins = storeManager.getWins() + 3;
        loserExpectedStars = flyingCastle.getStars() - (int) Math.floor(flyingCastle.getStars() * 0.5);
        storeManager.defeat(flyingCastle);
        assertEquals(expectedStars, storeManager.getStars());
        assertEquals(expectedWins, storeManager.getWins());
        assertEquals(loserExpectedStars, flyingCastle.getStars());
    }
}
