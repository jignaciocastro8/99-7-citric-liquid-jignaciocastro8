package com.github.cc3002.citricjuice.model.character;

import com.github.cc3002.citricjuice.model.gameCharacters.Player;
import com.github.cc3002.citricjuice.model.gameCharacters.WildUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WildUnitTest {
    private WildUnit chicken;
    @BeforeEach
    public void setUp() {
        chicken = new WildUnit("Chicken", 3, -1, -1, 1);
    }
    @Test
    public void constructorTest() {
        WildUnit expectedChicken = new WildUnit("Chicken", 3, -1, -1, 1);
        assertEquals(expectedChicken, chicken);
    }

    @Test
    public void testEquals() {
        final var o = new Object();
        assertNotEquals(chicken, o);
        assertEquals(chicken, chicken);
        final var expectedChicken = new WildUnit("Chicken", 3, -1, -1, 1);
        assertEquals(expectedChicken, chicken);
    }
    @Test
    public void hitPointsTest() {
        int maxHp = chicken.getCurrentHP();
        assertEquals(chicken.getMaxHP(), chicken.getCurrentHP());
        chicken.setCurrentHP(2);
        assertEquals(2, chicken.getCurrentHP());
        chicken.setCurrentHP(-1);
        assertEquals(0, chicken.getCurrentHP());
        chicken.setCurrentHP(8);
        assertEquals(maxHp, chicken.getCurrentHP());
        assertEquals(chicken.getMaxHP(), chicken.getCurrentHP());
    }
}
