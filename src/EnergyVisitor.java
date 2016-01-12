/**
 * Created by Adrian on 21/12/15.
 */
public interface EnergyVisitor {
    void visit( Betreiber betreiber );

    void visit( Windpark windpark);

    void visit( Turbine turbine );

}
