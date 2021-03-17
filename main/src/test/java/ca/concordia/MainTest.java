package ca.concordia;

import ca.concordia.dao.*;
import ca.concordia.gameengine.GameEngineTest;
import ca.concordia.mapworks.MapEditorTest;
import ca.concordia.mapworks.ValidateMapTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BorderTest.class,
        ContinentTest.class,
        CountryTest.class,
        Order2Test.class,
        PlayerTest.class,
        GameEngineTest.class,
        PlayerActionsTest.class,
        MapEditorTest.class,
        ValidateMapTest.class
})
public class MainTest extends TestCase {

    public MainTest(String testname) {

        super(testname);
    }

    public static Test suite() {

        return new TestSuite(MainTest.class);

    }

    public void testApp() {

        assertTrue(true);
    }

}