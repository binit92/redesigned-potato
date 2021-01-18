
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;


/*
 JUnit test class to verify maps
 */

public class MapTest {
    File f = new File("D:\\redesigned-potato\\maps\\canada\\canada.map");

    @Test
    public void test1() {
        MapTest map=new MapTest();
        int num = map.verifyContinents(f); //we need to make method "verifyContinents"
        assertEquals(1, num);
    }




    @Test
    public void test2() {
        MapTest map = new MapTest();
        int num = map.verifyContinents(f);
        assertEquals(1, num);
    }


    @Test
    public void test3() {
        MapTest map = new MapTest();
        int num = map.verifyCountries(f);  //we need to make method "verifyCountries"
        assertEquals(1, num);
    }
 
   @Test
    public void test4() {
        MapTest map = new MapTest();
        int num = map.verifyCountries(f);  
        assertEquals(1, num);
    }

    private int verifyContinents(File f) {
        return 1;
    }

    private int verifyCountries(File f) {
        return 1;
    }
}
