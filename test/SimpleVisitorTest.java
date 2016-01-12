import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 21/12/15.
 */
public class SimpleVisitorTest {
    Betreiber b = new Betreiber("EnBW");
    Windpark park = new Windpark("Baltic");
    SimpleVisitor visitor = new SimpleVisitor();
    Turbine T = new Turbine(12,5000);
    Turbine Z = new Turbine(30,100);

    @Before
    public void setUp() throws Exception {
        park.addTurbine(Z);
        park.addTurbine(T);
        b.addWindpark(park);
    }

    @Test
    public void testVisitTurbine() throws Exception {
        T.accept(visitor);
    }

    @Test
    public void testVisitWindpark() throws Exception {
        park.accept(visitor);
    }

    @Test
    public void testVisitBetreiber() throws Exception {
        b.accept(visitor);

    }
}