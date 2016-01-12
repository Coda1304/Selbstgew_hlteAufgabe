import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 21/12/15.
 */
public class BetreiberTest {

    Betreiber enBW = new Betreiber("EnBW");
    Windpark baltic = new Windpark("Baltic");
    SimpleVisitor visitor = new SimpleVisitor();
    Turbine T = new Turbine(12,5000);
    Turbine Z = new Turbine(30,100);
    Windpark baltic2 = new Windpark("Baltic 2");

    @Before
    public void setUp() throws Exception {
        baltic.addTurbine(T);
        enBW.addWindpark(baltic);
    }

    @Test
    public void testGetPower() throws Exception {
        assertEquals(5000, enBW.getPower());
        baltic.addTurbine(Z);
        assertEquals(5100, enBW.getPower());
    }

    @Test
    public void testGetFoerderung() throws Exception {
        assertEquals(12, enBW.getFoerderung() );
        baltic.addTurbine(Z);
        assertEquals(42, enBW.getFoerderung());
    }

    @Test
    public void testGetAdvancement() throws Exception {
        assertEquals(216000, enBW.getEEGAdvancement() );
        baltic.addTurbine(Z);
        assertEquals(226800, enBW.getEEGAdvancement());
        enBW.addWindpark(baltic2);
        baltic2.addTurbine(T);
        assertEquals(442800, enBW.getEEGAdvancement());
    }

    @Test
    public void testAccept() throws Exception {

    }
}