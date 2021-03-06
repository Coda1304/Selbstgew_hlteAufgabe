import org.junit.Before;
import org.junit.Test;

/**
 * Created by Adrian on 21/12/15.
 */
public class SimpleVisitorTest {
    Betreiber enBW = new Betreiber("EnBW");
    Windpark baltic = new Windpark("Baltic");
    SimpleVisitor visitor = new SimpleVisitor();
    Turbine eT = new Turbine(12,5000);
    Turbine eZ = new Turbine(30,100);

    Betreiber eon = new Betreiber("Eon");
    Windpark nordsee = new Windpark("Nordsee");
    Turbine nT = new Turbine(25,4000);
    Turbine nZ = new Turbine(13,1300);

    @Before
    public void setUp() throws Exception {
        baltic.addTurbine(eZ);
        baltic.addTurbine(eT);
        enBW.addWindpark(baltic);

        nordsee.addTurbine(nT);
        nordsee.addTurbine(nZ);
        eon.addWindpark(nordsee);
    }

    @Test
    public void testVisitTurbine() throws Exception {
        eT.accept(visitor);
    }

    @Test
    public void testVisitWindpark() throws Exception {
        baltic.accept(visitor);
    }

    @Test
    public void testVisitBetreiber() throws Exception {
        enBW.accept(visitor);
        eon.accept(visitor);

    }
}