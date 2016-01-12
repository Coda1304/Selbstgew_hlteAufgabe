import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 08/01/16.
 */
public class SortedVisitor implements EnergyVisitor {

    private Betreiber aktBetr;
    private Windpark aktWindpark;
    private List<sortedTurbine> turbines = new ArrayList<sortedTurbine>();

    @Override
    public void visit(Betreiber betreiber) {
        aktBetr = betreiber;
        for (EnergyProducer producer : betreiber.getProducers()){
            producer.accept(this);
        }
        aktBetr=null;
    }

    @Override
    public void visit(Windpark windpark) {
        aktWindpark = windpark;
        for (EnergyProducer t : windpark.getTurbinen() ){
            t.accept(this);
        }
        aktWindpark=null;
    }

    @Override
    public void visit(Turbine turbine) {
        turbines.add(new sortedTurbine(aktBetr,aktWindpark,turbine));
    }

    private class sortedTurbine {
        private Betreiber betreiber;
        private Windpark windpark;
        private Turbine turbine;

        public sortedTurbine(Betreiber betreiber, Windpark windpark, Turbine turbine) {
            this.betreiber = betreiber;
            this.windpark = windpark;
            this.turbine = turbine;
        }
    }
}
