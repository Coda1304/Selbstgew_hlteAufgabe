import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrian on 12/01/16.
 */
public class CommandManagerTest {
    Betreiber enBW = new Betreiber("EnBW");
    Windpark baltic = new Windpark("Baltic");
    SimpleVisitor visitor = new SimpleVisitor();
    Turbine eT = new Turbine(12,5000);
    Turbine eZ = new Turbine(30,100);

    Betreiber eon = new Betreiber("Eon");
    Windpark nordsee = new Windpark("Nordsee");
    Turbine nT = new Turbine(25,4000);
    Turbine nZ = new Turbine(13,1300);

    CommandManager test = new CommandManager();

    @Before
    public void setUp() throws Exception {
        enBW.addWindpark(baltic);
        eon.addWindpark(nordsee);
    }

    @Test
    public void testRun() throws Exception {

        assertEquals(0,baltic.getPower());
        test.run(new AddTurbine(eT,baltic));
        test.run(new AddTurbine(eZ,baltic));
        assertEquals(5100,baltic.getPower());

        test.run(new DeleteTurbine(eZ,baltic));
        assertEquals(5000,baltic.getPower());

        test.run(new ReplaceTurbine(eT,baltic,nT));
        assertEquals(4000,baltic.getPower());

        test.undo(); //undo ReplaceCommand
        assertEquals(5000,baltic.getPower());
        test.undo(); //undo DeleteCommand
        assertEquals(5100,baltic.getPower());
        test.undo(); //undo AddCommand second
        assertEquals(5000,baltic.getPower());
        test.undo(); //undo AddCommand first
        assertEquals(0,baltic.getPower());

    }
}