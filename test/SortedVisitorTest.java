import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 12/01/16.
 */
public class SortedVisitorTest {
    Betreiber enBW = new Betreiber("EnBW");
    Windpark baltic = new Windpark("Baltic");
    SortedVisitor visitor = new SortedVisitor();
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
        enBW.addWindpark(nordsee);

        for(int i=0;i<10;i++){
            long foerderung = (long) (Math.random()*30);
            long power = (long) (Math.random()*10000);

            baltic.addTurbine(new Turbine(foerderung,power));
        }
    }

    @Test
    public void testIt() throws Exception {
        enBW.accept(visitor);
    }

}