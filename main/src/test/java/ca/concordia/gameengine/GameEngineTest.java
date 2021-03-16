package ca.concordia.gameengine;


import ca.concordia.gameengine.GameEngine;
import ca.concordia.dao.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Game Engine test class
 */
public class GameEngineTest {

    Map d_Map;
    GameEngine d_GameEngine;

    /**
     * This is the method to be run before test method. It initializes the GameEngine class object
     */
    @Before
    public void before() {
        d_GameEngine = new GameEngine();
    }

    /**
     * test adding and removing game players
     */
    @Test
    public void testAddRemovePlayer() {
        assertEquals(true, d_GameEngine.addPlayer("player1"));
        assertEquals(true, d_GameEngine.removePlayer("player1"));
    }

    /**
     * Test failing of assign countries as the map is empty
     */
    @Test
    public void testAssignCoutnies() {
        assertEquals(false, d_GameEngine.assignCountries());
    }


}
