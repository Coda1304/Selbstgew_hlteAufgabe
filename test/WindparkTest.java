import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 21/12/15.
 */
public class WindparkTest {

    Windpark park = new Windpark("Baltic");
    Turbine T = new Turbine(12,5000);
    Turbine Z = new Turbine(30,100);

    @Before
    public void setUp() throws Exception {
        park.addTurbine(T);
    }


    @Test
    public void testGetPower() throws Exception {
        assertEquals(5000 , park.getPower() );
        park.addTurbine(Z);
        assertEquals(5100,park.getPower());

    }

    @Test
    public void testGetFoerderung() throws Exception {
        assertEquals(12 , park.getFoerderung() );
        park.addTurbine(Z);
        assertEquals(42, park.getFoerderung());
    }

    @Test
    public void testGetAdvancement() throws Exception {
        assertEquals(216000 , park.getEEGAdvancement() );
        park.addTurbine(Z);
        assertEquals(226800, park.getEEGAdvancement());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Baltic" , park.getName() );
    }
}