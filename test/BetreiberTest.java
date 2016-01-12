import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 21/12/15.
 */
public class BetreiberTest {

    Betreiber b = new Betreiber("EnBW");
    Windpark park = new Windpark("Baltic");
    SimpleVisitor visitor = new SimpleVisitor();
    Turbine T = new Turbine(12,5000);
    Turbine Z = new Turbine(30,100);

    @Before
    public void setUp() throws Exception {
        park.addTurbine(T);
        b.addWindpark(park);
    }

    @Test
    public void testGetOutput() throws Exception {
        assertEquals(5000,b.getOutput());
        park.addTurbine(Z);
        assertEquals(5100,b.getOutput());
    }

    @Test
    public void testGetFoerderung() throws Exception {
        assertEquals(12, b.getFoerderung() );
        park.addTurbine(Z);
        assertEquals(42, b.getFoerderung());
    }

    @Test
    public void testAccept() throws Exception {

    }
}