package com.github.cc3002.citricjuice.model.gameCharacters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BossUnitTest extends AbstractCharacterTest{
    private BossUnit flyingCastle;
    private BossUnit shifuRobot;

    /**
     * Creates test BossUnits.
     */
    @BeforeEach
    public void setUp() {
        flyingCastle = (BossUnit) makeCharacter("Flying Castle", 8, 1, -1, -2);
        shifuRobot = (BossUnit) makeCharacter("Shifu Robot", 5,1,0,-1);
    }

    /**
     * Create BossUnit.
     * @param name name of the Boss
     * @param hp hitting points.
     * @param atk the base damage the Boss does.
     * @param def the base defense if the Boss.
     * @param evd the base evasion of the Boss.
     * @return BossUnit.
     */
    @Override
    CharacterInterface makeCharacter(String name, int hp, int atk, int def, int evd) {
        return new BossUnit(name, hp, atk, def, evd);
    }

    /**
     * Tests the BossUnit class constructor.
     */
    @Test
    public void constructorTest() {
        BossUnit expectedShifuRobot = new BossUnit("Shifu Robot", 5, 1, 0, -1);
        assertEquals(expectedShifuRobot, shifuRobot);
    }

    /**
     * Test equals method.
     */
    @Test
    public void testEquals() {
        final var o = new Object();
        assertNotEquals(shifuRobot, o);
        assertEquals(shifuRobot, shifuRobot);
        final var expectedShifuRobot = new BossUnit("Shifu Robot", 5, 1, 0, -1);
        assertEquals(expectedShifuRobot, shifuRobot);
    }

    /**
     * Tests getter and setter of hp field.
     */
    @Test
    public void bossHpTest() {
        abstractHpTest(shifuRobot);
        abstractHpTest(flyingCastle);
    }

    /**
     * Tests increase method.
     */
    @RepeatedTest(100)
    public void increaseBossTest() {
        increaseConsistencyTest(shifuRobot);
        increaseConsistencyTest(flyingCastle);
    }

    /**
     * Tests reduce methods.
     */
    @RepeatedTest(100)
    public void reduceBossTest() {
        reduceConsistencyTest(shifuRobot);
        reduceConsistencyTest(flyingCastle);
    }

    /**
     * Test hp getter and setter consistency.
     */
    @RepeatedTest(100)
    public void hpConsistencyBossTest() {
        hitPointsConsistencyTest(shifuRobot);
        hitPointsConsistencyTest(flyingCastle);
    }

    /**
     * Tests roll method.
     */
    @RepeatedTest(100)
    public void rollBossConsistencyTest() {
        rollConsistencyTest(shifuRobot);
        rollConsistencyTest(flyingCastle);
    }


}
